package com.example.btl.controller;

import com.example.btl.dto.ReexaminationDTO;
import com.example.btl.service.ReexaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reexaminations")
@CrossOrigin("*")
public class ReexaminationController {

    final private ReexaminationService reexaminationService;

    @Autowired
    public ReexaminationController(ReexaminationService reexaminationService) {
        this.reexaminationService = reexaminationService;
    }

    @GetMapping()
    public ResponseEntity<?> getReexaminationByStudent(@RequestParam int studentId) {
        return new ResponseEntity<>(reexaminationService.getReexaminationByStudent(studentId), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(reexaminationService.getAllReexamination(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> submitForm(@RequestParam int studentId,
                                        @RequestParam int semesterId,
                                        @RequestParam int subjectId,
                                        @RequestParam String status) {
        return new ResponseEntity<>(reexaminationService.submitForm(studentId, semesterId, subjectId, status ), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<?> editPoint(@RequestBody ReexaminationDTO reexaminationDTO) {
        return new ResponseEntity<>(reexaminationService.updatePointReexamination(reexaminationDTO), HttpStatus.OK);
    }
}
