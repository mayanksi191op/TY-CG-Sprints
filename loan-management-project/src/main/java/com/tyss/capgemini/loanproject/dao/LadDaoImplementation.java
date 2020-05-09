package com.tyss.capgemini.loanproject.dao;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.tyss.capgemini.loanproject.repository.Repository;

public class LadDaoImplementation implements LadDaoDeclaration {
	Logger logger = LogManager.getLogger(LadDaoImplementation.class);
	Repository repo = new Repository();

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
	public boolean ladReviewForms(String apid, String status) {
		for (int j = 0; j < Repository.loanFormList.size(); j++) {
			if (apid.equalsIgnoreCase((String) Repository.loanFormList.get(j).get("ApplicationId"))) {
				if (status.equalsIgnoreCase("approved")) {
					Repository.loanFormList.get(j).put("LoanStatus", "approved");
				} else
					Repository.loanFormList.get(j).put("LoanStatus", "rejected");
				logger.info("Status Changed successfully.");
				return true;
			}
		}
		logger.info("All applications present:-");
		for (int i = 0; i < Repository.loanFormList.size(); i++) {
			logger.info("********************************");
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
			logger.info("********************************");
		}
		return false;
	}

	@Override
	public boolean ladViewForms(String planString) {
		int count = 0;
		for (int i = 0; i < Repository.loanFormList.size(); i++) {
			if (planString.equalsIgnoreCase((String) Repository.loanFormList.get(i).get("LoanType"))) {
				count++;
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
				return true;
			}
		}
		if (count == 0) {
			logger.info("No applications for this plan");
		}
		return false;
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
		}	else return false;
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
	public boolean applicationExist(String id) {
		for (int i = 0; i < Repository.loanFormList.size(); i++) {
			if (id.equalsIgnoreCase((String) Repository.loanFormList.get(i).get("ApplicationId"))) {
				return true;
			}
		}
		return false;
	}
}
