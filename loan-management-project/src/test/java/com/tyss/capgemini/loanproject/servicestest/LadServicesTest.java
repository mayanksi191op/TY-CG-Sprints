package com.tyss.capgemini.loanproject.servicestest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.tyss.capgemini.loanproject.exceptions.FormReviewChoiceException;
import com.tyss.capgemini.loanproject.repository.Repository;
import com.tyss.capgemini.loanproject.services.LadServicesImplementation;

public class LadServicesTest {

	LadServicesImplementation implementation = new LadServicesImplementation();
	
	@Test
	void ladReviewFormTest1() {
		Repository.UserTable();
		try {
			Boolean isBoolean = implementation.ladReviewForms("AP03", "asdasd");
			assertEquals(isBoolean, true);
		} catch (Exception e) {
			assertThrows(FormReviewChoiceException.class, ()->{
				implementation.ladReviewForms("AP03", "asdasd");
			});
		}
	}
	

	@Test
	void ladReviewFormTest2() {
		Repository.UserTable();
		try {
			Boolean isBoolean = implementation.ladReviewForms("AP031", "asdasd");
			assertEquals(isBoolean, false);
		} catch (Exception e) {
			assertThrows(FormReviewChoiceException.class, ()->{
				implementation.ladReviewForms("AP03", "asdasd");
			});
		}
	}
	
	@Test
	void viewLoanProgramsTest1() {
		Repository.UserTable();
		Boolean isBoolean = implementation.viewLoanPrograms();
		assertEquals(isBoolean, true);
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
		Boolean isBoolean = implementation.ladViewForms("asdasd");
		assertEquals(isBoolean, false);
	}
	
	@Test
	void requestedFormsTest1() {
		Repository.UserTable();
		Boolean isBoolean = implementation.requestedForms();
		assertEquals(isBoolean, true);
	}
}
