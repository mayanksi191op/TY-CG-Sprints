package com.tyss.capgemini.loanproject.servicestest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.tyss.capgemini.loanproject.exceptions.DateLimitException;
import com.tyss.capgemini.loanproject.exceptions.InsufficientBalanceException;
import com.tyss.capgemini.loanproject.exceptions.InvalidDateFormatException;
import com.tyss.capgemini.loanproject.exceptions.InvalidPasswordException;
import com.tyss.capgemini.loanproject.exceptions.LoanExcessException;
import com.tyss.capgemini.loanproject.repository.Repository;
import com.tyss.capgemini.loanproject.services.CustomerServicesImplementation;

public class CustomerServicesTest {

	CustomerServicesImplementation implementation = new CustomerServicesImplementation();

	@Test
	void changePasswordTest1() {
		try {
			Boolean istrueBoolean = implementation.changePassword("Praveen123@", "qwerty");
			assertEquals(istrueBoolean, true);
		} catch (Exception e) {
			assertThrows(InvalidPasswordException.class, () -> {
				implementation.changePassword("Praveen123", "qwerty");
			});
		}
		// Boolean istrueBoolean = implementation.changePassword("Praveen123",
		// "qwerty@123");
		// assertEquals(istrueBoolean, true);
	}

	@Test
	void changePasswordTest2() {
		try {
			Boolean istrueBoolean = implementation.changePassword("Praveen123@", "qwerty");
			assertEquals(istrueBoolean, true);
		} catch (Exception e) {
			assertThrows(InvalidPasswordException.class, () -> {
				implementation.changePassword("Praveen123", "qwerty");
			});
		}
		// Boolean istrueBoolean = implementation.changePassword("Praveen123",
		// "qwerty@123");
		// assertEquals(istrueBoolean, true);
	}

	@Test
	void viewLoanProgramsTest() {
		Repository.UserTable();
		Boolean isTrue = implementation.viewLoanPrograms();
		assertEquals(isTrue, true);
	}

	@Test
	void checkBalanceTest1() {
		Repository.UserTable();
		Boolean isTrue = implementation.checkBalance("manoj191");
		assertEquals(isTrue, true);
	}

	@Test
	void checkBalanceTest2() {
		Repository.UserTable();
		Boolean isFalse = implementation.checkBalance("mayank191");
		assertEquals(isFalse, false);
	}

	@Test
	void payLoanTest1() {
		Repository.UserTable();
		try {
			Boolean isTrue = implementation.payLoan("manoj191", 500D);
			assertEquals(isTrue, true);
		} catch (LoanExcessException e) {
			assertThrows(LoanExcessException.class, () -> {
				implementation.payLoan("manoj191", 500D);
			});
		} catch (InsufficientBalanceException e) {
			assertThrows(InsufficientBalanceException.class, () -> {
				implementation.payLoan("manoj191", 500D);
			});
		}
	}

	@Test
	void payLoanTest2() {
		Repository.UserTable();
		try {
			Boolean isFalse = implementation.payLoan("asdanoj191", 500D);
			assertEquals(isFalse, false);
		} catch (LoanExcessException e) {
			assertThrows(LoanExcessException.class, () -> {
				implementation.payLoan("manoj191", 500D);
			});
		} catch (InsufficientBalanceException e) {
			assertThrows(InsufficientBalanceException.class, () -> {
				implementation.payLoan("manoj191", 500D);
			});
		}
	}

	@Test
	void checkLoanTest1() {
		Repository.UserTable();
		Boolean isTrue = implementation.checkLoan("manoj191");
		assertEquals(isTrue, true);
	}

	@Test
	void checkLoanTest2() {
		Repository.UserTable();
		Boolean isFalse = implementation.checkLoan("nadaanoj191");
		assertEquals(isFalse, false);
	}

	@Test
	void loanApplicationForm1() {
		Repository.UserTable();
		try {
			Boolean isBoolean = implementation.loanApplicationForm("AP198", "BNI12345", "Pankaj", "", "Tripathy",
					"14/12/1995", "Ranjan", "Singh", "Ranjup", "House Loan", "BNI123421412", "Kanchipuram", "12/2/1987",
					"22/5/2020", "submit", "1234");
			assertEquals(isBoolean, true);
		} catch (DateLimitException e) {
			assertThrows(DateLimitException.class, () -> {
				implementation.loanApplicationForm("AP198", "BNI12345", "Pankaj", "", "Tripathy", "14/12/1995",
						"Ranjan", "Singh", "Ranjup", "House Loan", "BNI123421412", "Kanchipuram", "12/2/1987",
						"22/5/2020", "submit", "1234");
			});
		} catch (InvalidDateFormatException e) {
			assertThrows(InvalidDateFormatException.class, () -> {
				implementation.loanApplicationForm("AP198", "BNI12345", "Pankaj", "", "Tripathy", "14/12/1995",
						"Ranjan", "Singh", "Ranjup", "House Loan", "BNI123421412", "Kanchipuram", "12/2/1987",
						"22/5/2020", "submit", "1234");
			});
		}
	}

