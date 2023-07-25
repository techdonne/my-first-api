package com.techdonne.myapi.demo.controllers.exceptions;

import com.techdonne.myapi.demo.services.exceptions.UsuarioException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ServletResponseMethodArgumentResolver;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(UsuarioException.class)
    public ResponseEntity<StandardError> objectNotFound(UsuarioException e, HttpServletRequest request){
        StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(), System.currentTimeMillis(), e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
