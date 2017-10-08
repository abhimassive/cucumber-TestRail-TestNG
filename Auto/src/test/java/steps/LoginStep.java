package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import testbase.TestBase;
import testrail.TestRail;

public class LoginStep extends TestBase {


    HomePage homepage;


    @Before
    @BeforeTest
    public void setup() {
        init();
    }

    @Test(priority = 10)
    @Given("^I navigate to Axis RWA$")
    public void iNavigateToAxisWeb() {
        driver.get("https://qa2.massiveaxis.com/");
    }

    @Test(priority = 20)
    @When("^I click on Sign In$")
    public void iClickOnSignIn() {
        homepage = new HomePage(driver);
        homepage.clickSignIn();
    }

    @Test(priority = 30)
    @And("^I Login with incorrect Email and Password$")
    public void iEnterIncorrectCredentials() {
        homepage = new HomePage(driver);

        homepage.login_email.clear();
        homepage.login_email.sendKeys("Incorrect_Email@Company.com");

        homepage.login_password.clear();
        homepage.login_password.sendKeys("IncorrectPassword123");

        homepage.clickLoginButton();

    }

    @Test(priority = 40)
    @Parameters({"expectedLoginErrorMessage"})
    @Then("^I should see an Unsuccessful login message: \"([^\"]*)\"$")
    public void iShouldSeeAnErrorMessage(String expectedLoginErrorMessage) {
        homepage = new HomePage(driver);
        Assert.assertEquals(homepage.actualLoginErrorMessage(), expectedLoginErrorMessage);

    }

    @Test(priority = 50)
    @Parameters({"email", "password"})
    @But("^When I Login with correct \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iEnterCorrectEmailAndPassword(String email, String password) {
        homepage = new HomePage(driver);

        homepage.login_email.clear();
        homepage.login_email.sendKeys(email);

        homepage.login_password.clear();
        homepage.login_password.sendKeys(password);

        homepage.clickLoginButton();
    }


    @Test(priority = 70)
    @TestRail(testCaseId = 595545)
    @Parameters({"email"})
    @Then("^I should Successfully login and see my account badge with the first letter of my \"([^\"]*)\" in uppercase$")
    public void iSeeAccountBadge(String email) {
        HomePage homepage = new HomePage(driver);
        Assert.assertEquals(homepage.getProfileIconLetter(), email.substring(0, 1).toUpperCase());

    }


    @After
    @AfterClass
    public void endTest() {
        driver.quit();
    }

}
