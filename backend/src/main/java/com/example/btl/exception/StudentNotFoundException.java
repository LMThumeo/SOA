package com.example.btl.exception;

import com.example.btl.exception.common.StudentServiceError;
import com.example.btl.exception.common.StudentServiceException;

public class StudentNotFoundException extends StudentServiceException {
    public StudentNotFoundException() {
        super(StudentServiceError.STUDENT_NOT_FOUND);
    }
}
