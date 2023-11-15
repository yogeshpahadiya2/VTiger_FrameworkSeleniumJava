package com.vtiger.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.utilities.WebDriverUtilities;

public class createNewContactPage extends WebDriverUtilities {

	WebDriver ldriver;

	public createNewContactPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//img[@alt='Create Contact...']")
	WebElement contactLookUpImg;
	@FindBy(name = "salutationtype")
	WebElement selectGender;
	@FindBy(name = "firstname")
	WebElement firstName;
	@FindBy(name = "lastname")
	WebElement lastName;
	@FindBy(xpath = "//img[@alt='Select']")
	WebElement organizationLookUpImg;
	@FindBy(name = "button")
	WebElement saveButton;

	public void clickOnContactLookUpImg() {
		contactLookUpImg.click();
	}

	public void SelectMr() {
		selectGender.click();
		handleDropdown(selectGender, 1);
	}

	public void enterFirstName(String firstname) {
		firstName.sendKeys(firstname);
	}

	public void enterLastName(String lastname) {
		lastName.sendKeys(lastname);
	}

	public void clickOnOrgLookUpImg() {
		organizationLookUpImg.click();
	}

	public void clickOnSaveButton() {
		saveButton.click();
	}

}
