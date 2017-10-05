package Steps;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LoginStep {
    @Given("^I navigate to the login page of Axis Web$")
    public void iNavigateToTheLoginPageOfAxisWeb() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("I navigate to the login page of Axis Web");
        }

    @And("^I enter the following credentials$")
    public void iEnterTheFollowingCredentials(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }



    @And("^I click on Login button$")
    public void iClickOnLoginButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("I click on Login button");
    }

    @Then("^I should see the Axis Home page$")
    public void iShouldSeeTheAxisHomePage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("I should see the Axis Home page");
    }


}
