package com.example.btl.controller;

import com.example.btl.dto.StudentDTO;
import com.example.btl.dto.StudentLoginDTO;
import com.example.btl.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    final private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<?> login(@RequestBody StudentLoginDTO studentLogin) {
        StudentDTO studentDTO = studentService.login(studentLogin);
        return new ResponseEntity<>(studentDTO, HttpStatus.OK);
    }
}
