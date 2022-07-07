package com.palash.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.palash.springdemo.entity.StudentErrorResponse;

@ControllerAdvice
public class StudentRestExceptionHandler {

	// add exception handline code here
	// add an exception handler using @ExceptionHandler for StudentNotFoundException
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handlerException(StudentNotFoundException e) {

		// create a new StudentErrorResponse

		StudentErrorResponse error = new StudentErrorResponse();

		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	// add an exception handler to catch any other exception
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception e) {
		StudentErrorResponse error = new StudentErrorResponse();

		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(e.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
