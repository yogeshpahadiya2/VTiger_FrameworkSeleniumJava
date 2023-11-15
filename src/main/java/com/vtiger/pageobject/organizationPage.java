package com.vtiger.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.utilities.BaseClass;

public class organizationPage extends BaseClass {
	WebDriver ldriver;

	public organizationPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(linkText = "Organizations")
	WebElement orgLnk;

	public void clickOnOrgLnk() {
		orgLnk.click();
	}
}
