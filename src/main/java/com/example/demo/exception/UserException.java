package com.example.demo.exception;

public class UserException extends RuntimeException {

	
	private static final long serialVersionUID = 847500838613349753L;
	
	public UserException(String message)
	{
		super(message);
	}
}
