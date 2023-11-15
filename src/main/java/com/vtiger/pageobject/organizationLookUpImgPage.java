package com.vtiger.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.utilities.WebDriverUtilities;

public class organizationLookUpImgPage extends WebDriverUtilities {
	WebDriver ldriver;

	public organizationLookUpImgPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(name = "search_text")
	WebElement searchOrgName;
	@FindBy(name = "search")
	WebElement searchOrgButton;

	public void selectOrganization(WebDriver driver, String orgName) {
		switchToWindow(driver, "Accounts");
		searchOrgName.sendKeys(orgName);
		searchOrgButton.click();
		driver.findElement(By.xpath("//a[.='" + orgName + "']")).click();
		switchToWindow(driver, "Contacts");

	}
}