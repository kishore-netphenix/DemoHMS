/**
 * 
 */
package com.hms.qa.tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hms.qa.base.TestBase;
import com.hms.qa.pages.AdminPage;
import com.hms.qa.pages.LoginDataDriven;
import com.hms.qa.pages.LoginPage;

/**
 * @author qc
 *
 */
public class LoginDataDrivenTest extends TestBase {
	
	LoginPage loginPage;
	AdminPage adminPage;
	LoginDataDriven loginDD;
	
	public LoginDataDrivenTest() {
		//Super class constructor will called by Super keyword 
		super();
	}
	
	@BeforeMethod
	public void setUp() {		
		initialization();
	}
	
	@Test
	public void testData() throws IOException {
		loginDD.ReadData();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
