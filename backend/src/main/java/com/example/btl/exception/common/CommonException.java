package com.example.btl.exception.common;

import lombok.Getter;

@Getter
public abstract class CommonException extends RuntimeException {
//    private final StudentServiceError studentServiceError;
//
//    protected CommonException(StudentServiceError studentServiceError) {
//        super();
//        this.studentServiceError = studentServiceError;
//    }
//
//    public StudentServiceError getServiceError() {
//        return studentServiceError;
//    }
    private final int errorCode;
    private final String errorMessage;

    protected CommonException(int errorCode, String errorMessage) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
