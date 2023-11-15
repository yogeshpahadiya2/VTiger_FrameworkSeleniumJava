package com.vtiger.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createNewOrganizationPage {
	WebDriver ldriver;

	public createNewOrganizationPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//img[@title='Create Organization...']")
	WebElement orgLookUpImg;
	@FindBy(name = "accountname")
	WebElement orgName;

	public void clickOnOrgLookUpImg() {
		orgLookUpImg.click();
	}

	public void enterOrgName(String orgname) {
		orgName.sendKeys(orgname);
	}

}
