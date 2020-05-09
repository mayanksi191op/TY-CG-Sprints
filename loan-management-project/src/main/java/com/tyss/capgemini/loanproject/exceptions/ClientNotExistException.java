package com.tyss.capgemini.loanproject.exceptions;

@SuppressWarnings("serial")
public class ClientNotExistException extends RuntimeException{
	public ClientNotExistException(String msg) {
		super(msg);
	}
}
