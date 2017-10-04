package axisweb.massive.home;

import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import axisweb.automation.testbase.TestBase;
import axisweb.automation.uiActions.AccountDetails;
import axisweb.automation.uiActions.HomePage;

public class TC001_AccountDetails extends TestBase {

	HomePage homepage;
	AccountDetails account_details;

	@BeforeTest
	public void setup() {
		init();
	}

	@Test(priority = 10)
	public void loginToAxisWeb() {

		homepage = new HomePage(driver);

		homepage.loginToWebApp("abhijeet.daspatnaik@massive.co", "ABHI@dp11");
		AssertJUnit.assertEquals(homepage.getPageTitle(), "Axis - Home");
	}

	@Test(priority = 20)
	public void clickOnAccountBadge() {
		account_details = new AccountDetails(driver);
		account_details.clickOnAccountBadge();
	}

	@AfterClass
	public void endTest() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();

	}

}
