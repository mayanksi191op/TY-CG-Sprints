package com.tyss.capgemini.loanproject.services;

public interface AdminServicesDeclaration {
	public boolean loanUpdate(String typechoice, int choice2, String choice3);
	public boolean insertLoan(String type, String time, String rates);
	public boolean deleteLoan(String loantype);
	public boolean viewLoanPrograms();
	public boolean addClients(String username,String email,String password,
			String firstname,String lastname,String phone);
	public boolean viewClients();
	public boolean approvedForms();
	public boolean rejectedForms();
	public boolean requestedForms();
	public boolean loanTypes();
	public String loanTypes(String k);
	public boolean emailExists(String email);
	public boolean usernameExists(String username);
	public String updateType(String loanType, String newType);
	public boolean updateTimePeriod(String loanType, String newTime);
	public boolean updateRates(String loanType, String newRate);
}
