package com.flight.aop;

 

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;

import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.context.request.WebRequest;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

 

import com.flight.exceptions.RecordAlreadyPresentException;

import com.flight.exceptions.RecordNotFoundException;

 

@ControllerAdvice

public class AppExceptionHandler extends ResponseEntityExceptionHandler{

 

              @ExceptionHandler(value = {RecordAlreadyPresentException.class, RecordNotFoundException.class})

              public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request){

                            

                             String errorMessage = ex.getLocalizedMessage();

                             if(errorMessage == null)

                                           errorMessage = ex.toString();

                             ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, errorMessage);

                            

                             return new ResponseEntity<Object>(apiError, HttpStatus.BAD_REQUEST);

              }

}