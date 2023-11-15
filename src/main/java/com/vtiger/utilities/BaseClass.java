package com.vtiger.utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.vtiger.pageobject.loginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public PropertyFileUtilities pUtil = new PropertyFileUtilities();
	public WebDriverUtilities wUtil = new WebDriverUtilities();
	public JavaUtilities jUtil = new JavaUtilities();
	public ExcelFileUtilities eUtil = new ExcelFileUtilities();

	String url = pUtil.getBaseUrl();
	String browser = pUtil.getBrowser();
	public String username = pUtil.getUserName();
	public String password = pUtil.getPassword();

	public static WebDriver driver;
	// public static Logger logger;

	@BeforeSuite(alwaysRun = true)
	public void bsConfig() {
		// logger.info("**********DB Connection Successful**********");
		System.out.println("**********DB Connection Successful**********");
	}

	@BeforeClass(alwaysRun = true)
	public void bcConfig() {
		switch (browser.toLowerCase()) {
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			driver = null;
			break;
		}
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// logger = LogManager.getLogger("VtigerFramework");
		driver.get(url);
		// logger.info("**********Url Opened**********");
		System.out.println("**********Url Opened**********");
	}

//	@BeforeMethod(alwaysRun = true)
//	public void bmConfig() {
//		loginPage lp = new loginPage(driver);
//		pUtil.getUserName();
//		pUtil.getPassword();
////		lp.enterUserName(username);
////		lp.enterPassword(password);
//		lp.clickOnLoginButton();
//		// logger.info("**********LogIn Successful**********");
//		System.out.println("**********LogIn Successful**********");
//	}
//
//	@AfterMethod(alwaysRun = true)
//	public void amConfig() throws InterruptedException {
//		loginPage lp = new loginPage(driver);
//		lp.clickOnSignOut(driver);
//		// logger.info("**********LogOut Successful**********");
//		System.out.println("**********LogOut Successful**********");
//	}

	@AfterClass(alwaysRun = true)
	public void acConfig() {
		driver.quit();
		// logger.info("**********Browser Closed Successful**********");
		System.out.println("**********Browser Closed Successful**********");
	}

	@AfterSuite(alwaysRun = true)
	public void asConfig() {
		// logger.info("**********DB Connection Closed Successful");
		System.out.println("**********DB Connection Closed Successful");
	}

	// user method to capture screen shot
	public void captureScreenShot(WebDriver driver, String testName) throws IOException {
		// step1: convert webdriver object to TakesScreenshot interface
		TakesScreenshot screenshot = ((TakesScreenshot) driver);
		// step2: call getScreenshotAs method to create image file
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir") + "//Screenshots//" + testName + ".png");
		// step3: copy image file to destination
		FileUtils.copyFile(src, dest);

	}
}
