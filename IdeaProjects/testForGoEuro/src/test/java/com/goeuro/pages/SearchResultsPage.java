package com.goeuro.pages;


import com.goeuro.Bindings;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.hamcrest.Matchers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;


/**
 * Created by aviv on 18/03/16.
 */

@Component
public class SearchResultsPage extends Bindings {

    @Override
    @Value("${url.searchresultspage}")
    public void setUrl(String url) {
        this.url = url;
    }

    /// Selectors ///

    @FindBy(xpath = "//*[@id='results-train']/descendant::*[contains(@class,'currency-beforecomma')]")
    protected static java.util.List<WebElement> trainPricesBeforeComma;
    @FindBy(xpath = "//*[@id='results-train']/descendant::*[contains(@class,'currency-decimals')]")
    protected static java.util.List<WebElement> trainPricesAfterCommaWithCurrencySign;


    /// Methods ///
    public ArrayList<Double> priceList = null;

    public void intsTrainPricesAfterComma() {
        java.util.List<Integer> intsTrainPricesBeforeComma = getNumbers(trainPricesBeforeComma);
        java.util.List<Integer> intsTrainPricesAfterComma = getNumbersDecimals(trainPricesAfterCommaWithCurrencySign);
        priceList = mergeLists(intsTrainPricesBeforeComma,intsTrainPricesAfterComma);
    }


    public void validateSorting() {
        for (int i = 0; i<priceList.size()-1;i++){
            if(priceList.get(i)>priceList.get(i+1)) {
                fail("The prices should be sorted by from the cheapest to the most expensive");
            }
        }

    }


}




