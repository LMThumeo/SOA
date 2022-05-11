package com.example.btl.exception;

import com.example.btl.exception.common.CommonException;

public class ReexaminationExistedException extends CommonException {
    public ReexaminationExistedException() {
        super(409, "reexamination of this subject is existed");
    }
}
