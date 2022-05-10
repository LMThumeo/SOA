package com.example.btl.exception;

import com.example.btl.exception.common.NotFoundException;

public class ReexaminationNotFoundException extends NotFoundException {
    public ReexaminationNotFoundException(){
        super(404, "reexamination not found");
    }
}
