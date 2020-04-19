package com.ECommerce.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {

	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity genericExceptionHandler(Exception ex) {
		return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(ex.getMessage());
	}

	@ExceptionHandler(value = { EntityNotFoundException.class })
	public ResponseEntity entityNotFound(EntityNotFoundException ex) {
		return ResponseEntity.status(ex.getErrCode()).body(ex.getErrMsg());
	}
}
