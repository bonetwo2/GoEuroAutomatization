package com.goeuro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public abstract class Page {

    @Autowired
    protected WebDriver browser;

    protected String url;

    public void setUrl(String url) {
        this.url = url;
    }

    public void open() {
        String currentURL = browser.getCurrentUrl();

        if (!currentURL.equals(url)) {
            browser.get(url);
        } else {
            browser.get(currentURL);
        }
        verifyPageOpened();

    }

    public void open(String urlPart) {
        String currentURL = browser.getCurrentUrl();

        if (!currentURL.equals(url)) {
            browser.get(url);
        } else {
            browser.get(currentURL);
        }
        verifyPageOpened();

    }


    public void initializeLocators() {
        PageFactory.initElements(browser, this);
    }


    public void verifyPageOpened() {
        initializeLocators();
        String expectedPartURL = url.substring(url.indexOf("//") + 1);

        for (int i = 0; i < 3; i++) {
            if (browser.getCurrentUrl().contains(expectedPartURL)) {
                break;
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        assertThat(browser.getCurrentUrl().contains(expectedPartURL), is(true));
    }

    public void verifyPageOpened(String urlPart) {
        initializeLocators();
        String expectedPartURL = url.substring(url.indexOf("//") + 1);

        for (int i = 0; i < 3; i++) {
            if (browser.getCurrentUrl().contains(expectedPartURL)) {
                break;
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        assertThat(browser.getCurrentUrl().contains(expectedPartURL), is(true));
    }

}
