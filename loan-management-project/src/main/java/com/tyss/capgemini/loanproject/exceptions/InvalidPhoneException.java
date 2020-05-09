package com.tyss.capgemini.loanproject.exceptions;

@SuppressWarnings("serial")
public class InvalidPhoneException extends RuntimeException {
	public InvalidPhoneException(String msg) {
		super(msg);
	}
}
