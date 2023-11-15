package com.vtiger.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contactInfoPage {
	WebDriver ldriver;

	public contactInfoPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	WebElement contactHeaderText;

	public String getContactHeader() {
		String text = contactHeaderText.getText();
		return text;

	}
}
