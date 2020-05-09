package com.tyss.capgemini.loanproject.exceptions;

@SuppressWarnings("serial")
public class LoanExcessException extends RuntimeException {
	public LoanExcessException(String msg) {
		super(msg);
	}
}
