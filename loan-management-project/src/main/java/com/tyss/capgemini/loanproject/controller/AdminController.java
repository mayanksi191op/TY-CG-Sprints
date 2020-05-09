package com.tyss.capgemini.loanproject.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.tyss.capgemini.loanproject.exceptions.DataAlreayExistException;
import com.tyss.capgemini.loanproject.exceptions.InvalidDataException;
import com.tyss.capgemini.loanproject.exceptions.InvalidEmailException;
import com.tyss.capgemini.loanproject.exceptions.InvalidPasswordException;
import com.tyss.capgemini.loanproject.exceptions.InvalidUsernameException;
import com.tyss.capgemini.loanproject.factory.FactoryClass;
import com.tyss.capgemini.loanproject.validation.ValidationClass;

public class AdminController {
	public static void adminCont() {
		ValidationClass validationClass = new ValidationClass();
		Logger logger = LogManager.getLogger(AdminController.class);
		boolean exit = false;
		boolean exit2 = false;
		boolean exit3 = false;
		boolean exit4 = false;
		while (exit != true) {
			logger.info("===========================");
			logger.info("	  Admin Operations");
			logger.info("===========================");
			logger.info("1> Loan Programs: ");
			logger.info("2> Client Manager ");
			logger.info("3> Loan Reports: ");
			logger.info("4> Logout");
			logger.info("Enter the choice: ");
			String ch = Login.scanner.nextLine();
			switch (ch) {
			case "1":
				try {
					while (exit2 != true) {
						logger.info("1> Insert in Loan programs: ");
						logger.info("2> Delete in Loan programs: ");
						logger.info("3> Update in Loan programs: ");
						logger.info("4> View the loan programs: ");
						logger.info("5> Check other operations: ");
						logger.info("enter the choice: ");
						String choice = Login.scanner.nextLine();
						boolean count = false;
						switch (choice) {
						case "1":
							String time = null;
							String type = null;
							String rates = null;
							while(count == false) {
								logger.info("enter the Loan Type (name): ");
								type = Login.scanner.nextLine();
								try {
									if (validationClass.fullNameValid(type) == false) {
										throw new InvalidDataException("Enter correct data!!!");
									} else {
										count = true;
									}
								} catch (Exception e) {
									logger.info(e.getMessage());
								}
							}
							count = false;

							while(count == false) {
								logger.info("enter the Time period (year value): ");
								time = Login.scanner.nextLine();
								try {
									if (validationClass.timePeriodValid(time) == false) {
										throw new InvalidDataException("Please enter value from 1-40 years only");
									} else {
										count = true;
									}
								} catch (Exception e) {
									logger.info(e.getMessage());
								}
							}
							count = false;

							while(count == false) {
								logger.info("enter the Interest Rates : ");
								rates = Login.scanner.nextLine();
								try {
									if ((validationClass.doubleValid(rates) == false)) {
										throw new InvalidDataException("Please enter value from 6-15 years only");
									} else {
										Double ratesDouble = Double.parseDouble(rates);
										if ((ratesDouble > 15.0) || (ratesDouble < 6.0)) {
											throw new InvalidDataException("Please enter rates between 6.0 -15.0 % !!!");
										} else
											count = true;
									}
								} catch (Exception e) {
									logger.info(e.getMessage());
								}
							}

							FactoryClass.getAdminServices().insertLoan(type, time, rates);
							count = false;

							break;

						case "2":
							count = false;
							String jString = null;
							while(count == false) {
								logger.info("Plans offered:-");
								FactoryClass.getAdminServices().loanTypes();
								boolean count1 = false;
								while(count1 == false) {
									logger.info("enter the loan type you want to delete: ");
									jString = Login.scanner.nextLine();
									try {
										if (validationClass.numMismatch1(jString) == false) {
											throw new InvalidDataException("Invalid choice, enter again please!!!");
										} else count1 = true;
									} catch (Exception e) {
										logger.info(e.getMessage());
									}}
								//int k = Integer.parseInt(jString);
								//String loantype = FactoryClass.getAdminServices().loanTypes(k);
								String loantype = FactoryClass.getAdminServices().loanTypes(jString);
								if (loantype.equals("invalid choice")) {
									count = false;
								} else {
									FactoryClass.getAdminServices().deleteLoan(loantype);
									count = true;
								}
							}
							exit2 = false;
							break;

						case "3":
							String typeString = null;
							while(count == false) {
								logger.info("enter the loan type: ");
								FactoryClass.getAdminServices().loanTypes();
								logger.info("choose:-");
								try {
									typeString = Login.scanner.nextLine();
									if (validationClass.numMismatch1(typeString) == false) {
										throw new InvalidDataException("invalid option!!!choose again please!!!");
									} else {
										typeString = FactoryClass.getAdminServices().loanTypes(typeString);
										count = true;
									}
								} catch (Exception e) {
									logger.info(e.getMessage());
								}
							}
							count = false;
							logger.info(typeString);
							boolean close1 = false;
							while (close1 != true) {
								logger.info("what detail you want to update?");
								logger.info("1> Type ");
								logger.info("2> Time-Period");
								logger.info("3> Interest-Rates");
								logger.info("4> Exit");
								logger.info("enter choice:-");
								String choice2 = Login.scanner.nextLine();
								switch (choice2) {
								case "1":
									while(count == false) {
										logger.info("enter the Type:-");
										String newType = Login.scanner.nextLine();
										try {
											if (validationClass.fullNameValid(newType) == false) {
												throw new InvalidDataException("enter letters only");
											}else {
												typeString = FactoryClass.getAdminServices().updateType(typeString, newType);

												logger.info("updated successfuly new value:" + typeString);
												count = true;
											}
										} catch (Exception e) {
											logger.info(e.getMessage());
										}
									}
									count = false;
									break;
								case "2":
									while(count == false) {
										logger.info("for type:" + typeString);
										logger.info("enter the Time-Period:-");
										String newTime = Login.scanner.nextLine();
										try {
											if (validationClass.timePeriodValid(newTime) == false) {
												throw new InvalidDataException("enter value from 1-40 only");
											}else {
												FactoryClass.getAdminServices().updateTimePeriod(typeString, newTime);
												logger.info("updated successfuly");
												count = true;
											}
										} catch (Exception e) {
											logger.info(e.getMessage());
										}
									}
									count = false;
									break;
								case "3":
									while(count == false) {
										logger.info("enter the Interest Rate:-");
										String newRate = Login.scanner.nextLine();
										Double newRateDouble = null;
										try {
											if (validationClass.doubleValid(newRate) == false) {
												throw new InvalidDataException("enter value from 6-15 only");
											}else {
												newRateDouble = Double.parseDouble(newRate);
											}
											if ((newRateDouble > 15) || (newRateDouble < 6) ) {
												throw new InvalidDataException("enter value from 6-15 only");
											} else {
												FactoryClass.getAdminServices().updateTimePeriod(typeString, newRate);
												logger.info("updated successfuly");
												count = true;
											}
										} catch (Exception e) {
											logger.info(e.getMessage());
										}
									}
									count = false;
									break;
								case "4":
									close1 = true;
									break;
								default:
									logger.info("invalid option!!!");
									break;
								}
							}
							close1 = false;
							break;

						case "4":
							FactoryClass.getAdminServices().viewLoanPrograms();
							break;

						case "5":
							exit2 = true;
							break;

						default:
							System.out.println("Wrong choice.");
							break;
						}
					}
				} catch (Exception e) {
					logger.info(e.getMessage());
				}
				exit2 = false;
				break;
			case "2":
				boolean flag=false;
				while (exit3 == false) {
					String firstname=null;
					String lastname=null;
					String email=null;
					String password=null;
					String phone=null;
					String username=null;
					logger.info("1> Add Clients: ");
					logger.info("2> View Clients: ");
					logger.info("3> Check other operations: ");
					logger.info("Choose one:-");
					String ch3 = Login.scanner.nextLine();
					switch (ch3) {
					case "1":
						while(!flag) {
							logger.info("Enter First Name: ");
							firstname = Login.scanner.nextLine();
							try {
								if (validationClass.nameValid(firstname) == false) {
									throw new InvalidDataException("first name can have letters only!!");
								} else {
									flag = true;
								}
							} catch (Exception e) {
								logger.info(e.getMessage());
							}
						}
						flag=false;
						while(!flag) {
							logger.info("Enter Last Name: ");
							lastname = Login.scanner.nextLine();
							try {
								if (validationClass.nameValid(lastname) == false) {
									throw new InvalidDataException("last name can have letters only!!");
								} else {
									flag = true;
								}
							} catch (Exception e) {
								logger.info(e.getMessage());
							}
						}
						flag=false;
						while (!flag) {
							logger.info("Enter username: ");
							username = Login.scanner.nextLine();
							try {
								if (validationClass.usernameValid(username) == false) {
									throw new InvalidUsernameException("Follow the pattern...");
								} else {
									try {
										if (FactoryClass.getAdminServices().usernameExists(username) == false) {
											throw new DataAlreayExistException("this username already exists!!!");
										} else {
											flag = true;
										}
									} catch (Exception e) {
										logger.info(e.getMessage());
									}
								}
							} catch (Exception e) {
								logger.info(e.getMessage());
							}
						}
						flag = false;
						while (!flag) {
							logger.info("Enter email: ");
							email = Login.scanner.nextLine();
							try {
								if (validationClass.mailValid(email) == false) {
									throw new InvalidEmailException("Invalid email");
								} else {
									try {
										if (FactoryClass.getAdminServices().emailExists(email) == false) {
											throw new DataAlreayExistException("this email already exists!!!");
										} else {
											flag = true;
										}
									} catch (Exception e) {
										logger.info(e.getMessage());
									}
								}
							} catch (Exception e) {
								logger.info(e.getMessage());
							}
						}
						flag = false;
						while (!flag) {
							logger.info("Enter Phone no: ");
							phone = Login.scanner.nextLine();
							try {
								if (validationClass.phoneValid(phone) == false) {
									throw new InvalidDataException("Invalid phone number!!! (10 digits)");
								} else {
									flag = true;
								}
							}catch (Exception e) {
								logger.info(e.getMessage());
							}
						}
						flag = false;
						while (!flag) {
							logger.info("Enter password: ");
							password = Login.scanner.nextLine();
							try {
								if (validationClass.passValid(password) == false) {
									throw new InvalidPasswordException("Password pattern should match");
								} else {
									flag = true;
								}
							} catch (Exception e) {
								logger.info(e.getMessage());
							}
						}
						flag = false;
						if(FactoryClass.getAdminServices().addClients(username, email, password, firstname, lastname, phone)) {
							logger.info("client is added successfully");
						}
						else {
							logger.info("something went wrong!!!");
						}

						break;
					case "2":
						System.out.println("Clients:-");
						FactoryClass.getAdminServices().viewClients();
						break;
					case "3":
						exit3 = true;
						break;
					default:
						logger.info("invalid option!!!");
						break;
					}
				}
				exit3 = false;
				break;
			case "3":
				while (exit4 != true) {
					logger.info("Which report do you want to check: ");
					logger.info("1> Approved reports: ");
					logger.info("2> Rejected reports: ");
					logger.info("3> Requested reports: ");
					logger.info("4> Check other operations: ");
					String ch2 = Login.scanner.nextLine();
					switch (ch2) {
					case "1":
						logger.info("Approved application report:-");
						FactoryClass.getAdminServices().approvedForms();
						break;

					case "2":
						logger.info("Rejected application report:-");
						FactoryClass.getAdminServices().rejectedForms();
						break;

					case "3":
						logger.info("Requested application report:-");
						FactoryClass.getAdminServices().requestedForms();
						break;
					case "4":
						exit4 = true;
						break;
					default:
						logger.info("Invalid Option");
						break;
					}
				}
				exit4 = false;
				break;
			case "4":
				exit = true;
				break;
			default:
				logger.info("Invalid Option");
				break;
			}
		}
	}
}
