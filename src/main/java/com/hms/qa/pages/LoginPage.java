/**
 * 
 */
package com.hms.qa.pages;

import com.hms.qa.base.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author qc
 *
 */
public class LoginPage extends TestBase {

	// PageFactory (or) OR Object Repository

	@FindBy(xpath = "//a[@data-hover='SIGNIN']")
	WebElement signIn;

	@FindBy(name = "user_name")
	WebElement user_name;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//button[contains(text(), 'Login')]")
	WebElement lgnBtn;
	
	@FindBy(xpath = "/html/body/app-root/app-guest-index/app-header/div/div/app-header-navigation/div/div[1]/a/h3/img")
	WebElement hmsLogo;

	// Initializing the Page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions

	public String validatePageTitle() {
		return driver.getTitle();
	}
	
	public AdminPage login(String un, String pwd) {
		signIn.click();
		user_name.sendKeys(un);
		password.sendKeys(pwd);
		lgnBtn.click();
		
		return new AdminPage();
	}
	
}
