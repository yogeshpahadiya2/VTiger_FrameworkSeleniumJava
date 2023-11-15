package com.vtiger.utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * this class consists of all generic methods related to webdriver actions
 * 
 * @author Yogesh Pahadiya
 */
public class WebDriverUtilities {

	/**
	 * this method will maximize the window
	 * 
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {

		driver.manage().window().maximize();
	}

	/**
	 * this method will minimize the window
	 * 
	 * @param
	 */

	public void minimizeWindow(WebDriver driver) {

		driver.manage().window().minimize();
	}

	/**
	 * this method will wait for 10 seconds for the web apage to get loaded
	 * 
	 * @param driver
	 */

	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	/**
	 * this method will wait for 10 sec for the element to be visible
	 * 
	 * @param driver
	 * @param element
	 */

	public void waitForElementsToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * this method will wait for 10 sec for the element to be clickable
	 * 
	 * @param driver
	 * @param element
	 */

	public void waitForElementsToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * this method will handle drop-down by index
	 * 
	 * @param element
	 * @param index
	 */

	public void handleDropdown(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * this method will handle drop-down by value
	 * 
	 * @param element
	 * @param value
	 */
	public void handleDropdown(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	/**
	 * this method will handle drop-down by visiable text
	 * 
	 * @param text
	 * @param element
	 */

	public void handleDropdown(String text, WebElement element) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	/**
	 * This method will perform mouse hovering action
	 * 
	 * @param driver
	 * @param element
	 */

	public void mouseOverAcion(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}

	/**
	 * This method will perform double click action on a web element
	 * 
	 * @param driver
	 * @param element
	 */

	public void doubleClickAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}

	/**
	 * This method will perform right click action on a web element
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}

	/**
	 * This method will drag and drop the src element to target element
	 * 
	 * @param driver
	 * @param srcEle
	 * @param targetEle
	 */

	public void dragAndDropAction(WebDriver driver, WebElement srcEle, WebElement targetEle) {
		Actions act = new Actions(driver);
		act.dragAndDrop(srcEle, targetEle).perform();
	}

	/**
	 * This method will click and hold on to a particular web element
	 * 
	 * @param driver
	 * @param element
	 */

	public void clickAndHoldAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.clickAndHold(element).perform();
	}

	/**
	 * This method will scroll down for 500units
	 * 
	 * @param driver
	 */

	public void scrollDownAction(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("Window.scrollBy(0,500);", "");
	}

	/**
	 * This method will scroll up for 500units
	 * 
	 * @param driver
	 */

	public void scrollUpAction(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("Window.scrollBy(0,-500);", "");
	}

	/**
	 * This method will scroll right for 500units
	 * 
	 * @param driver
	 */

	public void scrollRightAction(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("Window.scrollBy(500,0);", "");
	}

	/**
	 * This method will scroll left for 500units
	 * 
	 * @param driver
	 */

	public void scrollLeftAction(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("Window.scrollBy(-500,0);", "");
	}

	/**
	 * This method will accept the alert popup
	 * 
	 * @param driver
	 */

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * This method will cancel the alert popup
	 * 
	 * @param driver
	 */

	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * 
	 * This method will capture the alert text and return to caller
	 * 
	 * @param driver
	 * @return
	 */

	public String getAlertText(WebDriver driver) {
		String text = driver.switchTo().alert().getText();
		return text;
	}

	/**
	 * This method will switch To Frame based on index
	 * 
	 * @param driver
	 * @param index
	 */

	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * This method will switch To Frame based on name or ID
	 * 
	 * @param driver
	 * @param nameId
	 */

	public void switchToFrame(WebDriver driver, String nameId) {
		driver.switchTo().frame(nameId);
	}

	/**
	 * this method will switch to frame based on webelement
	 * 
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * this method will switch the windows based on partial with title
	 * 
	 * @param driver
	 * @param partialWindowTitle
	 */

	public void switchToWindow(WebDriver driver, String partialWindowTitle) {
		// step 1: capture all the window ids
		Set<String> allWindowIDs = driver.getWindowHandles();
		// step 2: navigate through each window id
		for (String windowID : allWindowIDs) {
			// step 3: switch to each window and capture the title
			String actTitle = driver.switchTo().window(windowID).getTitle();
			// step 4: compare the actual title with expected partial window title
			if (actTitle.contains(partialWindowTitle)) {
				break;
			}
		}
	}

	/**
	 * This method will take screen shot and store it in required folder
	 * 
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws IOException
	 */

	public String captureScreenShot(WebDriver driver, String screenShotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\ScreenShots\\" + screenShotName + ".png");
		Files.copy(src, dst);
		return dst.getAbsolutePath(); // complete path of screenshot - extend reports
	}
}