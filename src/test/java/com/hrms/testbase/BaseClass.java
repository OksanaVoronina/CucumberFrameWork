package com.hrms.testbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	public static WebDriver driver;

	public static WebDriver setUp() {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "true");
		ConfigsReader.readProperties(Constants.Chrome_Driver);
		String headless= ConfigsReader.getPropery("headless");

		switch (ConfigsReader.getPropery("browser").toLowerCase()) {
        
		case "chrome":
			WebDriverManager.chromedriver().setup();
			ChromeOptions cOption = new ChromeOptions();
			if (headless.equalsIgnoreCase("true")) {
				cOption.setHeadless(true);
				driver = new ChromeDriver(cOption);
			}else{
			driver = new ChromeDriver(cOption);
			}
			break;

		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			throw new RuntimeException("browser not suported");
		}
	
	
		//to make screen big
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		driver.get(ConfigsReader.getPropery("url"));

		//Initialize all page Objects as part of set up
		PageInitializer.initialize();
		return driver;
	}

	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}

