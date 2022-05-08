package com.example.btl.service;

import com.example.btl.dto.StudentDTO;
import com.example.btl.dto.StudentLoginDTO;
import com.example.btl.dto.TranscriptLineDTO;

import java.util.List;

public interface StudentService {

    StudentDTO login(StudentLoginDTO studentLogin);

//    List<TranscriptLineDTO> getInformation(int studentId);
}
