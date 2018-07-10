/**
 * 
 */
package com.hms.qa.tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hms.qa.base.TestBase;
import com.hms.qa.pages.AdminPage;
import com.hms.qa.pages.LoginPage;

/**
 * @author qc
 *
 */
public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	AdminPage adminPage;
	
	public LoginPageTest() {
		//Super class constructor will called by Super keyword 
		super();
	}
	
	@BeforeMethod
	public void setUp() {		
		initialization();
		loginPage = new LoginPage(); 		
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginPage.validatePageTitle();
		Assert.assertEquals(title, "Hostel");
	}
	
	@Test(priority=2)
	public void hmsLogoImageTest() {
		boolean flag = loginPage.validateHMSLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest() {
		adminPage = loginPage.login(prop.getProperty("user_name"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

