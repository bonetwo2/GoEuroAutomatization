package com.goeuro.steps;

/**
 * Created by aviv on 18/03/16.
 */
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;


public class Step {

    @Autowired
    protected WebDriver browser;

    @PostConstruct
    protected void setup() {
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

}