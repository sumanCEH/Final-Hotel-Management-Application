package com.hma.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorExceptionHandler {

	    @ExceptionHandler
	    public ResponseEntity<ErrorResponse> handleException(DetailsNotFoundException dne){
	        ErrorResponse errorResponse = new ErrorResponse();
	        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
	        errorResponse.setMessage(dne.getMessage());
	        return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);
	    }
	    @ExceptionHandler
	    public ResponseEntity<ErrorResponse> handleException(Exception ex){
	        ErrorResponse errorResponse = new ErrorResponse();
	        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
	        errorResponse.setMessage(ex.getMessage());
	        return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.BAD_REQUEST);
	    }
}
