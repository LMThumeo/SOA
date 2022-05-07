package com.example.btl.service;

import com.example.btl.dto.StudentDTO;
import com.example.btl.dto.StudentLoginDTO;

public interface StudentService {

    StudentDTO login(StudentLoginDTO studentLogin);
}
