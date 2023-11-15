package com.vtiger.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.utilities.WebDriverUtilities;

public class contactPage extends WebDriverUtilities {
	WebDriver ldriver;

	public contactPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "Contacts")
	WebElement contacts;

	public void clickOnContactsLnk() {
		contacts.click();

	}
}
