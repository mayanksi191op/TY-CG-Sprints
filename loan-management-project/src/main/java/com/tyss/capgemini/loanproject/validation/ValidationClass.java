package com.tyss.capgemini.loanproject.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationClass {
	public boolean passValid(String pass) {
		Pattern pattern = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[$%_@]).{6,20})");
		Matcher matcher = pattern.matcher(pass);
		return matcher.matches();
	}
	
	public boolean dateValid(String date) {
		return Pattern.matches("^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$", date);
	}
	
	public boolean mailValid(String email) {
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]+(?:\\."+ "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
		Matcher matcher = pattern.matcher(email);
		Boolean boolean2 = matcher.matches();
		return boolean2;
	}
	
	public boolean usernameValid(String username) {
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]{5,15}");
		Matcher matcher = pattern.matcher(username);
		Boolean boolean1 = matcher.matches();
		return boolean1;
	}
	
	public boolean alphaNumValid(String id) {
		return Pattern.matches("[0-9a-zA-Z]*", id);
	}
	
	public boolean nameValid(String name) {
		return Pattern.matches("[a-zA-Z]{3,10}", name);
	}
	
	public boolean fullNameValid(String name) {
		return Pattern.matches("[a-z A-Z]{3,20}", name);
	}
	
	public boolean numMismatch(String num) {
		return Pattern.matches("[0-9]*", num);
	}
	
	public boolean numMismatch1(String num) {
		return Pattern.matches("^[0-9]{0,7}$", num);
	}
	
	public boolean timePeriodValid(String timeperiod) {
		return Pattern.matches("^0*([1-9]|[1-3][0-9]|40)$", timeperiod);
	}
		
	public boolean doubleValid(String interest) {
		return Pattern.matches("[0-9]*[.]?[0-9]*", interest);
	}
	
	public boolean phoneValid(String phone) {
		return Pattern.matches("[6-9][0-9]{9,9}", phone);
	}
}
