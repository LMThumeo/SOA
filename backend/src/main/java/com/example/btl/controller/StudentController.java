package com.example.btl.controller;

import com.example.btl.dto.StudentDTO;
import com.example.btl.dto.StudentLoginDTO;
import com.example.btl.dto.TranscriptLineDTO;
import com.example.btl.service.StudentService;
import com.example.btl.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    final private StudentService studentService;
    final private SubjectService subjectService;

    @Autowired
    public StudentController(StudentService studentService, SubjectService subjectService) {
        this.studentService = studentService;
        this.subjectService = subjectService;
    }

    @GetMapping
    public ResponseEntity<?> login(@RequestBody StudentLoginDTO studentLogin) {
        StudentDTO studentDTO = studentService.login(studentLogin);
        return new ResponseEntity<>(studentDTO, HttpStatus.OK);
    }

//    @GetMapping("/{id}/form")
//    public ResponseEntity<?> getInformation(@PathVariable("id") int studentId) {
//        List<TranscriptLineDTO> transcriptLineDTO = studentService.getInformation(studentId);
//        return new ResponseEntity<>(transcriptLineDTO, HttpStatus.OK);
//    }
}
