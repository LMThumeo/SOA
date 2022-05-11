package com.example.btl.exception;

import com.example.btl.exception.common.CommonException;

public class ReexaminationNotFoundException extends CommonException {
    public ReexaminationNotFoundException(){
        super(404, "reexamination not found");
    }
}
