package contactTests;

import org.testng.annotations.*;

import com.vtiger.pageobject.contactPage;
import com.vtiger.pageobject.createNewContactPage;
import com.vtiger.pageobject.homePage;
import com.vtiger.pageobject.loginPage;
import com.vtiger.utilities.BaseClass;

public class CreateContactTest extends BaseClass {
	@Test
	public void CreateNewContactTest() throws InterruptedException {
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
		cnp.clickOnSaveButton();
		lp.clickOnSignOut(driver);
	}

}
