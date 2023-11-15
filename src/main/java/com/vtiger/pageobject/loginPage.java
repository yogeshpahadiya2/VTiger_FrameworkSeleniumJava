package com.vtiger.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.utilities.BaseClass;
import com.vtiger.utilities.WebDriverUtilities;

public class loginPage extends WebDriverUtilities {
	WebDriver ldriver;

	public loginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(name = "user_name")
	WebElement userName;
	@FindBy(name = "user_password")
	WebElement password;
	@FindBy(id = "submitButton")
	WebElement login;
	WebElement products;
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	WebElement administartor;
	@FindBy(linkText = "Sign Out")
	WebElement signOut;

	public void enterUserName(String username) {
		userName.sendKeys(username);
	}

	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}

	public void clickOnLoginButton() {
		login.click();
	}

	public void clickOnSignOut(WebDriver driver) throws InterruptedException {
		mouseOverAcion(driver, administartor);
		Thread.sleep(1000);
		signOut.click();
	}
}