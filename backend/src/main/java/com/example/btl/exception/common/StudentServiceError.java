package com.example.btl.exception.common;

public enum StudentServiceError {
    STUDENT_NOT_FOUND(404, "Student code or password is incorrect");

    private final int errorCode;
    private final String errorMessage;

    private StudentServiceError(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
