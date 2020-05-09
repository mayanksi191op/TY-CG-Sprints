package com.tyss.capgemini.loanproject.exceptions;

@SuppressWarnings("serial")
public class InvalidUsernameException extends RuntimeException {
	public InvalidUsernameException(String msg) {
		super(msg);
	}
}
