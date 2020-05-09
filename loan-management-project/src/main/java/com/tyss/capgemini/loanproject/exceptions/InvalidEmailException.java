package com.tyss.capgemini.loanproject.exceptions;

@SuppressWarnings("serial")
public class InvalidEmailException extends RuntimeException {
	public InvalidEmailException(String msg){
		super(msg);
	}
}
