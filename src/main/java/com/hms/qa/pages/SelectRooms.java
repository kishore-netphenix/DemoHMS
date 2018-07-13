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
public class SelectRooms extends TestBase {
	
	@FindBy(xpath="//select[@name='search_country']")
	WebElement country;
	
	@FindBy(xpath="//select[@name='search_city']")
	WebElement city;

	@FindBy(xpath="//*[@id=\"header\"]/div/div/button")
	WebElement searchBtn;
	
	@FindBy(xpath="/html/body/app-root/app-guest-index/app-view/div/div/div/app-list/div/div[1]/app-list-reviews/div/a")
	WebElement viewBtn;
	
	@FindBy(xpath="/html/body/app-root/app-guest-index/app-detailview/div[1]/div/div[3]/div/table/tbody/tr/td[3]/div/select")
	WebElement noOfGuests;
	
	@FindBy(xpath="//button[contains(text(), 'Quote Price')]")
	WebElement quotePrice;
	
	@FindBy(xpath="/html/body/app-root/app-guest-index/app-detailview/div/div[1]/div[2]/div/div/select")
	WebElement changeFloor;
	
	@FindBy(xpath="//a[contains(text(), '201')]")
	WebElement selectRoom;
	
	@FindBy(xpath="/html/body/app-root/app-guest-index/app-detailview/div/div[1]/div[3]/div/table/tbody/tr/td[4]/input")
	WebElement pvtRoomGuests;
	
	@FindBy(xpath="//button[contains(text(),'Book Now')]")
	WebElement bookNow;
	
	
	// Initializing the Page Objects
	public SelectRooms() {
		
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public void selectPlacesPage() {
		Select countryName = new Select(country);
		countryName.selectByIndex(1);
		
		Select cityName = new Select(city);
		cityName.selectByIndex(1);
		
		searchBtn.click();
	}
	
	public void viewHostelDetailPage() {
		viewBtn.click();
	}
	
	public void selectRoomsPage() {
		Select guests = new Select(noOfGuests);
		guests.selectByIndex(1);
		
		quotePrice.click();		
		
	}
	
	public void selectNextFloor() {
		Select floor = new Select(changeFloor);
		floor.selectByIndex(2);
		
		selectRoom.click();
		
		pvtRoomGuests.sendKeys("5");
		
		quotePrice.click();
	}
	
	public void clickBookNow() {
		bookNow.click();
	}
	
			
}
