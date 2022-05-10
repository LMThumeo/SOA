package com.example.btl.controller;

import com.example.btl.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/subjects")
@CrossOrigin("*")
public class SubjectController {

    final private SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping()
    public ResponseEntity<?> getSubjectOfStudent(@RequestParam int studentId,
                                                 @RequestParam int semesterId) {
        return new ResponseEntity<>(subjectService.getSubjectByStudentAndSemester(studentId, semesterId), HttpStatus.OK);
    }

    @GetMapping("/{id}/study_class")
    public ResponseEntity<?> getStudyClassOfStudent(@PathVariable("id") int subjectId,
                                                    @RequestParam int semesterId,
                                                    @RequestParam int studentId) {
        return new ResponseEntity<>(subjectService.getStudyClassBySubject(studentId, semesterId, subjectId), HttpStatus.OK);
    }
}
