package com.tyss.capgemini.loanproject.controller;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.tyss.capgemini.loanproject.exceptions.DataAlreayExistException;
import com.tyss.capgemini.loanproject.exceptions.DateLimitException;
import com.tyss.capgemini.loanproject.exceptions.InvalidDataException;
import com.tyss.capgemini.loanproject.factory.FactoryClass;
import com.tyss.capgemini.loanproject.validation.ValidationClass;


public class CustomerController {

	public static void custController(String custUsername) {
		
		ValidationClass validationClass = new ValidationClass();
		Logger logger = LogManager.getLogger(CustomerController.class);
		boolean exit = false;
		boolean count = false;

		while (exit != true) {
			logger.info("===========================");
			logger.info("   Customer Operations:-");
			logger.info("===========================");
			logger.info("1> Loan Programs:");
			logger.info("2> Apply for loan: ");
			logger.info("3> Pay Loan: ");
			logger.info("4> change password: ");
			logger.info("5> Check Balance: ");
			logger.info("6> View Applications");
			logger.info("7> Logout");
			logger.info("Enter your choice: ");
			String choice = Login.scanner.nextLine();
			switch (choice) {
			case "1":
				FactoryClass.getCustomerServices().viewLoanPrograms();
				break;

			case "2":
				String applicationId = null;
				String accountNo = null;
				String email = null;
				String applicantFirstName = null;
				String applicantMiddleName = null;
				String applicantLastName = null;
				String coapplicantFirstName = null;
				String coapplicantMiddleName = null;
				String coapplicantLastName = null;
				String dateOfBirth = null;
				String loanChoice1 = null;
				String branchCode = null;
				String branchName = null;
				String openDate = null;
				String requestDate = null;
				String loanAmount = null;
				String m = null;
				try {

//					while(count == false ) {
//						logger.info("enter the applicationId: ");
//						applicationId = Login.scanner.nextLine();
//						try {
//							if (validationClass.alphaNumValid(applicationId) == false) {
//								throw new InvalidDataException("enter numbers only");
//							} else if (FactoryClass.getCustomerServices().applicationExist(applicationId)) {
//								throw new DataAlreayExistException("id alreay exist!!!");
//							} else{
//								count = true;
//							}
//						} catch (Exception e) {
//							logger.info(e.getMessage());
//						}}
//					count = false;
					
					applicationId = FactoryClass.getCustomerServices().autoGenerateId();

					email = FactoryClass.getCustomerServices().fetchMail(custUsername);
					
					while(count == false ) {
						logger.info("enter the Bank account number: ");
						accountNo = Login.scanner.nextLine();
						try {
							if (validationClass.alphaNumValid(accountNo) == false) {
								throw new InvalidDataException("enter valid account number!!!");
							} else {
								count = true;
							}
						} catch (Exception e) {
							logger.info(e.getMessage());
						}}
					count = false;
					
					
					applicantFirstName = FactoryClass.getCustomerServices().fetchFirstName(custUsername);
					applicantMiddleName = "_";
					applicantLastName = FactoryClass.getCustomerServices().fetchLastName(custUsername);
					
					
					boolean count1 = false;
					while(count1 == false) {
						boolean flag = false;
						while(flag == false) {
						logger.info("Enter co-applicant?");
						logger.info("1>Yes        2>No");
						try {
							m = Login.scanner.nextLine();
							if (validationClass.numMismatch1(m)== false) {
								throw new InvalidDataException("Enter only numbers!!!");
							} else {
								flag = true;
							}
						} catch (Exception e) {
							logger.info(e.getMessage());
						}
						}
						flag = false;
						switch (m) {
						case "1":
							boolean count3 = false;
							while(count3 == false ) {
								logger.info("enter the Co-Applicant First Name: ");
								coapplicantFirstName = Login.scanner.nextLine();
								try {
									if (validationClass.nameValid(coapplicantFirstName) == false) {
										throw new InvalidDataException("enter letters only!!!");
									} else {
										count3 = true;
									}
								} catch (Exception e) {
									logger.info(e.getMessage());
								}}
							count3 = false;
							while(count3 == false ) {
								logger.info("enter the Co-Applicant's Middle Name: ");
								coapplicantMiddleName = Login.scanner.nextLine();
								try {
									if (validationClass.nameValid(coapplicantMiddleName) == false) {
										throw new InvalidDataException("enter letters only!!!");
									} else {
										count3 = true;
									}
								} catch (Exception e) {
									logger.info(e.getMessage());
								}}
							count3 = false;
							while(count3 == false ) {
								logger.info("enter the Co-Applicant's Last Name");
								coapplicantLastName = Login.scanner.nextLine();
								try {
									if (validationClass.nameValid(coapplicantLastName) == false) {
										throw new InvalidDataException("Enter letters only!!!");
									} else {
										count3 = true;
									}
								} catch (Exception e) {
									logger.info(e.getMessage());
								}}
							count3 = false;
							count1 = true;
							break;
						case "2":
							count1 = true;
							break;
						default:
							logger.info("Invalid option!!!");
							break;
						}
					}
					count1 = false;
					count = false;
					while(count == false ) {
						logger.info("enter the Date of Birth: ");
						dateOfBirth = Login.scanner.nextLine();
						try {
							if (validationClass.dateValid(dateOfBirth) == false) {
								throw new DateLimitException("enter correct format only (DD/MM/YYYY)");
							} else {
								count = true;
							}
						} catch (Exception e) {
							logger.info(e.getMessage());
						}}

					count = false;
					while(count == false ) {
						logger.info("enter the Loan Type");
						logger.info("Available loans :-");
						FactoryClass.getCustomerServices().loanTypes();
						int loanChoice = Login.scanner.nextInt();
						Login.scanner.nextLine();
						loanChoice1 = FactoryClass.getCustomerServices().loanTypes(loanChoice);
						if (loanChoice1 == null) {
							logger.info("incorrect choice, choose again please!!!");
						} else {
							count = true;
						}
					}

					count = false;
					while(count == false ) {
						logger.info("enter the Branch Code");
						branchCode = Login.scanner.nextLine();
						if (validationClass.alphaNumValid(branchCode) == false) {
							logger.info("Please enter only numbers");
							count = false;
						} else {
							count = true;
						} }
					count = false;
					while(count == false ) {
						logger.info("enter the Branch Name");
						branchName = Login.scanner.nextLine();
						if (validationClass.nameValid(branchName) == false) {
							logger.info("Please enter only letters");
							count = false;
						} else {
							count = true;
						} }
					count = false;
					
					while(count == false) {
						logger.info("Enter the Loan amount");
						loanAmount = Login.scanner.nextLine();
						Double doubleLoan = null;
						try {
							if (validationClass.numMismatch1(loanAmount) == false) {
								throw new InvalidDataException("Enter valid data or amount!!!");
							} else {
								doubleLoan = Double.parseDouble(loanAmount);
								if (doubleLoan > FactoryClass.getCustomerServices().returnBal(custUsername)) {
									throw new InvalidDataException("Enter amount less than balance...");
								} else {
									count = true;
								}
							}
						} catch (Exception e) {
							logger.info(e.getMessage());
						}
					}
					count = false;	
						

					while(count == false ) {
						logger.info("enter the open date");
						openDate = Login.scanner.nextLine();
						try {
							if (validationClass.dateValid(openDate) == false) {
								throw new DateLimitException("enter correct format only (DD/MM/YYYY)");
							} else {
								count = true;
							}
						} catch (Exception e) {
							logger.info(e.getMessage());
						}}
					count = false;
					while(count == false ) {
						logger.info("enter the Request Date");
						requestDate = Login.scanner.nextLine();
						try {
							if (validationClass.dateValid(requestDate) == false) {
								throw new DateLimitException("enter correct format only (DD/MM/YYYY)");
							} else {
								count = true;
							}
						} catch (Exception e) {
							logger.info(e.getMessage());
						}}

					count = false;
					while(count == false) {
						logger.info("1>SUBMIT"  );
						logger.info("2>CANCEL");
						logger.info("Choose one...");
						String ch19 = Login.scanner.nextLine();
						switch (ch19) {
						case "1":
							FactoryClass.getCustomerServices().loanApplicationForm(applicationId, accountNo, email, applicantFirstName,
									applicantMiddleName, applicantLastName, dateOfBirth, coapplicantFirstName, coapplicantMiddleName,
									coapplicantLastName, loanChoice1, branchCode, branchName, openDate, requestDate, loanAmount);
							count = true;
							break;
						case "2":
							logger.info("Cancelled");
							count = true;
						default:
							logger.info("invalid option");
							break;
						}
					}

				} catch (Exception e) {
					logger.info(e.getMessage());
				}
				break;

			case "3":
				boolean count1 = false;
				while(count1 == false) {
					try {
						Double loanPay = null;
						String payString = null;
						logger.info("Your current balance is: ");
						FactoryClass.getCustomerServices().checkBalance(custUsername);
						logger.info("Loan to be paid: ");
						FactoryClass.getCustomerServices().checkLoan(custUsername);
						while(count == false) {
							logger.info("Enter the amount to pay: ");
							payString = Login.scanner.nextLine();
							try {
								if (validationClass.doubleValid(payString) == false) {
									throw new InvalidDataException("please enter correct data!!!");
								} else {
									count = true;
								}
							} catch (Exception e) {
								logger.info(e.getMessage());
								//e.printStackTrace();
							}
						}
						count = false;
						loanPay = Double.parseDouble(payString);
						if (FactoryClass.getCustomerServices().payLoan(custUsername, loanPay) == false) {
							logger.info("enter again please");
						} else {
							count1 = true;
						}
						FactoryClass.getCustomerServices().checkBalance(custUsername);
					} catch (Exception e) {
						logger.info(e.getMessage());
						//e.printStackTrace();
					}
				}
				break;

			case "4":
				while(count == false) {
				try {
					logger.info("enter the new password: ");
					String newPass = Login.scanner.nextLine();
					if (FactoryClass.getCustomerServices().changePassword(custUsername, newPass)) {
						count = true;
					}
				} catch (Exception e) {
					logger.info(e.getMessage());
				}
				}
				count = false;
				break;

			case "5":
				FactoryClass.getCustomerServices().checkBalance(custUsername);
				break;

			case "6":
				FactoryClass.getCustomerServices().viewApplications(custUsername);
				break;

			case "7":
				exit = true;
				break;   

			default:
				logger.info("Invalid Option");
				break;
			}
		}
	}
}
