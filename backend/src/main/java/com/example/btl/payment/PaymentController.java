package com.example.btl.payment;

import com.example.btl.dto.ReexaminationDTO;
import com.example.btl.entity.Reexamination;
import com.example.btl.service.ReexaminationService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RestController
@RequestMapping("/api/v1/payment")
@CrossOrigin("*")
public class PaymentController {

    final private PaypalService service;
    final private ReexaminationService reexaminationService;

    public static final String SUCCESS_URL = "/success";
    public static final String CANCEL_URL = "/cancel";

    @Autowired
    public PaymentController(PaypalService service, ReexaminationService reexaminationService) {
        this.service = service;
        this.reexaminationService = reexaminationService;
    }

    @PostMapping()
    public ResponseEntity<?> payment(@RequestBody Bill bill) {
        try {
            String redirectUrl = "http://localhost:8081/api/v1/payment";
            String paramUrl = "?studentId="+bill.getStudentId()+
                                "&semesterId="+bill.getSemesterId()+
                                "&subjectId="+bill.getSubjectId();
            Payment payment = service.createPayment(bill.getPrice(), bill.getCurrency(), bill.getMethod(),
                    bill.getIntent(), bill.getDescription(), redirectUrl+CANCEL_URL+paramUrl ,
                    redirectUrl+SUCCESS_URL+paramUrl);
            for(Links link:payment.getLinks()) {
                if(link.getRel().equals("approval_url")) {
                    System.out.println(link.getHref());
                    return new ResponseEntity<>(new PayPalResponse(link.getHref()), HttpStatus.OK);
                }
            }
        } catch (PayPalRESTException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new PayPalResponse("payment error"), HttpStatus.EXPECTATION_FAILED);
    }

    @GetMapping(value = CANCEL_URL)
    public ResponseEntity<?> cancelPay(@RequestParam int studentId,
                                      @RequestParam int semesterId,
                                      @RequestParam int subjectId,
                                      HttpServletResponse response ) throws IOException {
//        return  new ResponseEntity<>(new PayPalResponse("payment error"), HttpStatus.EXPECTATION_FAILED);
        String status = "PENDING";
        System.out.println("cancel");
        ReexaminationDTO newReexamination = reexaminationService.submitForm(studentId, semesterId, subjectId, status);
        return new ResponseEntity<>("pending payment", HttpStatus.OK);
    }

    @GetMapping(value = SUCCESS_URL)
    public ResponseEntity<?> successPay(@RequestParam int studentId,
                                        @RequestParam int semesterId,
                                        @RequestParam int subjectId,
                                        @RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
        try {

            Payment payment = service.executePayment(paymentId, payerId);
            System.out.println(payment.toJSON());
            if (payment.getState().equals("approved")) {
                System.out.println("success");
                String status = "ACCEPT";
                ReexaminationDTO newReexamination = reexaminationService.submitForm(studentId, semesterId, subjectId, status);
                return new ResponseEntity<>("success payment", HttpStatus.OK);
            }
        } catch (PayPalRESTException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("error");
        String status = "PENDING";
        return new ResponseEntity<>("error payment", HttpStatus.EXPECTATION_FAILED);
    }
}
