package com.employee.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.employee.exception.NoEmployeeExistedException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NoEmployeeExistedException.class)
	public ResponseEntity<?> handleException(NoEmployeeExistedException employeeExistedException) {
		return new ResponseEntity<>(employeeExistedException.getMessage(), HttpStatus.BAD_REQUEST);
	}

}
