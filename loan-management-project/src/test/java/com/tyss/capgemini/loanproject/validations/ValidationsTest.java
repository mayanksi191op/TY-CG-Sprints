package com.tyss.capgemini.loanproject.validations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.hibernate.id.enhanced.TableStructure;
import org.junit.jupiter.api.Test;

import com.tyss.capgemini.loanproject.validation.ValidationClass;

public class ValidationsTest {
	
	ValidationClass validationClass = new ValidationClass();
	
	@Test
	void passValidTest1() {
		Boolean boolean1 = validationClass.passValid("asdasdasd");
		assertEquals(boolean1, false); 
	}
	
	@Test
	void passValidTest2() {
		Boolean boolean1 = validationClass.passValid("Qwerty@123");
		assertEquals(boolean1, true); 
	}
	
	@Test
	void dateValidTest1() {
		Boolean boolean1 = validationClass.dateValid("12.12.12");
		assertEquals(boolean1, false);
	}
	
	@Test
	void dateValidTest2() {
		Boolean boolean1 = validationClass.dateValid("12/12/1996");
		assertEquals(boolean1, true);
	}
	
	@Test
	void mailValidTest1() {
		Boolean boolean1 = validationClass.mailValid("asdasdasd");
		assertEquals(boolean1, false);
	}
	
	@Test
	void mailValidTest2() {
		Boolean boolean1 = validationClass.mailValid("mayank@gmail.com");
		assertEquals(boolean1, true);
	}
	
	@Test
	void usernameValidTest1() {
		Boolean boolean1 = validationClass.usernameValid("mayank121");
		assertEquals(boolean1, true);
	}
	
	@Test
	void usernameValidTest2() {
		Boolean boolean1 = validationClass.usernameValid("@#$asdasd");
		assertEquals(boolean1, false);
	}
	
	@Test
	void alphaNumValidTest1() {
		Boolean boolean1 = validationClass.alphaNumValid("@#12");
		assertEquals(boolean1, false);
	}
	
	@Test
	void alphaNumValidTest2() {
		Boolean boolean1 = validationClass.alphaNumValid("as123");
		assertEquals(boolean1, true);
	}
	
	@Test
	void nameValidTest1() {
		Boolean boolean1 = validationClass.nameValid("mayank");
		assertEquals(boolean1, true);
	}
	
	@Test
	void nameValidTest2() {
		Boolean boolean1 = validationClass.nameValid("1234asd");
		assertEquals(boolean1, false);
	}
	
	@Test
	void fullNameValidTest1() {
		Boolean boolean1 = validationClass.fullNameValid("mayank singh");
		assertEquals(boolean1, true);
	}
	
	@Test
	void fullNameValidTest2() {
		Boolean boolean1 = validationClass.fullNameValid("mayank singh123");
		assertEquals(boolean1, false);
	}
	
	@Test
	void numMismatchTest1() {
		Boolean boolean1 = validationClass.numMismatch1("asdasd");
		assertEquals(boolean1, false);
	}
	
	@Test
	void numMismatchTest2() {
		Boolean boolean1 = validationClass.numMismatch1("123213");
		assertEquals(boolean1, true);
	}
	
	@Test
	void timePeriodValidTest1() {
		Boolean boolean1 = validationClass.timePeriodValid("90");
		assertEquals(boolean1, false);
	}
	
	@Test
	void timePeriodValidTest2() {
		Boolean boolean1 = validationClass.timePeriodValid("23");
		assertEquals(boolean1, true);
	}
	
	@Test
	void doubleValidTest1() {
		Boolean boolean1 = validationClass.doubleValid("asdasda");
		assertEquals(boolean1, false);
	}
	
	@Test
	void doubleValidTest2() {
		Boolean boolean1 = validationClass.doubleValid("8.2");
		assertEquals(boolean1, true);
	}
	
	@Test
	void phoneValidTest1() {
		Boolean boolean1 = validationClass.phoneValid("asdsadasd");
		assertEquals(boolean1, false);
	}
	
	@Test
	void phoneValidTest2() {
		Boolean boolean1 = validationClass.phoneValid("9878987867");
		assertEquals(boolean1, true);
	}
}
