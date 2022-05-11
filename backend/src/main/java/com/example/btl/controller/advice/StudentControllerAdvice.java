package com.example.btl.controller.advice;


import com.example.btl.exception.common.CommonException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class StudentControllerAdvice {

    @ExceptionHandler(value = CommonException.class)
    public ResponseEntity<String> StudentServiceExceptionHandle(CommonException e) {
        return new ResponseEntity<>(
                e.getErrorMessage(),
                HttpStatus.valueOf(e.getErrorCode())
        );
    }
}
