package com.app.exception;

public class FileNameNotFoundException extends RuntimeException{

	
	private static final long serialVersionUID = 1L;

	public FileNameNotFoundException() {
		super();
	}

	public FileNameNotFoundException(String message) {
		super(message + " not found");
	}

}
