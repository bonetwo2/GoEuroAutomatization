package com.goeuro.steps;

import com.goeuro.pages.HomePage;
import cucumber.api.java.en.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by aviv on 18/03/16.
 */
public class SearchResultsOrderSorting extends Step {

    @Autowired
    protected HomePage homePage;


    @Given("^I am on the homepage$")
    public void navigateToDepartmentsPage() {
        homePage.open();
    }
}
