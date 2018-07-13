/**
 * 
 */
package com.hms.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hms.qa.base.TestBase;
import com.hms.qa.pages.SignUpPage;

/**
 * @author qc
 *
 */
public class SignUpPageTest extends TestBase {
	
	SignUpPage signUp;	
	
	public SignUpPageTest() {
		//Super class constructor will called by Super keyword 
		super();
	}
	
	@BeforeMethod
	public void setUp() {		
		initialization();
		signUp = new SignUpPage();	
	}

	@Test
	public void clickSignInTest() {
		signUp.clickSignInLink();
		signUp.clickSignUpLink();
		signUp.enterUserDetails("Arul", "Jose");
		signUp.createLoginName("arul", "ajose@netphenix.com", "1234", "1234");
		signUp.addPhoneNumber("9003387322", "00000");
		signUp.selectGender();
		signUp.userType();
		signUp.acceptAndSave();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
