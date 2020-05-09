package com.tyss.capgemini.loanproject.beans;

import java.io.Serializable;

import lombok.Data;

@Data
@SuppressWarnings("serial")
public class LoanApplicationBean implements Serializable {
	
	private String applicationId;
	private String email;
	private String loanType;
	private String timePeriod;
	private String interestRates;
	private String accountNo;
	private String applicantFirstName;
	private String applicantMiddleName;
	private String applicantLastName;
	private String dateOfBirthString;
	private String coapplicantFirstName;
	private String coapplicantMiddleName;
	private String coapplicantLastName;
	private String dateOfBirth;
	private String loanChoice;
	private String branchCode;
	private String branchName;
	private String openDate;
	private String requestDate;
	private String loanAmount;
	private String formStatus;
	
	public LoanApplicationBean(String applicationId, String accountNo, String email, String applicantFirstName, String applicantMiddleName, String applicantLastName, String dateOfBirth,
			String coapplicantFirstName, String coapplicantMiddleName, String coapplicantLastName,
			String loanChoice, String branchCode, String branchName, String openDate, String requestDate, String formStatus, String loanAmount) {
		super();
		this.email = email;
		this.applicationId = applicationId;
		this.accountNo = accountNo;
		this.applicantFirstName = applicantFirstName;
		this.applicantMiddleName = applicantMiddleName;
		this.applicantLastName = applicantLastName;
		this.dateOfBirth = dateOfBirth;
		this.coapplicantFirstName = coapplicantFirstName;
		this.coapplicantMiddleName = coapplicantMiddleName;
		this.coapplicantLastName = coapplicantLastName;
		this.loanChoice = loanChoice;
		this.branchCode = branchCode;
		this.branchName = branchName;
		this.openDate = openDate;
		this.requestDate = requestDate;
		this.formStatus = formStatus;
		this.loanAmount = loanAmount;
	}
}
