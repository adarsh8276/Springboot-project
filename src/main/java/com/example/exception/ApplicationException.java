package com.example.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
//@AllArgsConstructor
public class ApplicationException extends RuntimeException{
private String msg;
public ApplicationException(String msg) {
	super(msg);
}
}
