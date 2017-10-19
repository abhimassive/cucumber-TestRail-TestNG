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

public class Bookmark extends TestBase {

    HomePage homepage;
    MoviesPage moviesPage;


    @Before
    @BeforeClass
    //@Parameters("browserName")
    public void beginTest() {
        setupTest();
    }


    @Test(priority = 10)
    @Given("^I am logged in into AXIS RWA$")
    public void iAmLoggedIn() {
        driver.get("https://qa2.massiveaxis.com/");

    }

    @Test(priority = 20)
    @When("^I open up an item$")
    public void iOpenUpAnItem() throws InterruptedException {
        homepage = new HomePage(driver);
        //Thread.sleep(5000);
        homepage.clickOnHeaderSwipe();
        System.out.println(driver.getTitle());
    }

    @Test(priority = 30)
    @And("^I click on the Bookmark button$")
    public void iClickOnTheBookmarkButton() {
        moviesPage = new MoviesPage(driver);
        moviesPage.setBookmark();
    }

    @Test(priority = 40)
    @Then("^the item should be saved to my Bookmark history$")
    public void theItemShouldBeSavedToMyBookmarkHistory() {
        System.out.println("^the item should be saved to my Bookmark history$");
    }

    @After
    @AfterClass
    public void endTest() {
        driver.quit();
    }

}

