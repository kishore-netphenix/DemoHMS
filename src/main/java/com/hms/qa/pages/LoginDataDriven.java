/**
 * 
 */
package com.hms.qa.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hms.qa.base.TestBase;

/**
 * @author qc
 *
 */
public class LoginDataDriven extends TestBase {

	
	@FindBy(xpath = "//a[@data-hover='SIGNIN']")
	WebElement signIn;

	@FindBy(name = "user_name")
	WebElement user_name;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//button[contains(text(), 'Login')]")
	WebElement lgnBtn;
	
	@FindBy(xpath = "//i[@class= 'glyphicon glyphicon-log-out']")
	WebElement logoutBtn;
	
	WebDriver driver;
	WebDriverWait wait;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;
	
	// Initializing the Page Objects
	public LoginDataDriven() {
			PageFactory.initElements(driver, this);
		}

	public void ReadData() throws IOException {
		// Import excel sheet.
		File src = new File("/home/qc/eclipse-workspace/POMHMSProject/src/main/java/com/hms/qa/testdata/TestData.xlsx");

		// Load the file.
		FileInputStream finput = new FileInputStream(src);

		// Load he workbook.
		workbook = new XSSFWorkbook(finput);

		// Load the sheet in which data is stored.
		sheet = workbook.getSheetAt(0);

		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			// Import data for Email.
			cell = sheet.getRow(i).getCell(1);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			signIn.click();
			user_name.sendKeys(cell.getStringCellValue());

			// Import data for password.
			cell = sheet.getRow(i).getCell(2);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			password.sendKeys(cell.getStringCellValue());
			lgnBtn.click();
			logoutBtn.click();

			// Write data in the excel.
			FileOutputStream foutput = new FileOutputStream(src);

			// Specify the message needs to be written.
			String message = "Pass";

			// Create cell where data needs to be written.
			sheet.getRow(i).createCell(3).setCellValue(message);

			// Specify the file in which data needs to be written.
			FileOutputStream fileOutput = new FileOutputStream(src);

			// finally write content
			workbook.write(fileOutput);

			// close the file
			fileOutput.close();

		}
	}

}
