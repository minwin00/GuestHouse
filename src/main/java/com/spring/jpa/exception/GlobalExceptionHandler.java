package com.spring.jpa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleUserException(UserException ex) {
		return ex.getMessage();
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String handleGeneralException(Exception ex) {
		return "서버 오류가 발생했습니다: " + ex.getMessage(); 
	}
}
