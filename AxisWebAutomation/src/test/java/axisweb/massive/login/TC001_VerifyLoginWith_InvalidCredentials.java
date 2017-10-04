package axisweb.massive.login;

import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import axisweb.automation.testbase.TestBase;
import axisweb.automation.uiActions.HomePage;

public class TC001_VerifyLoginWith_InvalidCredentials extends TestBase {

	HomePage homepage;

	@BeforeTest
	public void setup() {
		init();
	}

	@Test
	public void verifyLoginWithInvalidCredentials() {
		
		homepage = new HomePage(driver);

		homepage.loginToWebApp("wrong_email@invalidcompany.co", "wrong_password");
		AssertJUnit.assertEquals(homepage.getLoginErrorMsg(),
				"Looks like your email or password is incorrect. Please try again.");
	}

	@AfterClass
	public void endTest() throws InterruptedException {
		driver.quit();

	}

}