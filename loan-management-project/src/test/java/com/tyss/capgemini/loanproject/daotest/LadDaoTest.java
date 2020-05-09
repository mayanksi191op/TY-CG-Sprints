package com.tyss.capgemini.loanproject.daotest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.tyss.capgemini.loanproject.dao.LadDaoImplementation;
import com.tyss.capgemini.loanproject.repository.Repository;

public class LadDaoTest {
	LadDaoImplementation implementation = new LadDaoImplementation();
	
	@Test
	void viewLoanProgramsTest() {
		Repository.UserTable();
		Boolean isBoolean = implementation.viewLoanPrograms();
		assertEquals(isBoolean, true);
	}
	
	@Test
	void ladReviewFormsTest1() {
		Repository.UserTable();
		Boolean isBoolean = implementation.ladReviewForms("AP03", "approved");
		assertEquals(isBoolean, true);
	}
	
	@Test
	void ladReviewFormsTest2() {
		Repository.UserTable();
		Boolean isBoolean = implementation.ladReviewForms("AP03", "rejected");
		assertEquals(isBoolean, true);
	}
	
	@Test
	void ladReviewFormsTest3() {
		Repository.UserTable();
		Boolean isBoolean = implementation.ladReviewForms("AP031", "approved");
		assertEquals(isBoolean, false);
	}
	
	@Test
	void ladViewFormsTest1() {
		Repository.UserTable();
		Boolean isBoolean = implementation.ladViewForms("Personal Loan");
		assertEquals(isBoolean, true);
	}
	
	@Test
	void ladViewFormsTest2() {
		Repository.UserTable();
		Boolean isBoolean = implementation.ladViewForms("asd loan");
		assertEquals(isBoolean, false);
	}
	
	@Test
	void requestedForms1() {
		Repository.UserTable();
		Boolean isBoolean = implementation.requestedForms();
		assertEquals(isBoolean, true);
	}
	
	@Test
	void loanTypesTest1() {
		Repository.UserTable();
		Boolean boolean1 = implementation.loanTypes();
		assertEquals(boolean1, true);
	}
	
	@Test
	void loanTypes2Test1() {
		Repository.UserTable();
		String string = implementation.loanTypes("1");
		assertEquals(string, "House Loan");
	}
	
	@Test
	void loanTypes2Test2() {
		Repository.UserTable();
		String string = implementation.loanTypes("2");
		assertEquals(string, "House Construction Loan");
	}
	
	@Test
	void applicationExistsTest1() {
		Repository.UserTable();
		Boolean boolean1 = implementation.applicationExist("AP01");
		assertEquals(boolean1, true);
	}
	
	@Test
	void applicationExistsTest2() {
		Repository.UserTable();
		Boolean boolean1 = implementation.applicationExist("asdasd");
		assertEquals(boolean1, false);
	}
	
}
