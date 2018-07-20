/**
 * 
 */
package com.hms.qa.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.hms.qa.base.TestBase;
import com.hms.qa.pages.BookingPage;
import com.hms.qa.pages.SelectRooms;

/**
 * @author qc
 *
 */
public class BookingPageTest extends TestBase {

	SelectRooms selectRoom;
	BookingPage bookingPage;

	public BookingPageTest() {
		// Super class constructor will called by Super keyword
		super();
	}

	@BeforeTest
	public void setUp() {
		initialization();
		selectRoom = new SelectRooms();
		bookingPage = new BookingPage();
	}
	
	@Test
	public void bookHostelRoomTest() {			
		selectRoom.selectPlacesPage();
		selectRoom.viewHostelDetailPage();
		selectRoom.selectRoomsPage();
		selectRoom.selectNextFloor();
		selectRoom.clickBookNow();
	}
	
	@Test
	public void custDetailsTest() {
		bookingPage.enterCustName("Kishore", "kumar");
		bookingPage.enterPersonalDetails("nkishore@netphenix.com", "9787431055", "Ooty");
		bookingPage.acceptAndBook();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
}
