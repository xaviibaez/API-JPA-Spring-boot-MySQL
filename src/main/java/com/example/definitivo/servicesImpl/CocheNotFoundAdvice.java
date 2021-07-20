package com.example.definitivo.servicesImpl;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CocheNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(CocheNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(CocheNotFoundException ex) {
        return ex.getMessage();
    }
}