	@Test
	void loanApplicationForm2() {
		Repository.UserTable();
		try {
			Boolean isBoolean = implementation.loanApplicationForm("AP198", "BNI12345", "Pankaj", "", "Tripathy",
					"14/12/1995", "Ranjan", "Singh", "Ranjup", "House Loan", "BNI123421412", "Kanchipuram", "12/2/1987",
					"22/5/2020", "cancel", "1234");
			assertEquals(isBoolean, true);
		} catch (DateLimitException e) {
			assertThrows(DateLimitException.class, () -> {
				implementation.loanApplicationForm("AP198", "BNI12345", "Pankaj", "", "Tripathy", "14/12/1995",
						"Ranjan", "Singh", "Ranjup", "House Loan", "BNI123421412", "Kanchipuram", "12/2/1987",
						"22/5/2020", "cancel", "1234");
			});
		} catch (InvalidDateFormatException e) {
			assertThrows(InvalidDateFormatException.class, () -> {
				implementation.loanApplicationForm("AP198", "BNI12345", "Pankaj", "", "Tripathy", "14/12/1995",
						"Ranjan", "Singh", "Ranjup", "House Loan", "BNI123421412", "Kanchipuram", "12/2/1987",
						"22/5/2020", "cancel", "1234");
			});
		}
	}

	@Test
	void loanApplicationForm3() {
		Repository.UserTable();
		try {
			Boolean isBoolean = implementation.loanApplicationForm("AP198", "BNI12345", "Pankaj", "", "Tripathy",
					"14/12/1995", "Ranjan", "Singh", "Ranjup", "House Loan", "BNI123421412", "Kanchipuram", "12/2/1987",
					"22/5/2020", "asdasd", "1234");
			assertEquals(isBoolean, true);
		} catch (DateLimitException e) {
			assertThrows(DateLimitException.class, () -> {
				implementation.loanApplicationForm("AP198", "BNI12345", "Pankaj", "", "Tripathy", "14/12/1995",
						"Ranjan", "Singh", "Ranjup", "House Loan", "BNI123421412", "Kanchipuram", "12/2/1987",
						"22/5/2020", "asdasd", "1234");
			});
		} catch (InvalidDateFormatException e) {
			assertThrows(InvalidDateFormatException.class, () -> {
				implementation.loanApplicationForm("AP198", "BNI12345", "Pankaj", "", "Tripathy", "14/12/1995",
						"Ranjan", "Singh", "Ranjup", "House Loan", "BNI123421412", "Kanchipuram", "12/2/1987",
						"22/5/2020", "asdasd", "1234");
			});
		}
	}
	
	@Test
	void loanApplicationForm4() {
		Repository.UserTable();
		try {
			Boolean isBoolean = implementation.loanApplicationForm("AP198", "BNI12345", "Pankaj", "", "Tripathy",
					"14/12/1995", "Ranjan", "Singh", "Ranjup", "House Loan", "BNI123421412", "Kanchipuram", "12-2-1987",
					"22/5/2020", "submit", "1234");
			assertEquals(isBoolean, true);
		} catch (DateLimitException e) {
			assertThrows(DateLimitException.class, () -> {
				implementation.loanApplicationForm("AP198", "BNI12345", "Pankaj", "", "Tripathy", "14/12/1995",
						"Ranjan", "Singh", "Ranjup", "House Loan", "BNI123421412", "Kanchipuram", "12-2-1987",
						"22/5/2020", "submit", "1234");
			});
		} catch (InvalidDateFormatException e) {
			assertThrows(InvalidDateFormatException.class, () -> {
				implementation.loanApplicationForm("AP198", "BNI12345", "Pankaj", "", "Tripathy", "14/12/1995",
						"Ranjan", "Singh", "Ranjup", "House Loan", "BNI123421412", "Kanchipuram", "12-2-1987",
						"22/5/2020", "submit", "1234");
			});
		}
	}
	
	@Test
	void loanApplicationForm5() {
		Repository.UserTable();
		try {
			Boolean isBoolean = implementation.loanApplicationForm("AP198", "BNI12345", "Pankaj", "", "Tripathy",
					"14/12/3000", "Ranjan", "Singh", "Ranjup", "House Loan", "BNI123421412", "Kanchipuram", "12/2/1987",
					"22/5/2020", "submit", "1234");
			assertEquals(isBoolean, true);
		} catch (DateLimitException e) {
			assertThrows(DateLimitException.class, () -> {
				implementation.loanApplicationForm("AP198", "BNI12345", "Pankaj", "", "Tripathy", "14/12/3000",	
						"Ranjan", "Singh", "Ranjup", "House Loan", "BNI123421412", "Kanchipuram", "12/2/1987",
						"22/5/2020", "submit", "1234");
			});
		} catch (InvalidDateFormatException e) {
			assertThrows(InvalidDateFormatException.class, () -> {
				implementation.loanApplicationForm("AP198", "BNI12345", "Pankaj", "", "Tripathy", "14/12/3000",
						"Ranjan", "Singh", "Ranjup", "House Loan", "BNI123421412", "Kanchipuram", "12/2/1987",
						"22/5/2020", "submit", "1234");
			});
		}
	}
}
