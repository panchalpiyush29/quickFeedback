package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.GooglePage;

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

    @Then("^I get (\\d+) \"([^\"]*)\"$")
    public void iGet(int expectedSearchResults, String arg0) {
        googlePage.verifySearchResultRecord(expectedSearchResults);
    }
}
