package com.hma.demo.exception;


public class DetailsNotFoundException extends RuntimeException{

	public DetailsNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DetailsNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DetailsNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
