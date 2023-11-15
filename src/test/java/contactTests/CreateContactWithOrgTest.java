package contactTests;

import org.testng.annotations.Test;

import com.vtiger.pageobject.contactInfoPage;
import com.vtiger.pageobject.contactPage;
import com.vtiger.pageobject.createNewContactPage;
import com.vtiger.pageobject.homePage;
import com.vtiger.pageobject.loginPage;
import com.vtiger.pageobject.organizationLookUpImgPage;
import com.vtiger.utilities.BaseClass;

import junit.framework.Assert;

public class CreateContactWithOrgTest extends BaseClass {
	@Test
	public void CreateNewContactWithOrgTest() throws Throwable {
		loginPage lp = new loginPage(driver);
		lp.enterUserName(username);
		lp.enterPassword(password);
		lp.clickOnLoginButton();
		homePage hp = new homePage(driver);
		hp.clickOnContacts();
		contactPage cp = new contactPage(driver);
		cp.clickOnContactsLnk();
		createNewContactPage cnp = new createNewContactPage(driver);
		cnp.clickOnContactLookUpImg();
		cnp.SelectMr();
		cnp.enterFirstName("Yogesh");
		cnp.enterLastName("Pahadiya");
		cnp.clickOnOrgLookUpImg();
		organizationLookUpImgPage olip = new organizationLookUpImgPage(driver);
		olip.selectOrganization(driver, "deloitte");
		cnp.clickOnSaveButton();
		contactInfoPage cip = new contactInfoPage(driver);
		String contactheader = cip.getContactHeader();
		Assert.assertTrue(contactheader.contains("Pahadiya"));
		if (contactheader.equals(cip.getContactHeader())) {
			Assert.assertTrue(true);
		} else {
			captureScreenShot(driver, "CreateNewContactWithOrgTest");
			Assert.assertFalse(false);
		}
		System.out.println(contactheader);
		lp.clickOnSignOut(driver);
	}
}
