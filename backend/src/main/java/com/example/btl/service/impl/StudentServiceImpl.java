package com.example.btl.service.impl;

import com.example.btl.converter.MappingHelper;
import com.example.btl.dto.StudentDTO;
import com.example.btl.dto.StudentLoginDTO;
import com.example.btl.exception.StudentNotFoundException;
import com.example.btl.repository.*;
import com.example.btl.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    final private StudentRepository studentRepository;
    final private TranscriptLineRepository transcriptLineRepository;
    final private StudyClassRepository studyClassRepository;
    final private SubjectSemesterRepository subjectSemesterRepository;
    final private SemesterRepository semesterRepository;
    final private SubjectRepository subjectRepository;
    final private MappingHelper mappingHelper;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, TranscriptLineRepository transcriptLineRepository, StudyClassRepository studyClassRepository, SubjectSemesterRepository subjectSemesterRepository, SemesterRepository semesterRepository, SubjectRepository subjectRepository, MappingHelper mappingHelper) {
        this.studentRepository = studentRepository;
        this.transcriptLineRepository = transcriptLineRepository;
        this.studyClassRepository = studyClassRepository;
        this.subjectSemesterRepository = subjectSemesterRepository;
        this.semesterRepository = semesterRepository;
        this.subjectRepository = subjectRepository;
        this.mappingHelper = mappingHelper;
    }

    @Override
    public StudentDTO login(StudentLoginDTO studentLogin) {
        return mappingHelper.map(
                studentRepository.findByStudentCodeAndPassword(studentLogin.getStudentCode(), studentLogin.getPassword()).orElseThrow(StudentNotFoundException::new),
                StudentDTO.class );
    }

//    @Override
//    public List<TranscriptLineDTO> getInformation(int studentId) {
//        return mappingHelper.mapList(
//                transcriptLineRepository.findByStudentId(studentId),
//                TranscriptLineDTO.class);
//    }
}
