package com.example.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
   @ExceptionHandler(Exception.class)
	public String handleException(Exception e) {
	   System.out.println("Exception handled...."+e.getMessage());
		return e.getMessage();
	}
}
