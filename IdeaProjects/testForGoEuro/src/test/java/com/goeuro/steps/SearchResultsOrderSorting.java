package com.goeuro.steps;

import com.goeuro.pages.HomePage;
import com.goeuro.pages.SearchResultsPage;
import cucumber.api.java.en.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by aviv on 18/03/16.
 */
public class SearchResultsOrderSorting extends Step {

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
        homePage.fillInFieldsAndSearch(origin,destination);
    }

    @Then("^I am on the search results page$")
    public void iAmOnTheSearchResultsPage() {
        searchResultsPage.verifyPageOpened();

    }

    @When("^I list the search result's prices$")
    public void iListTheSearchResultSPrices() {
        searchResultsPage.intsTrainPricesAfterComma();
    }

    @Then("^the results should be ordered from the cheapest to the most expensive$")
    public void theResultsShouldBeOrderedFromTheCheapestToTheMostExpensive() {
        searchResultsPage.validateSorting();
    }
}
