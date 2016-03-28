package com.goeuro.steps;

import com.goeuro.pages.HomePage;
import com.goeuro.pages.SearchResultsPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by aviv on 18/03/16.
 */
public class HomePageSearch extends Step {

    @Autowired
    protected HomePage homePage;

    @Autowired
    protected SearchResultsPage searchResultsPage;


    @Given("^I am on the homepage$")
    public void navigateToDepartmentsPage() {
        homePage.open();
    }

    @When("^I search for a trip from (.*) to (.*)$")
    public void iSearchForATripFromTo(String origin, String destination)  {
        homePage.fillInSearchFields(origin,destination);
    }

    @Then("^I am on the search results page$")
    public void iAmOnTheSearchResultsPage() throws Throwable {
        searchResultsPage.verifyPageOpened();
    }
}
