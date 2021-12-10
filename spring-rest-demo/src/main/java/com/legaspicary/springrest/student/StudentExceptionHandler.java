package com.legaspicary.springrest.student;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentExceptionHandler {
	@ExceptionHandler
	private ResponseEntity<StudentErrorResponse> handleNotFoundException(NoSuchElementException e) {
		StudentErrorResponse msg = new StudentErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage(),
				System.currentTimeMillis());
		return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	private ResponseEntity<StudentErrorResponse> handleExceptions(Exception e) {
		StudentErrorResponse msg = new StudentErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage(),
				System.currentTimeMillis());
		return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
	}
}
