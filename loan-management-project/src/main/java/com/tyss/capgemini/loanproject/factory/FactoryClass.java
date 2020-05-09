package com.tyss.capgemini.loanproject.factory;

import com.tyss.capgemini.loanproject.dao.AdminDaoDeclaration;
import com.tyss.capgemini.loanproject.dao.AdminDaoImplementation;
import com.tyss.capgemini.loanproject.dao.CustomerDaoDeclaration;
import com.tyss.capgemini.loanproject.dao.CustomerDaoImplementation;
import com.tyss.capgemini.loanproject.dao.LadDaoDeclaration;
import com.tyss.capgemini.loanproject.dao.LadDaoImplementation;
import com.tyss.capgemini.loanproject.dao.LoginDaoDeclaration;
import com.tyss.capgemini.loanproject.dao.LoginDaoImplementation;
import com.tyss.capgemini.loanproject.services.AdminServicesDeclaration;
import com.tyss.capgemini.loanproject.services.AdminServicesImplementation;
import com.tyss.capgemini.loanproject.services.CustomerServicesDeclaration;
import com.tyss.capgemini.loanproject.services.CustomerServicesImplementation;
import com.tyss.capgemini.loanproject.services.LadServicesDeclaration;
import com.tyss.capgemini.loanproject.services.LadServicesImplementation;
import com.tyss.capgemini.loanproject.services.LoginServicesDeclaration;
import com.tyss.capgemini.loanproject.services.LoginServicesImplementation;

public class FactoryClass {
	
	public static CustomerServicesDeclaration getCustomerServices() {
		return new CustomerServicesImplementation();
	}
	
	public static CustomerDaoDeclaration getCustomerDao() {
		return new CustomerDaoImplementation();
	}
	
	public static AdminServicesDeclaration getAdminServices() {
		return new AdminServicesImplementation();
	}
	
	public static AdminDaoDeclaration getAdminDao() {
		return new AdminDaoImplementation();
	}
	
	public static LoginServicesDeclaration getLoginServices() {
		return new LoginServicesImplementation();
	}
	
	public static LoginDaoDeclaration getLoginDao() {
		return new LoginDaoImplementation();
	}
	
	public static LadServicesDeclaration getLadServices() {
		return new LadServicesImplementation();
	}
	
	public static LadDaoDeclaration getLadDao() {
		return new LadDaoImplementation();
	}
}
