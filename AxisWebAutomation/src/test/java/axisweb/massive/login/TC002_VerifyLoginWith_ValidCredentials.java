package axisweb.massive.login;

import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import axisweb.automation.testbase.TestBase;
import axisweb.automation.uiActions.HomePage;
import testrail.TestRail;

public class TC002_VerifyLoginWith_ValidCredentials extends TestBase {

	HomePage homepage;

	@BeforeTest
	public void setup() {
		init();
	}

	@Test
	@TestRail(testCaseId = 595545)
	public void verifyLoginWith_ValidCredentials() {

		homepage = new HomePage(driver);

		homepage.loginToWebApp("abhijeet.daspatnaik@massive.co", "ABHI@dp11");
		AssertJUnit.assertEquals(homepage.getPageTitle(), "Axis - Home");
	}

	@AfterClass
	public void endTest() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();

	}

}