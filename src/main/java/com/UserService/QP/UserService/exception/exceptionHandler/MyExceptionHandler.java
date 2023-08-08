package com.UserService.QP.UserService.exception.exceptionHandler;


import com.UserService.QP.UserService.exception.exceptionResponse.ExceptionResponse;
import com.UserService.QP.UserService.exception.myexception.ResourceExistsException;
import com.UserService.QP.UserService.exception.myexception.ResultNotFoundException;
import com.UserService.QP.UserService.exception.myexception.EmptyResultException;
import com.UserService.QP.UserService.exception.myexception.WrongInputException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmptyResultException.class)
    public ResponseEntity<Object> handleEmptyResult(EmptyResultException ex , WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setDateTime(LocalDateTime.now());
        exceptionResponse.setMessage(ex.getMessage());
        ResponseEntity<Object> responseEntity = new ResponseEntity<>(exceptionResponse, HttpStatus.OK);
        return responseEntity;
    }

    @ExceptionHandler(ResourceExistsException.class)
    public ResponseEntity<Object> handleAlreadyExists(ResourceExistsException ex , WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setDateTime(LocalDateTime.now());
        exceptionResponse.setMessage(ex.getMessage());
        ResponseEntity<Object> responseEntity = new ResponseEntity<>(exceptionResponse, HttpStatus.CONFLICT);
        return responseEntity;
    }

    @ExceptionHandler(WrongInputException.class)
    public ResponseEntity<Object> handleWrongInputData(WrongInputException ex , WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setDateTime(LocalDateTime.now());
        exceptionResponse.setMessage(ex.getMessage());
        ResponseEntity<Object> responseEntity = new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

    @ExceptionHandler(ResultNotFoundException.class)
    public ResponseEntity<Object> handleNotFound(ResultNotFoundException ex , WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setDateTime(LocalDateTime.now());
        exceptionResponse.setMessage(ex.getMessage());
        ResponseEntity<Object> responseEntity = new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
        return responseEntity;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAll(Exception ex , WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setDateTime(LocalDateTime.now());
        exceptionResponse.setMessage("Something went wrong from the server side , please try again later");
        ResponseEntity<Object> responseEntity = new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;
    }

}