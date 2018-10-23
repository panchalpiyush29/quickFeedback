package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.GooglePage;

import static org.testng.Assert.assertTrue;

public class GoogleSteps {

    private final GooglePage googlePage;

    public GoogleSteps(GooglePage googlePage) {
        this.googlePage = googlePage;
    }

    @Given("^I am on the google homepage$")

    public void iAmOnTheGoogleHomepage() {
        googlePage.navigateToHomepage();
    }

    @When("^I search for \"([^\"]*)\"$")
    public void iSearchFor(String searchText) {
        googlePage.enterQuery(searchText);
    }

    @Then("^I get my \"([^\"]*)\"$")
    public void iGetMy(String expectedPageTitle) {
        assertTrue(googlePage.verifyPageTitle(expectedPageTitle));
    }
}
