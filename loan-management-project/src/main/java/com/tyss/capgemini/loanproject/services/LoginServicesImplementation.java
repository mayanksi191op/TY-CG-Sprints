package com.tyss.capgemini.loanproject.services;

import com.tyss.capgemini.loanproject.exceptions.DateLimitException;
import com.tyss.capgemini.loanproject.exceptions.InvalidCredentialException;
import com.tyss.capgemini.loanproject.exceptions.InvalidDateFormatException;
import com.tyss.capgemini.loanproject.exceptions.InvalidEmailException;
import com.tyss.capgemini.loanproject.exceptions.InvalidPasswordException;
import com.tyss.capgemini.loanproject.exceptions.InvalidPhoneException;
import com.tyss.capgemini.loanproject.exceptions.InvalidUsernameException;
import com.tyss.capgemini.loanproject.factory.FactoryClass;
import com.tyss.capgemini.loanproject.repository.Repository;
import com.tyss.capgemini.loanproject.validation.ValidationClass;

public class LoginServicesImplementation implements LoginServicesDeclaration {
	ValidationClass validationClass = new ValidationClass();

	@Override
	public boolean custLogin(String custUsername, String custPass) {
		int count = 0;
		for (int i = 0; i < Repository.customerList.size(); i++) {
			if ((custUsername.equals(Repository.customerList.get(i).get("username"))
					&& (custPass.equals(Repository.customerList.get(i).get("password"))))) {
				count++;
				FactoryClass.getLoginDao().custLogin(custUsername, custPass);
				return true;
			}
		}
		if (count == 0) {
			throw new InvalidCredentialException("Enter correct username and password");
		}
		return false;
	}

	@Override
	public boolean empLogin(String empUsername, String empPass) {
		int count = 0;
		for (int i = 0; i < Repository.employeeList.size(); i++) {
			if ((empUsername.equals(Repository.employeeList.get(i).get("username"))
					&& (empPass.equals(Repository.employeeList.get(i).get("password"))))) {
				count++;
				FactoryClass.getLoginDao().empLogin(empUsername, empPass);
				return true;
			}
		}
		if (count == 0) {
			throw new InvalidCredentialException("Enter correct username and password");
		}
		return false;
	}

	@Override
	public boolean register(String occupation, String dob, String gender, String username, String userid, String email,
			String password, String firstname, String lastname, long phone, double accountBal) {
		if (validationClass.usernameValid(username)) {
			if (validationClass.passValid(password)) {
				if (validationClass.mailValid(email)) {
					if (validationClass.dateValid(dob)) {
						String[] dateOfBirthArr = dob.split("/");
						int dobmonth = Integer.parseInt(dateOfBirthArr[1]);
						int dobyear = Integer.parseInt(dateOfBirthArr[2]);
						if ((dobmonth > 3) && (dobyear >= 2020)) {
							throw new DateLimitException("Not inside date limit.");
						}
						if ((phone > 6000000000L) || (phone < 1000000000L)) {
							FactoryClass.getLoginDao().register(occupation, dob, gender, username, userid, email,
									password, firstname, lastname, phone, accountBal);
							return true;
						} else
							throw new InvalidPhoneException("Enter 10 digit phone number");
					} else
						throw new InvalidDateFormatException("Enter correct date format (DD/MM/YYYY).");
				} else
					throw new InvalidEmailException("Enter correct email format");
			} else
				throw new InvalidPasswordException("Enter correct password format");
		} else
			throw new InvalidUsernameException("Enter correct format");
	}
	
	@Override
	public boolean emailExists(String email) {
		return FactoryClass.getLoginDao().emailExists(email);
	}

	@Override
	public boolean usernameExists(String username) {
		return FactoryClass.getLoginDao().usernameExists(username);
	}
}
