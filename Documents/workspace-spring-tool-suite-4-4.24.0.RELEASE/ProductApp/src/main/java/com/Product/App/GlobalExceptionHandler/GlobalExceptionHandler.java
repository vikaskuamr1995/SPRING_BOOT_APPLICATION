package com.Product.App.GlobalExceptionHandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.Product.App.Exception.ExcelDownloadFailed;
import com.Product.App.response.errorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ExcelDownloadFailed.class)
	public ResponseEntity<errorResponse> exceptionHandler(ExcelDownloadFailed downloadFailed, WebRequest request) {

		errorResponse error = new errorResponse(request.getDescription(false), HttpStatus.BAD_REQUEST,
				downloadFailed.getMessage(), LocalDateTime.now());

		return new ResponseEntity<errorResponse>(error, HttpStatus.BAD_REQUEST);

	}
}
