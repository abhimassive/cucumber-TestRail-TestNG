package axisweb.massive.login;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import axisweb.automation.testbase.TestBase;
import axisweb.automation.uiActions.HomePage;
import testrail.TestRail;
import testrail.TestRailAPI;

@Listeners(listeners.TestListener.class)
public class TC001_VerifyLoginWith_InvalidCredentials extends TestBase {

	HomePage homepage;

	@BeforeTest
	public void setup() {
		init();
	}

	@Test(priority = 10)
	public void testAPI() throws Exception {
		TestRailAPI api = new TestRailAPI();
		@SuppressWarnings("static-access")
		String testRailCase = api.getCase(595545).toString();
		System.out.println("TestCase Details JSON : " + testRailCase);
	}

	@Test(priority = 20)
	@TestRail(testCaseId = { 595545 })
	public void verifyLoginWithInvalidCredentials() {

		homepage = new HomePage(driver);

		homepage.loginToWebApp("wrong_email@invalidcompany.co", "wrong_password");
		Assert.assertEquals(homepage.getLoginErrorMsg(),
				"Looks like your email or password is incorrect. Please try again.");
	}

	@AfterClass
	public void endTest() throws InterruptedException {
		driver.quit();

	}

}