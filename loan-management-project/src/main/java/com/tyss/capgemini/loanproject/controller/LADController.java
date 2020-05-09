package com.tyss.capgemini.loanproject.controller;



import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.tyss.capgemini.loanproject.exceptions.DataAlreayExistException;
import com.tyss.capgemini.loanproject.exceptions.InvalidDataException;
import com.tyss.capgemini.loanproject.factory.FactoryClass;
import com.tyss.capgemini.loanproject.validation.ValidationClass;

public class LADController {
	public static void ladController() {
		Logger logger = LogManager.getLogger(LADController.class);
		ValidationClass validationClass = new ValidationClass();
		boolean exit = false;
		boolean flag = false;
		while (exit != true) {
			logger.info("=================================");
			logger.info("   Loan Approval Department:");
			logger.info("=================================");
			logger.info("1> View all Home loan programs: ");
			logger.info("2> View loan applications:");
			logger.info("3> Application review: ");
			logger.info("4> Logout");
			logger.info("Enter your choice: ");
			String ch = Login.scanner.nextLine();
			switch (ch) {
			case "1":
				FactoryClass.getLadServices().viewLoanPrograms();
				break;

			case "2":
				String chooseString = null;
				logger.info("Enter the loan plan of applications:- ");
				FactoryClass.getLadServices().loanTypes();
				while(flag == false) {
					logger.info("Choose type:-");
					chooseString = Login.scanner.nextLine();
				try {
					if (validationClass.numMismatch1(chooseString) == false) {
						throw new InvalidDataException("Invalid choice, please choose again!!!");
					} else {
						flag = true;
					}
				} catch (Exception e) {
					logger.info(e.getMessage());
				}}
				String planString = FactoryClass.getLadServices().loanTypes(chooseString);
				FactoryClass.getLadServices().ladViewForms(planString);
				flag = false;
				
				break;

			case "3":
				String status = null;
				String apid = null;
				logger.info("Requested forms:-");
				FactoryClass.getLadServices().requestedForms();
				while(flag == false) {
					logger.info("enter the ApplicationId for review: ");
					apid = Login.scanner.nextLine();
					try {
						if (FactoryClass.getLadServices().applicationExist(apid) == false) {
							throw new DataAlreayExistException("Application Id not found!!!");
						} else {
							flag = true;
						}
					} catch (Exception e) {
						logger.info(e.getMessage());
					}
				}
				flag = false;
				logger.info("enter the status: ");
				logger.info("1> Approved");
				logger.info("2> Rejected");
				logger.info("choose:-");
				String choose = Login.scanner.nextLine();
				switch (choose) {
				case "1":
					status = "Approved";
					break;
				case "2":
					status = "Rejected";
					break;
				default:
					logger.info("invalid choice. Please choose again!!!");
					break;
				}
				//String status = Login.scanner.nextLine();
				FactoryClass.getLadServices().ladReviewForms(apid, status);
				break;
			case "4":
				exit = true;
				break;
			default:
				logger.info("Invalid option, please choose again!!!");
				break;
			}
		}
	}
}
