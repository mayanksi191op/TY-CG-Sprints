package com.tyss.capgemini.loanproject.exceptions;


@SuppressWarnings("serial")
public class InsufficientBalanceException extends RuntimeException {
	public InsufficientBalanceException(String msg) {
		super(msg);
	}
}
