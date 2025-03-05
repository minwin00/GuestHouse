package com.spring.jpa.exception;

public class GuestHouseSearchException extends Exception{
	public GuestHouseSearchException() {
		this("This is GuestHouseSearhException...");
	}

	public GuestHouseSearchException(String message) {
		super(message);
	}
}
