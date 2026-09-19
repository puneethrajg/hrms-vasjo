package com.vasjo.hrms.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vasjo.hrms.dto.ErrorResponseDTO;


@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponseDTO> handleValidationException(
	        MethodArgumentNotValidException ex) {
		
			ErrorResponseDTO error = new ErrorResponseDTO(
					"Validation Failed!",
					"VALIDATION"
				);
		
	 return ResponseEntity
	            .badRequest()
	            .body(error);
	}
	
}
