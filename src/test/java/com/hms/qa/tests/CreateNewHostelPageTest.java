/**
 * 
 */
package com.hms.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hms.qa.base.TestBase;
import com.hms.qa.pages.AddRoom;
import com.hms.qa.pages.AdminPage;
import com.hms.qa.pages.CreateHostel;
import com.hms.qa.pages.LoginPage;

/**
 * @author qc
 *
 */
public class CreateNewHostelPageTest extends TestBase {

	LoginPage loginPage;
	AdminPage adminPage;
	CreateHostel createHostel;
	AddRoom addRoom;

	public CreateNewHostelPageTest() {
		// Super class constructor will called by Super keyword
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		adminPage = loginPage.login(prop.getProperty("user_name"), prop.getProperty("password"));
		createHostel = new CreateHostel();
		addRoom = new AddRoom();
	}

	@Test(priority = 1)
	public void verifyAdminPageTitleTest() {
		String adminPageTitle = adminPage.verifyAdminPageTitle();
		Assert.assertEquals(adminPageTitle, "Hostel", "Admin page title is not matched");
	}

	@Test(priority = 2)
	public void hostelDetailsTest() {
		adminPage.newHostel();
		createHostel.enterHostelName();
		createHostel.enterEmailId();
		createHostel.enterPhoeNumber();
		createHostel.enterCountry();
		createHostel.enterState();
		createHostel.enterCity();
		createHostel.enterUrl();
		createHostel.enterFloor();
		createHostel.enterCurrency();
		createHostel.locations();
		createHostel.hostelPolicies();
		createHostel.selectHostelType();
		createHostel.selectPaymentType();
		createHostel.hostelServices();
		createHostel.selectAllServices();
		createHostel.enterServiceDetails();
		createHostel.selectHostelImages();
		createHostel.saveNewHostel();			
	}
	
	@Test(priority = 3)
	public void hostelRoomsTest() {
		addRoom.redirectAddRoomPage();
		addRoom.selectFloor();
		addRoom.enterNoOfRoom();
		addRoom.roomType();
		addRoom.enterNoOfBedPrivateRoom();
		addRoom.roomTypeTwo();
		addRoom.enterNoOfBedSharedRoom();
		addRoom.saveAddedRooms();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
