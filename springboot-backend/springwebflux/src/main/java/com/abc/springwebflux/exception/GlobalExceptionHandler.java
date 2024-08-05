package com.abc.springwebflux.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import reactor.core.publisher.Mono;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Mono<ApiError>> handleResourceNotFoundException(Exception ex) {
		
		ApiError apiError = new ApiError();		
		apiError.setMessage(ex.getMessage());
		apiError.setStatus(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<>(Mono.just(apiError),HttpStatus.NOT_FOUND);		
	}

}
