package com.example.btl.exception;

import com.example.btl.exception.common.NotFoundException;

public class StudentNotFoundException extends NotFoundException {
    public StudentNotFoundException() {
        super(404, "Login failed");
    }
}
