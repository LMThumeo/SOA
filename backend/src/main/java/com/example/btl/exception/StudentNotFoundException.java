package com.example.btl.exception;

import com.example.btl.exception.common.CommonException;

public class StudentNotFoundException extends CommonException {
    public StudentNotFoundException() {
        super(404, "Login failed");
    }
}
