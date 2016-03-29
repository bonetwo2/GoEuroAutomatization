package com.goeuro.pages;

import com.goeuro.Bindings;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by aviv on 18/03/16.
 */

@Component
public class HomePage extends Bindings {

    @Override
    @Value("${url.homepage}")
    public void setUrl(String url) {
        this.url = url;
    }

/// Selectors ///

    @FindBy(xpath = "//input[@id='from_filter']")
    protected static WebElement originBox;

    @FindBy(xpath = "//input[@id='to_filter']")
    protected static WebElement destinationBox;

    @FindBy(xpath = "//input[@id='search-form__submit-btn']")
    protected static WebElement searchBtn;

/// Methods ///

    public void fillInFieldsAndSearch(String origin, String destination) {
        type(originBox,origin);
        originBox.sendKeys(Keys.ENTER);
        type(destinationBox,destination);
        destinationBox.sendKeys(Keys.ENTER);
        Actions action = new Actions(browser);
        action.doubleClick(searchBtn).perform();
    }
}
