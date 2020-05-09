package com.tyss.capgemini.loanproject.dao;

import java.util.HashMap;
import java.util.LinkedHashMap;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.tyss.capgemini.loanproject.exceptions.InvalidDataException;
import com.tyss.capgemini.loanproject.repository.Repository;
import com.tyss.capgemini.loanproject.validation.ValidationClass;

public class AdminDaoImplementation implements AdminDaoDeclaration {
	Logger logger = LogManager.getLogger(AdminDaoImplementation.class);
	Repository repo = new Repository();
	ValidationClass validationClass = new ValidationClass();

	@Override
	public boolean loanUpdate(String typechoice, int choice2, String choice3) {
		for (int i = 0; i < Repository.loanTypeList.size(); i++) {
			if (typechoice.equalsIgnoreCase((String) Repository.loanTypeList.get(i).get("Type"))) {
				switch (choice2) {
				case 1:
					Repository.loanTypeList.get(i).put("Type", choice3);
					logger.info("Updated");
					return true;
				case 2:
					Repository.loanTypeList.get(i).put("Time-Period", choice3);
					logger.info("Updated");
					return true;
				case 3:
					Repository.loanTypeList.get(i).put("Interest-Rates", choice3);
					logger.info("Updated");
					return true;
				default:
					logger.info("Wrong choice, enter again: ");
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean insertLoan(String type, String time, String rates) {
		HashMap<String, Object> hashMap = new LinkedHashMap<String, Object>();
		hashMap.put("Type", type);
		hashMap.put("Time-Period", time + " years(Max)");
		hashMap.put("Interest-Rates", rates + " %");
		Repository.loanTypeList.add(hashMap);
		for (int j = 0; j < Repository.loanTypeList.size(); j++) {
			logger.info(Repository.loanTypeList.get(j));
		}
		return true;
	}

	@Override
	public boolean deleteLoan(String loantype) {
		for (int i = 0; i < Repository.loanTypeList.size(); i++) {
			if (loantype.equals(Repository.loanTypeList.get(i).get("Type"))) {
				Repository.loanTypeList.remove(i);
				logger.info("Loan Deleted");
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean viewLoanPrograms() {
		if (Repository.loanTypeList.size() != 0) {
			for (int k = 0; k < Repository.loanTypeList.size(); k++) {
				logger.info("**********************");
				logger.info("Type: " + Repository.loanTypeList.get(k).get("Type"));
				logger.info("Time Period: " + Repository.loanTypeList.get(k).get("Time-Period"));
				logger.info("Interest Rates: " + Repository.loanTypeList.get(k).get("Interest-Rates"));
				logger.info("**********************");
			}
			return true;
		} else
			return false;
	}

	@Override
	public boolean approvedForms() {
		if (Repository.loanFormList.size() != 0) {
			for (int i = 0; i < Repository.loanFormList.size(); i++) {
				if (((String) Repository.loanFormList.get(i).get("LoanStatus")).toLowerCase().equals("approved")) {
					logger.info("*******************************");
					logger.info("ApplicationId: " + Repository.loanFormList.get(i).get("ApplicationId"));
					logger.info("AccountNo: " + Repository.loanFormList.get(i).get("AccountNo"));
					logger.info("Email: " + Repository.loanFormList.get(i).get("Email"));
					logger.info("ApplicantName: " + Repository.loanFormList.get(i).get("ApplicantName"));
					logger.info("DateOfBirth: " + Repository.loanFormList.get(i).get("DateOfBirth"));
					logger.info("CoApplicantName: " + Repository.loanFormList.get(i).get("CoApplicantName"));
					logger.info("LoanType: " + Repository.loanFormList.get(i).get("LoanType"));
					logger.info("BranchCode: " + Repository.loanFormList.get(i).get("BranchCode"));
					logger.info("BranchName: " + Repository.loanFormList.get(i).get("BranchName"));
					logger.info("OpenDate: " + Repository.loanFormList.get(i).get("OpenDate"));
					logger.info("RequestDate: " + Repository.loanFormList.get(i).get("RequestDate"));
					logger.info("LoanStatus: " + Repository.loanFormList.get(i).get("LoanStatus"));
					logger.info("*******************************");
				}
			} return true;
		} else return false;
	}

	@Override
	public boolean rejectedForms() {
		if (Repository.loanFormList.size() != 0) {
			for (int i = 0; i < Repository.loanFormList.size(); i++) {
				if (((String) Repository.loanFormList.get(i).get("LoanStatus")).toLowerCase().equals("rejected")) {
					logger.info("*******************************");
					logger.info("ApplicationId: " + Repository.loanFormList.get(i).get("ApplicationId"));
					logger.info("AccountNo: " + Repository.loanFormList.get(i).get("AccountNo"));
					logger.info("Email: " + Repository.loanFormList.get(i).get("Email"));
					logger.info("ApplicantName: " + Repository.loanFormList.get(i).get("ApplicantName"));
					logger.info("DateOfBirth: " + Repository.loanFormList.get(i).get("DateOfBirth"));
					logger.info("CoApplicantName: " + Repository.loanFormList.get(i).get("CoApplicantName"));
					logger.info("LoanType: " + Repository.loanFormList.get(i).get("LoanType"));
					logger.info("BranchCode: " + Repository.loanFormList.get(i).get("BranchCode"));
					logger.info("BranchName: " + Repository.loanFormList.get(i).get("BranchName"));
					logger.info("OpenDate: " + Repository.loanFormList.get(i).get("OpenDate"));
					logger.info("RequestDate: " + Repository.loanFormList.get(i).get("RequestDate"));
					logger.info("LoanStatus: " + Repository.loanFormList.get(i).get("LoanStatus"));
					logger.info("*******************************");
				}
			} return true;
		} else return false;
	}

	@Override
	public boolean requestedForms() {
		if (Repository.loanFormList.size() != 0) {
			for (int i = 0; i < Repository.loanFormList.size(); i++) {
				if (((String) Repository.loanFormList.get(i).get("LoanStatus")).toLowerCase().equals("requested")) {
					logger.info("*******************************");
					logger.info("ApplicationId: " + Repository.loanFormList.get(i).get("ApplicationId"));
					logger.info("AccountNo: " + Repository.loanFormList.get(i).get("AccountNo"));
					logger.info("Email: " + Repository.loanFormList.get(i).get("Email"));
					logger.info("ApplicantName: " + Repository.loanFormList.get(i).get("ApplicantName"));
					logger.info("DateOfBirth: " + Repository.loanFormList.get(i).get("DateOfBirth"));
					logger.info("CoApplicantName: " + Repository.loanFormList.get(i).get("CoApplicantName"));
					logger.info("LoanType: " + Repository.loanFormList.get(i).get("LoanType"));
					logger.info("BranchCode: " + Repository.loanFormList.get(i).get("BranchCode"));
					logger.info("BranchName: " + Repository.loanFormList.get(i).get("BranchName"));
					logger.info("OpenDate: " + Repository.loanFormList.get(i).get("OpenDate"));
					logger.info("RequestDate: " + Repository.loanFormList.get(i).get("RequestDate"));
					logger.info("LoanStatus: " + Repository.loanFormList.get(i).get("LoanStatus"));
					logger.info("*******************************");
				}
			} return true;
		} else return false;
	}

	@Override
	public boolean addClients(String username,String email,String password,
			String firstname,String lastname,String phone) {
		HashMap<String, Object> regHashMap = new LinkedHashMap<String, Object>();
		regHashMap.put("password", password);
		regHashMap.put("username", username);
		regHashMap.put("email", email);
		regHashMap.put("firstname", firstname);
		regHashMap.put("lastname", lastname);
		regHashMap.put("phone", phone);
		regHashMap.put("role", "L.A.D");
		Repository.clientList.add(regHashMap);
		Repository.mainList.add(regHashMap);
		Repository.employeeList.add(regHashMap);
		return true;
	}


	@Override
	public boolean viewClients() {
		if (Repository.clientList.size() != 0) {
			for (int i = 0; i < Repository.clientList.size(); i++) {
				logger.info("***********************************");
				logger.info("Username: " + Repository.clientList.get(i).get("username"));
				logger.info("Password: " + Repository.clientList.get(i).get("password"));
				logger.info("Email: " + Repository.clientList.get(i).get("email"));
				logger.info("FirstName: " + Repository.clientList.get(i).get("firstname"));
				logger.info("LastName: " + Repository.clientList.get(i).get("lastname"));
				logger.info("Phone Number:" + Repository.clientList.get(i).get("phone"));
				logger.info("Role:" + Repository.clientList.get(i).get("role"));
				logger.info("***********************************");
			}
			return true;
		} else
			logger.info("No clients exist");
			return false;
	}
	
	@Override
	public boolean loanTypes() {
		for (int i = 0; i < Repository.loanTypeList.size(); i++) {
			logger.info((i+1) + "> " + Repository.loanTypeList.get(i).get("Type"));
		}
		return true;
	}
	
	@Override
	public String loanTypes(String k) {
		
		int j = Integer.parseInt(k);
		for (int i = 0; i < Repository.loanTypeList.size(); i++) {
			if ((i+1)==j) {
				return (String) Repository.loanTypeList.get(i).get("Type");
			}
		}
		logger.info("Invalid choice, enter again please!!!");
		return "invalid choice";
	}
	
	@Override
	public boolean emailExists(String email) {
		int count = 0;
		for (int i = 0; i < Repository.mainList.size(); i++) {
			if (email.equalsIgnoreCase((String) Repository.mainList.get(i).get("email"))) {
				count++;
			}
		}

		if (count > 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean usernameExists(String username) {
		for (int i = 0; i < Repository.mainList.size(); i++) {
			if (username.equalsIgnoreCase((String) Repository.mainList.get(i).get("username"))) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String updateType(String loanType, String newType) {
		logger.info(newType);
		logger.info(loanType);
		for (int i = 0; i < Repository.loanTypeList.size(); i++) {
			if (loanType.equalsIgnoreCase((String) Repository.loanTypeList.get(i).get("Type"))) {
				Repository.loanTypeList.get(i).put("Type", newType);
				return (String) Repository.loanTypeList.get(i).get("Type");
			}
		}
		return null;
	}
	
	@Override
	public boolean updateTimePeriod(String loanType, String newTime) {
		for (int i = 0; i < Repository.loanTypeList.size(); i++) {
			if (loanType.equalsIgnoreCase((String) Repository.loanTypeList.get(i).get("Type"))) {
				Repository.loanTypeList.get(i).put("Time-Period", newTime + " years(Max)");
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean updateRates(String loanType, String newRate) {
		for (int i = 0; i < Repository.loanTypeList.size(); i++) {
			if (loanType.equalsIgnoreCase((String) Repository.loanTypeList.get(i).get("Type"))) {
				Repository.loanTypeList.get(i).put("Interest-Rates", newRate + " %");
				return true;
			}
		}
		return false;
	}
	
}
