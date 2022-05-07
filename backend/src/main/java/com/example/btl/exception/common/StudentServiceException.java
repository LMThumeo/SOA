package com.example.btl.exception.common;

public abstract class StudentServiceException extends RuntimeException {
    private final StudentServiceError studentServiceError;

    protected StudentServiceException(StudentServiceError studentServiceError) {
        super();
        this.studentServiceError = studentServiceError;
    }

    public StudentServiceError getServiceError() {
        return studentServiceError;
    }
}
