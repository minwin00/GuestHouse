package com.spring.jpa.exception;


public class DMLException extends Exception{
	public DMLException() {
		this("This is DMLException...");
	}
	public DMLException(String message) {
		super(message);
	}
}
