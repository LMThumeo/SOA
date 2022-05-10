package com.example.btl.controller;

import com.example.btl.service.SemsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/semesters")
@CrossOrigin("*")
public class SemesterController {

    final private SemsterService semsterService;

    @Autowired
    public SemesterController(SemsterService semsterService) {
        this.semsterService = semsterService;
    }

    @GetMapping()
    public ResponseEntity<?> getAllSemester(){
        return new ResponseEntity<>(semsterService.getAll(), HttpStatus.OK);
    }
}
