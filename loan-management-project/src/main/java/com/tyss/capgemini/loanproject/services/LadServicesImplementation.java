package com.tyss.capgemini.loanproject.services;

import com.tyss.capgemini.loanproject.exceptions.FormReviewChoiceException;
import com.tyss.capgemini.loanproject.factory.FactoryClass;
import com.tyss.capgemini.loanproject.validation.ValidationClass;

public class LadServicesImplementation implements LadServicesDeclaration{
	ValidationClass validationClass = new ValidationClass();
	
	@Override
	public boolean viewLoanPrograms() {
		if (FactoryClass.getLadDao().viewLoanPrograms()) {
			return true;
		} else return false;
	}
	
	@Override
	public boolean ladReviewForms(String apid, String status) {
		if ((status.equalsIgnoreCase("approved")) || (status.equalsIgnoreCase("rejected"))) {
			FactoryClass.getLadDao().ladReviewForms(apid, status);
			return true;
		} else throw new FormReviewChoiceException("please write only approved or rejected.");
	}

	@Override
	public boolean ladViewForms(String planString) {
		if (FactoryClass.getLadDao().ladViewForms(planString)) {
			return true;
		} else return false;
	}
	
	@Override
	public boolean requestedForms() {
		if (FactoryClass.getLadDao().requestedForms()) {
			return true;
		} else return false;
	}

	@Override
	public boolean loanTypes() {
		return FactoryClass.getLadDao().loanTypes();
	}

	@Override
	public String loanTypes(String k) {
		return  FactoryClass.getLadDao().loanTypes(k);
	}
	
	@Override
	public boolean applicationExist(String id) {
		return FactoryClass.getLadDao().applicationExist(id);
	}

}
