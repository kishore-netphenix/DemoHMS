/**
 * 
 */
package com.hms.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hms.qa.base.TestBase;

/**
 * @author qc
 *
 */
public class SignUpPage extends TestBase {

	@FindBy(xpath="//a[@data-hover='SIGNIN']")
	WebElement signInBtn;
	
	@FindBy(xpath="//a[contains(text(), 'Sign Up Here')]")
	WebElement signUpBtn;
	
	@FindBy(name="first_name")
	WebElement fname;
	
	@FindBy(name="last_name")
	WebElement lname;
	
	@FindBy(name="name")
	WebElement uname;
	
	@FindBy(name="email")
	WebElement emailId;
	
	@FindBy(xpath="//*[@id=\"login\"]/div/div/div/app-login/form[2]/app-register/div/div[2]/div/div[5]/input")
	WebElement pswd;
	
	@FindBy(name="confirmpassword")
	WebElement conpswd;
	
	@FindBy(name="primaryphone")
	WebElement phoneNo;
	
	@FindBy(name="secondaryphone")
	WebElement secPhoneNo;
	
	@FindBy(xpath="//input[@value='male']")
	WebElement gender;
	
	@FindBy(xpath="//*[@id=\"login\"]/div/div/div/app-login/form[2]/app-register/div/div[2]/div/div[10]/select")
	WebElement userType;
	
	@FindBy(xpath="//*[@id=\"login\"]/div/div/div/app-login/form[2]/app-register/div/div[2]/div/div[11]/input")
	WebElement accept;
	
	@FindBy(xpath="//button[contains(text(), 'Submit')]")
	WebElement submitBtn;
	
	
	// Initializing the Page Objects
	public SignUpPage() {
	
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public void clickSignInLink() {
		signInBtn.click();
	}
	
	public void clickSignUpLink() {
		signUpBtn.click();
	}
	
	public void enterUserDetails(String firstname, String lastname) {
		fname.sendKeys(firstname);
		lname.sendKeys(lastname);
	}

	public void createLoginName(String username, String email, String password, String conpassword) {
		uname.sendKeys(username);
		emailId.sendKeys(email);
		pswd.sendKeys(password);
		conpswd.sendKeys(conpassword);
	}
	
	public void addPhoneNumber(String mobnumber, String secphone) {
		phoneNo.sendKeys(mobnumber);
		secPhoneNo.sendKeys(secphone);
	}
	
	public void selectGender() {
		gender.click();		
	}
	
	public void userType() {
		Select usertype = new Select(userType);
		usertype.selectByIndex(1);
	}
	
	public void acceptAndSave() {
		accept.click();
		submitBtn.click();
	}	
	
}
