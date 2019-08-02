package com.example.crud.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.crud.exceptionHandler.EmployeeNotfoundException;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(value = EmployeeNotfoundException.class)
	   public ResponseEntity<Object> exception(EmployeeNotfoundException exception) {
	      return new ResponseEntity<>("Record not found", HttpStatus.NOT_FOUND);
	   }
	
}
