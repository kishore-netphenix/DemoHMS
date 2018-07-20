/**
 * 
 */
package com.hms.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.hms.qa.base.TestBase;
import com.hms.qa.pages.AdminPage;
import com.hms.qa.pages.LoginPage;
import com.hms.qa.pages.UserPage;

/**
 * @author qc
 *
 */
public class AddUserPageTest extends TestBase {
	
	LoginPage loginPage;
	AdminPage adminPage;
	UserPage userPage;
	

	public AddUserPageTest() {
		// Super class constructor will called by Super keyword
		super();
	}

	@BeforeTest
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		adminPage = loginPage.login(prop.getProperty("uname"), prop.getProperty("pswd"));
		userPage = new UserPage();
	}
	
	@Test(priority=1)	
	public void verifyUserPageTitleTest() {
		String userPageTitle = userPage.verifyUserPageTitle();
		Assert.assertEquals(userPageTitle, "Hostel", "Admin page title is not matched");
	}

	@Test(priority=2)
	public void selectUsersTest() {
		userPage.viewUserPage();		
	}
	
	@Test(priority=3)
	public void clickAddUserTest() {
		userPage.redirectToUserPage();		
	}
	
	@Test(priority=4)
	public void enterUserDetailTest() {
		userPage.userDetail("kishore", "kumar");
		userPage.userLoginDetail("vijay1", "vijay1@netphenix.com", "1234", "1234");
		userPage.enterPhoneDetails("9787431055", "8248778562");
		userPage.selectGender();
		userPage.selectAgencyType();
		userPage.selectUserType();
		userPage.addUser();		
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	

}
