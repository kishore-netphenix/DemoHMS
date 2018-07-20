/**
 * 
 */
package com.hms.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hms.qa.base.TestBase;

/**
 * @author qc
 *
 */
public class BookingPage extends TestBase {
	
	@FindBy(xpath="//*[@id=\"nonseamless\"]/div[1]/div[1]/input")
	WebElement fname;
	
	@FindBy(xpath="//*[@id=\"nonseamless\"]/div[1]/div[2]/input")
	WebElement lname;
	
	@FindBy(xpath="//*[@id=\"nonseamless\"]/div[2]/div[1]/input")
	WebElement email;
	
	@FindBy(xpath="//*[@id=\"nonseamless\"]/div[2]/div[2]/input")
	WebElement phoneNo;
	
	@FindBy(xpath="//*[@id=\"nonseamless\"]/div[3]/div/textarea")
	WebElement address;
	
	@FindBy(xpath="//*[@id=\"nonseamless\"]/div[4]/div/div/label/span[1]")
	WebElement acceptBooking;
	
	@FindBy(xpath="//button[contains(text(), 'Confirm My Booking')]")
	WebElement bookRoom;
	
	
	//Initializing Page Object
	
	public BookingPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public void enterCustName(String firstname, String lastname) {
		fname.sendKeys(firstname);
		lname.sendKeys(lastname);
	}
	
	public void enterPersonalDetails(String mailId, String mobile, String place) {
		email.sendKeys(mailId);
		phoneNo.sendKeys(mobile);
		address.sendKeys(place);
				
	}
	
	public void acceptAndBook() {
		acceptBooking.click();
		bookRoom.click();
	}
	
	
}
