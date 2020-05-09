package com.tyss.capgemini.loanproject.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class MainController {
	public static void main(String[] args) {
		
		String string = "200000";
		Double double1 = Double.parseDouble(string);
		System.out.println(double1);
		
		
		Logger logger = LogManager.getLogger(MainController.class);
		logger.info("******** W E L C O M E ********");
		logger.info("********      TO       ********");
		logger.info("********   LPS BANK    ********");
		Login.loginController();
	}
	
	
	
		
}
