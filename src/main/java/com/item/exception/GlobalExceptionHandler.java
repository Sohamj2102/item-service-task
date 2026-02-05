package com.item.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ItemNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleItemNotFound(ItemNotFoundException ex){
		ErrorResponse error=ErrorResponse
												.builder()
												.status(HttpStatus.NOT_FOUND.value())
												.message(ex.getMessage())
												.timestamp(LocalDateTime.now())
												.build();
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
		@ExceptionHandler(Exception.class)
		public ResponseEntity<ErrorResponse> handleInternal(Exception ex){
			ErrorResponse error=ErrorResponse
													.builder()
													.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
													.message("Something went wrong. Please try again.")
													.timestamp(LocalDateTime.now())
													.build();
			return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
		@ExceptionHandler(MethodArgumentNotValidException.class)
		public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException ex){
			String message=ex.getBindingResult()
					.getFieldErrors()
					.stream()
					.map(error->error.getField()+": "+error.getDefaultMessage())
					.findFirst()
					.orElse("Validation error");
			ErrorResponse error=ErrorResponse
													.builder()
													.status(HttpStatus.BAD_REQUEST.value())
													.message(message)
													.timestamp(LocalDateTime.now())
													.build();
			return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
		
		
}
