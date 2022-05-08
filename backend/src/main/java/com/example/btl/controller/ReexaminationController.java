package com.example.btl.controller;

import com.example.btl.service.ReexaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/reexaminations")
public class ReexaminationController {

    final private ReexaminationService reexaminationService;

    @Autowired
    public ReexaminationController(ReexaminationService reexaminationService) {
        this.reexaminationService = reexaminationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getReexaminationByStudent(@PathVariable("id") int studentId) {
        return new ResponseEntity<>(reexaminationService.getReexaminationByStudent(studentId), HttpStatus.OK);

    }

    @PostMapping("/{id}")
    public ResponseEntity<?> submitForm(@PathVariable("id") int studentId,
                                        @RequestParam int semesterId,
                                        @RequestParam int subjectId) {
        return new ResponseEntity<>(reexaminationService.submitForm(studentId, semesterId, subjectId), HttpStatus.CREATED);
    }
}
