package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import testbase.TestBase;

public class Login extends TestBase {


    HomePage homepage;// = new HomePage(driver);
    //public Login(WebDriver driver) { this.driver = driver; }


    @Before
    @BeforeClass
    //@Parameters("browserName")
    public void beginTest() {
        setupTest();
    }


    @Test(priority = 10)
    @Given("^I navigate to Axis RWA$")
    public void Step_10_iNavigateToAxisWeb() {
        driver.get("https://qa2.massiveaxis.com/");
    }

    @Test(priority = 20)//, enabled = false)
    @And("^I click on Sign In$")
    public void Step_20_iClickOnSignIn() {
        homepage = new HomePage(driver);
        homepage.clickSignIn();
    }

    @Test(priority = 30)//, enabled = false)
    @And("^I Login with incorrect Email and Password$")
    public void Step_30_iEnterIncorrectCredentials() {
        homepage = new HomePage(driver);

        homepage.login_email.clear();
        homepage.login_email.sendKeys("Incorrect_Email@Company.com");

        homepage.login_password.clear();
        homepage.login_password.sendKeys("IncorrectPassword123");

        homepage.clickLoginButton();

    }

    @Test(priority = 40)//, enabled = false)
    @Parameters({"expectedLoginErrorMessage"})
    @Then("^I should see an Unsuccessful login message: \"([^\"]*)\" 😲$")
    public void Step_40_iShouldSeeAnErrorMessage(String expectedLoginErrorMessage) throws InterruptedException {
        homepage = new HomePage(driver);

        Assert.assertEquals(homepage.actualLoginErrorMessage(), expectedLoginErrorMessage);

    }

    @Test(priority = 50)//, enabled = false)
    @Parameters({"email", "password"})
    @But("^When I Login with correct \"([^\"]*)\" and \"([^\"]*)\"$")
    public void Step_50_iEnterCorrectEmailAndPassword(String email, String password) {
        homepage = new HomePage(driver);

        homepage.login_email.clear();
        homepage.login_email.sendKeys(email);

        homepage.login_password.clear();
        homepage.login_password.sendKeys(password);

        homepage.clickLoginButton();
    }


    @Test(priority = 60)//, enabled = false)
    //@TestRail(testCaseId = 595545)
    @Parameters({"email"})
    @Then("^I should Successfully login and see my account badge with the first letter of my \"([^\"]*)\" in uppercase 😃$")
    public void Step_60_iSeeAccountBadge(String email) {
        homepage = new HomePage(driver);
        homepage.whosWatching();
        Assert.assertEquals(homepage.getProfileIconLetter(), email.substring(0, 1).toUpperCase());

    }


    @After
    @AfterClass
    public void endTest() {
        driver.quit();
    }


}
