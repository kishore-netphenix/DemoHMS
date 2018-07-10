/**
 * 
 */
package com.hms.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hms.qa.base.TestBase;

/**
 * @author qc
 *
 */
public class CreateHostel extends TestBase {

	@FindBy(xpath = "//input[@name='name']")
	WebElement hostelName;

	@FindBy(name = "email")
	WebElement emailId;

	@FindBy(xpath = "//input[@name='primary_phone']")
	WebElement phoneNo;

	@FindBy(name = "url")
	WebElement hostelUrl;

	@FindBy(name = "floors")
	WebElement noOfFloors;

	@FindBy(name = "default_currency")
	WebElement currency;

	@FindBy(name = "property_description")
	WebElement propDesc;

	@FindBy(name = "things_to_note")
	WebElement hostelNotes;

	@FindBy(name = "policy")
	WebElement hostelPolicy;

	@FindBy(name = "cancellation_policy")
	WebElement cancellationPolicy;

	@FindBy(xpath = "//*[@id=\"content\"]/app-hostel-view/app-hostel/div[2]/div[3]/div[1]/ng-multiselect-dropdown/div/div[1]/span")
	WebElement selectServices;
	
	@FindBy(xpath = "//div[contains(text(), 'Select All')]")
	WebElement allServices;

	@FindBy(xpath = "//*[@id=\"content\"]/app-hostel-view/app-hostel/div[2]/div[3]/div[2]/table/tbody/tr[1]/td[2]/input")
	WebElement baseService;

	@FindBy(xpath = "//*[@id=\"content\"]/app-hostel-view/app-hostel/div[2]/div[3]/div[2]/table/tbody/tr[2]/td[2]/input")
	WebElement depositAmount;

	@FindBy(xpath = "//*[@id=\"content\"]/app-hostel-view/app-hostel/div[2]/div[3]/div[2]/table/tbody/tr[3]/td[5]/input")
	WebElement ac;

	@FindBy(xpath = "//*[@id=\"content\"]/app-hostel-view/app-hostel/div[2]/div[3]/div[2]/table/tbody/tr[4]/td[5]/input")
	WebElement tv;

	@FindBy(xpath = "//*[@id=\"content\"]/app-hostel-view/app-hostel/div[2]/div[3]/div[2]/table/tbody/tr[5]/td[5]/input")
	WebElement washingMachine;

	@FindBy(xpath = "//*[@id=\"content\"]/app-hostel-view/app-hostel/div[2]/div[3]/div[2]/table/tbody/tr[6]/td[5]/input")
	WebElement wifi;

	@FindBy(xpath = "//button[@title='Pick File']")
	WebElement pickImage;

	@FindBy(xpath = "//button[@title='Upload']")
	WebElement uploadImage;

	@FindBy(xpath = "//button[contains(text(), 'Submit')]")
	WebElement saveHostel;

	// Initializing the Page Objects
	public CreateHostel() {
		PageFactory.initElements(driver, this);
	}

	// Actions

	public void enterHostelName() {
		hostelName.sendKeys("Yoga Hostel");
	}

	public void enterEmailId() {
		emailId.sendKeys("yogahostel@gmail.com");
	}

	public void enterPhoeNumber() {
		phoneNo.sendKeys("9879876769");
	}

	public void enterCountry() {
		Select country = new Select(driver.findElement(By.name("country")));
		country.selectByIndex(0);
	}

	public void enterState() {
		Select state = new Select(driver.findElement(By.name("state")));
		state.selectByIndex(0);
	}

	public void enterCity() {
		Select city = new Select(driver.findElement(By.name("city")));
		city.selectByIndex(0);
	}

	public void enterUrl() {
		hostelUrl.sendKeys("https://www.yogahostel.com/");
	}

	public void enterFloor() {
		noOfFloors.sendKeys("1");
	}

	public void enterCurrency() {
		currency.sendKeys("INR");
	}

	public void hostelPolicies() {
		propDesc.sendKeys("With youth hostels and cheap hotels in over 3,500 destinations worldwide our aim is to be the number one website for backpackers and student travel, and every traveler looking for great budget accommodation.");

		hostelNotes.sendKeys("1. Check in Time is after 12:00 NOON and Keep us informed if arriving after midnight. 2. Production of original passport is must for all Nationals and valid Visa for foreigners.");

		hostelPolicy.sendKeys("1. Age Restriction 2. Credit Cards Accepted 3. Non Smoking 4. Taxes Not Included");

		cancellationPolicy.sendKeys("Cancellation charges applicable");

	}

	public void selectHostelType() {
		Select hostel = new Select(driver
				.findElement(By.xpath("//*[@id=\"content\"]/app-hostel-view/app-hostel/div[2]/div[2]/div[15]/select")));
		hostel.selectByIndex(0);
	}

	public void selectPaymentType() {
		Select payment = new Select(driver
				.findElement(By.xpath("//*[@id=\"content\"]/app-hostel-view/app-hostel/div[2]/div[2]/div[16]/select")));
		payment.selectByIndex(1);
	}

	public void hostelServices() {
		selectServices.click();
	}

	public void selectAllServices() {
		allServices.click();
	}

	public void enterServiceDetails() {
		baseService.sendKeys("5000");
		depositAmount.sendKeys("10000");
		ac.click();
		tv.click();
		washingMachine.click();
		wifi.click();
	}

	public void selectHostelImages() {
		pickImage.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		uploadImage.click();
	}

	public void saveNewHostel() {
		saveHostel.click();
	}

}
