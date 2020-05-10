package com.tyss.capgemini.loanproject.dao;

public interface CustomerDaoDeclaration {
	public boolean viewLoanPrograms();
	public boolean changePassword(String custUsername, String newPass);
	public boolean checkBalance(String custUsername);
	public boolean loanApplicationForm(String applicationId, String accountNo, String email, String applicantFirstName,
			String applicantMiddleName, String applicantLastName, String dateOfBirth, String coapplicantFirstName,
			String coapplicantMiddleName, String coapplicantLastName, String loanChoice, String branchCode,
			String branchName, String openDate, String requestDate, String loanAmount);
	public boolean payLoan(String custUsername, Double loanPay);
	public boolean checkLoan(String custUsername);
	public boolean loanTypes();
	public String loanTypes(int k);
	public boolean viewApplications(String custUsername);
	public boolean emailExists(String email);
	public boolean usernameExists(String username);
	public boolean applicationExist(String id);
	public String fetchMail(String username);
	public String fetchFirstName(String username);
	public String fetchLastName(String username);
	public Double returnBal(String username);
	public String autoGenerateId();
	
}
