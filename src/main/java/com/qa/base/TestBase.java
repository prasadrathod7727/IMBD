package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.log4testng.Logger;

import com.qa.utilities.SeleniumActions;
import com.qa.utilities.TestUtils;
import com.qa.utilities.WebDriverListener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	protected static WebDriver driver;
	protected static Properties properties;
	protected static SeleniumActions sele_Actions;
	protected static WebDriverListener eventListener;
	protected static EventFiringWebDriver e_driver;
	protected static ChromeOptions chromeOptions;
	protected static Logger log;

	/*
	 * protected ITestResult result; protected ExtentReports extent; protected
	 * ExtentTest extentTest;
	 */
	public TestBase() {

		try {
			properties = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/qa/config/config.properties");
			properties.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("file not found");
		} catch (IOException e) {
			System.out.println("io exception");

		}

	}

	protected static void initializaton() {
		String browserName = properties.getProperty("browser");
		driver = getDriver(browserName);
		log.info(browserName + " is configured");

		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebDriverListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

		driver.get(properties.getProperty("url"));

		sele_Actions = new SeleniumActions();

	}

	private static WebDriver getDriver(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
		//	WebDriverManager.chromedriver().setup();
		//	WebDriver driver=new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("FF")) {
			WebDriverManager.firefoxdriver().setup();
			WebDriver driver=new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("IE")) {
			
		}
		return null;
	}

	public void tearDownMain() {
		driver.manage().deleteAllCookies();
		driver.close();
	}

}
