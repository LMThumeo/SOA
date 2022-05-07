package com.example.btl.service.impl;

import com.example.btl.converter.MappingHelper;
import com.example.btl.dto.StudentDTO;
import com.example.btl.dto.StudentLoginDTO;
import com.example.btl.exception.StudentNotFoundException;
import com.example.btl.repository.StudentRepository;
import com.example.btl.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    final private StudentRepository studentRepository;
    final private MappingHelper mappingHelper;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, MappingHelper mappingHelper) {
        this.studentRepository = studentRepository;
        this.mappingHelper = mappingHelper;
    }

    @Override
    public StudentDTO login(StudentLoginDTO studentLogin) {
        return mappingHelper.map(
                studentRepository.findByStudentCodeAndPassword(studentLogin.getStudentCode(), studentLogin.getPassword()).orElseThrow(StudentNotFoundException::new),
                StudentDTO.class );
    }
}
