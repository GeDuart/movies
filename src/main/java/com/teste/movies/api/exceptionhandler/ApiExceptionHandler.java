package com.teste.movies.api.exceptionhandler;

import com.teste.movies.domain.exception.AwardsNotFound;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(AwardsNotFound.class)
    public ResponseEntity<?> handleAwardsNotFound(AwardsNotFound ex,WebRequest webRequest){

        return  handleExceptionInternal(ex,ex.getMessage(),new HttpHeaders(), HttpStatus.NO_CONTENT,webRequest);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
        body = Problem.builder().dataHora(LocalDateTime.now()).message(ex.getMessage()).build();
        return super.handleExceptionInternal(ex, body, headers, statusCode, request);
    }
}
