/**
 * 
 */
package com.hms.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hms.qa.base.TestBase;

/**
 * @author qc
 *
 */
public class UserPage extends TestBase {
	
	@FindBy(xpath="//*[@id=\"sidebar\"]/ul/li[6]/a")
	WebElement userList;
	
	@FindBy(xpath="//button[contains(text(),'Add')]")
	WebElement addUserBtn;
	
	@FindBy(xpath="//input[@name='firstname']")
	WebElement fname;
	
	@FindBy(xpath="//input[@name='lastname']")
	WebElement lname;
	
	@FindBy(xpath="//input[@type= 'text' and @placeholder='UserName']")
	WebElement uname;
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement pswd;
	
	@FindBy(xpath="//input[@name='confirmpassword']")
	WebElement cpswd;
	
	@FindBy(xpath="//input[@name='primary_phone']")
	WebElement phoneNo;
	
	@FindBy(xpath="//input[@name='secondary_phone']")
	WebElement secPhoneNo;
	
	@FindBy(xpath="//input[@name='gender' and @value='male']")
	WebElement gender;
	
	@FindBy(xpath="//*[@id=\"content\"]/app-user/div[2]/div[2]/div[10]/select")
	WebElement agencyName;

	@FindBy(xpath="//*[@id=\"content\"]/app-user/div[2]/div[2]/div[11]/select")
	WebElement userType;
	
	@FindBy(xpath="//button[contains(text(),'Submit')]")
	WebElement submitBtn;
	
	// Initializing the Page Objects
	public UserPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public String verifyUserPageTitle() {
		return driver.getTitle();
	}
	
	public void viewUserPage() {
		userList.click();
	}
	
	public void redirectToUserPage() {
		addUserBtn.click();
	}
	
	public void userDetail(String firstname, String lastname) {
		fname.sendKeys(firstname);
		lname.sendKeys(lastname);
	}
	
	public void userLoginDetail(String username, String mailId, String password, String conpswd) {
		email.sendKeys(mailId);
		uname.sendKeys(username);
		pswd.sendKeys(password);
		cpswd.sendKeys(conpswd);
	}
	
	public void enterPhoneDetails(String mobnumber, String secmob ) {
		phoneNo.sendKeys(mobnumber);
		secPhoneNo.sendKeys(secmob);		
	}
	
	public void selectGender() {
		gender.click();
	}
	
	public void selectAgencyType() {
		Select agency = new Select(agencyName);
		agency.selectByIndex(0);
	}
	
	public void selectUserType() {
		Select user = new Select(userType);
		user.selectByIndex(1);
	}
	
	public void addUser() {
		submitBtn.click();
	}
	
}
