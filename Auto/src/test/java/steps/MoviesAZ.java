package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MoviesPage;
import testbase.TestBase;

public class MoviesAZ extends TestBase {

    HomePage homepage;
    MoviesPage moviesPage;


    @Before
    @BeforeClass
    //@Parameters("browserName")
    public void beginTest() {
        setupTest();
    }


    @Test(priority = 10)
    @Given("^I am on the AXIS RWA HOMEpage$")
    public void Step_10_iAmOnAxisRWAHomepage() {
        driver.get("https://qa2.massiveaxis.com/");
    }


    @Test(priority = 20)
    @When("^I hover my mouse over MOVIES link$")
    public void Step_20_iHoverMyMouseOverMOVIESLink() throws InterruptedException {
        homepage = new HomePage(driver);
        homepage.moviesMouseHover();
    }

    @Test(priority = 30)
    @Then("^A drop down frame appears containing option A-Z$")
    public void aDropDownFrameAppearsContainingOptionAZ() {
        homepage = new HomePage(driver);
        homepage.moviesDropDown();
    }

    @Test(priority = 40)
    @And("^I click on the A-Z option$")
    public void iClickOnTheAZOption() {
        homepage = new HomePage(driver);
        homepage.clickOnAZ();
    }

    @Test(priority = 50)
    @Then("^Movies are sorted alphabetically from A-Z$")
    public void moviesAreSortedAlphabeticallyFromAZ() throws InterruptedException {
        moviesPage = new MoviesPage(driver);
        moviesPage.getMoviesList();
    }

    @After
    @AfterClass
    public void endTest() {
        driver.quit();
    }


}
