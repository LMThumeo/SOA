package com.example.btl.controller.advice;


import com.example.btl.exception.common.StudentServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class StudentControllerAdvice {

    @ExceptionHandler(value = StudentServiceException.class)
    public ResponseEntity<String> StudentServiceExceptionHandle(StudentServiceException e) {
        return new ResponseEntity<>(
                e.getServiceError().getErrorMessage(),
                HttpStatus.valueOf(e.getServiceError().getErrorCode())
        );
    }
}