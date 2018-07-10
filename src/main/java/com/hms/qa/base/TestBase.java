/**
 * 
 */
package com.hms.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.hms.qa.util.TestUtil;

/**
 * @author qc
 *
 */
public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"/home/qc/eclipse-workspace/POMHMSProject/src/main/java/com/hms/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
    public static void initialization() {
    	String browserName = prop.getProperty("browser");
//    	if(browserName.equals("Firefox")) {
    		System.setProperty("webdriver.gecko.driver", "/home/qc/Documents/Selenium/geckodriver-v0.20.1-linux64/geckodriver");
    		driver = new FirefoxDriver();
//    	}
//    	else if(browserName.equals("chrome")){
//    		System.setProperty("webdriver.chrome.driver", "/home/qc/Documents/Selenium/chromedriver_linux64 (1)/chromedriver");
//    		driver = new ChromeDriver();
//    	}
    	
    	driver.manage().window().maximize();
    	driver.manage().deleteAllCookies();    	
    	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
    	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    	
    	driver.get(prop.getProperty("url"));
    }
}
