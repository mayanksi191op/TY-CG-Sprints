package com.tyss.capgemini.loanproject.dao;

import java.util.HashMap;
import java.util.LinkedHashMap;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.tyss.capgemini.loanproject.controller.AdminController;
import com.tyss.capgemini.loanproject.controller.CustomerController;
import com.tyss.capgemini.loanproject.controller.LADController;
import com.tyss.capgemini.loanproject.repository.Repository;

public class LoginDaoImplementation implements LoginDaoDeclaration {
	Logger logger = LogManager.getLogger(LadDaoImplementation.class);
	Repository repo = new Repository();
	
	
	/**
	 * Checks whether the username and password values passed as 
	 * argument of the method is present in the customerList list 
	 * stored in Repository.
	 *
	 * @param custUsername of String type
	 * @param custPass of String type
	 * @return true if the argument values passed are present in the list
	 * 			or false if the argument values are not present in the
	 * 			list and displayes the message.
	 */
	@Override
	public boolean custLogin(String custUsername, String custPass) {

		if (Repository.customerList.isEmpty() != true) {
			for (int i = 0; i < Repository.customerList.size(); i++) {
				if (Repository.customerList.get(i).get("username").equals(custUsername)
						&& Repository.customerList.get(i).get("password").equals(custPass)) {
					logger.info("--------WELCOME " + custUsername + "---------");
					CustomerController.custController(custUsername);
					return true;
				}
			}
		} else
			System.out.println("XXXX No Users available XXXX");
			return false;
	}
	
	/**
	 * Checks whether the username and password values passed as 
	 * argument of the method is present in the employeeList list 
	 * stored in Repository.
	 *
	 * @param emplUsername of String type
	 * @param empPass of String type
	 * @return true if the argument values passed are present in the list
	 * 			or false if the argument values are not present in the
	 * 			list and displayes the message.
	 */
	@Override
	public boolean empLogin(String empUsername, String empPass) {
		if (Repository.employeeList.isEmpty() != true) {
			for (int i = 0; i < Repository.employeeList.size(); i++) {
				if (Repository.employeeList.get(i).get("username").equals(empUsername)
						&& Repository.employeeList.get(i).get("password").equals(empPass)) {
					if (Repository.employeeList.get(i).get("role").equals("admin")) {
						logger.info("--------WELCOME " + empUsername + "--------");
						AdminController.adminCont();
						return true;
					} else
						logger.info("--------WELCOME " + empUsername + "--------");
					LADController.ladController();
					return true;
				}
			}
		} else
			System.out.println("XXXX No users available XXXX");
			return false;
	}
	
	/**
	 * Adds key value data to HashMap using put(),then
	 * adds the created HashMap object to the loanFormList
	 * list.
	 *
	 * @param userid of String type
	 * @param password of String type
	 * @param username of String type
	 * @param email of String type
	 * @param firstname of String type
	 * @param lastname of String type
	 * @param phone of String type
	 * @param accountBal of String type
	 * @param role of String type
	 * @param loanAmount of String type
	 * @return true if the data is being added to the 
	 * 		   customerList list and mainList list, or false  
	 * 		   if the data is not added.
	 */
	@Override
	public boolean register(String occupation, String dob, String gender, String username, String userid, String email,
			String password, String firstname, String lastname, long phone, double accountBal) {
		HashMap<String, Object> regHashMap = new LinkedHashMap<String, Object>();
		regHashMap.put("userid", userid);
		regHashMap.put("password", password);
		regHashMap.put("username", username);
		regHashMap.put("email", email);
		regHashMap.put("firstname", firstname);
		regHashMap.put("lastname", lastname);
		regHashMap.put("phone", phone);
		regHashMap.put("AccountBal", accountBal);
		regHashMap.put("role", "customer");
		regHashMap.put("loanAmount", 0);
		Repository.customerList.add(regHashMap);
		Repository.mainList.add(regHashMap);
		logger.info("customer added");
		return true;
	}
	
	/**
	 * Checks whether the email value passed as argument is
	 * present in mainList list.
	 *
	 * @param email of String type
	 * @return false if the data is present in the mainList
	 * 			list, or true if the data is not found.
	 */
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

	/**
	 * Checks whether the username value passed as argument is
	 * present in mainList list.
	 *
	 * @param username of String type
	 * @return false if the data is present in the mainList
	 * 			list, or true if the data is not found.
	 */
	@Override
	public boolean usernameExists(String username) {
		int count = 0;
		for (int i = 0; i < Repository.mainList.size(); i++) {
			if (username.equalsIgnoreCase((String) Repository.mainList.get(i).get("username"))) {
				count++;
			}
		}
		if (count > 0) {
			return false;
		} else {
			return true;
		}
	}
}
