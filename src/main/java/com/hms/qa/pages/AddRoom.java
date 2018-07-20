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
public class AddRoom extends TestBase {
	
	@FindBy(xpath="//*[@id=\"content\"]/app-hostel-view/app-hostel/div/table/tbody/tr[1]/td[7]/div/button[3]")
	WebElement clickRoomIcon;
	
	@FindBy(xpath="//*[@id=\"rooms\"]/div/section/div/div[3]/input")
	WebElement noOfRooms;
	
	@FindBy(xpath="//button[contains(text(),'Create Rooms')]")
	WebElement createRooms;
	
	@FindBy(xpath="//*[@id=\"rooms\"]/div/section/div/table/tbody[1]/tr[1]/td[3]/input")
	WebElement noOfBed;
	
	@FindBy(xpath="//*[@id=\"rooms\"]/div/section/div/table/tbody[1]/tr[1]/td[4]/input")
	WebElement maxGuests;
	
	@FindBy(xpath="//*[@id=\"rooms\"]/div/section/div/table/tbody[2]/tr[1]/td[3]/input")
	WebElement sharedNoOfBed;
	
	@FindBy(xpath="//button[contains(text(),'Apply&Continue')]")
	WebElement applyContinue;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement saveRoom;
	
	// Initializing the Page Objects
	public AddRoom() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	
	public void redirectAddRoomPage() {
		clickRoomIcon.click();
	}
	
	public void selectFloor() {
		Select floor = new Select(driver.findElement(By.xpath("//*[@id=\"rooms\"]/div/section/div/div[2]/select")));
		floor.selectByIndex(1);
	}
		
	public void enterNoOfRoom() {
		noOfRooms.clear();
		noOfRooms.sendKeys("2");
		createRooms.click();
	}
	
	public void roomType() {
		Select type = new Select(driver.findElement(By.xpath("//*[@id=\"rooms\"]/div/section/div/table/tbody[1]/tr[1]/td[2]/select")));
		type.selectByIndex(0);
	}
	public void enterNoOfBedPrivateRoom() {
		noOfBed.sendKeys("2");
		maxGuests.sendKeys("2");
	}
	
	public void roomTypeTwo() {
		Select type = new Select(driver.findElement(By.xpath("//*[@id=\"rooms\"]/div/section/div/table/tbody[1]/tr[1]/td[2]/select")));
		type.selectByIndex(1);
	}
	
	public void enterNoOfBedSharedRoom() {
		sharedNoOfBed.sendKeys("2");
	}
	
	public void saveAddedRooms() {
		applyContinue.click();
		saveRoom.click();
	}

}
