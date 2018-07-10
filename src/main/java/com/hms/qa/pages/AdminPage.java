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
public class AdminPage extends TestBase {

	@FindBy(xpath = "//button[contains(text(), 'Add')]")
	WebElement addHostel;

	// Initializing the Page Objects
	public AdminPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyAdminPageTitle() {
		return driver.getTitle();
	}

	public CreateHostel newHostel() {
		addHostel.click();		
		return new CreateHostel();
	}
	
	
}
