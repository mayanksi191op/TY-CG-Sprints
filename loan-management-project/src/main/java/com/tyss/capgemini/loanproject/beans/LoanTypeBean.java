package com.tyss.capgemini.loanproject.beans;

import java.io.Serializable;

import lombok.Data;

@Data
@SuppressWarnings("serial")
public class LoanTypeBean implements Serializable {
	
	private String loanType;
	private String timePeriod;
	private String interestRates;
	
	public LoanTypeBean(String loanType, String timePeriod, String interestRates) {
		super();
		this.loanType = loanType;
		this.timePeriod = timePeriod;
		this.interestRates = interestRates;
	}
}
