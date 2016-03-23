package com.goeuro;

import com.goeuro.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.*;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by aviv on 21/03/16.
 */
public class Bindings extends Page {

    public WebElement type(WebElement we, String text) {
        try {
            we.clear();
            we.sendKeys(text);
        } catch (Exception e) {
            e.getMessage();
        }
        return we;
    }

    protected WebElement waitForElement(WebElement we, int timeout) {
        try {
            new WebDriverWait(browser, timeout).until(
                    ExpectedConditions.visibilityOf(we)
            );
        } catch (Exception e) {
            e.getMessage();
        }
        return we;
    }

    /**
     * Wait for element to appear and be in editable state
     *
     * @param we      locator of element to wait for
     * @param timeOut time to wait for element
     * @param visible element expected to be visible/present. true=present; false=visible
     * @return webElement object on success
     */
    protected WebElement waitForClickable(WebElement we, int timeOut, boolean visible) {
        try {
            WebDriverWait wait = new WebDriverWait(browser, timeOut);
            if (visible) {
                wait.until(
                        ExpectedConditions.elementToBeClickable(we));
            } else {
                wait.until(
                        ExpectedConditions.elementToBeClickable(we));
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return we;
    }

    /**
     * Wait for element to appear and be in editable state.
     *
     * @param we locator of element to wait for
     * @return webElement object on success
     */
    protected WebElement waitForClickable(WebElement we) {
        return waitForClickable(we, 3, true);
    }

    /**
     * Wait for element to appear and be in editable state.
     *
     * @param we      locator of element to wait for
     * @param timeOut time to wait for element
     * @return returns webElement object on success
     */
    protected WebElement waitForClickable(WebElement we, int timeOut) {
        return waitForClickable(we, timeOut, true);
    }

    /**
     * Wait for element to disappear and be in not editable state.
     *
     * @param we locator of element to wait for
     * @return returns webElement object on success
     */
    protected WebElement waitForNotClickable(WebElement we) {
        return waitForClickable(we, 3, false);
    }

    /**
     * Wait for element to disappear and be in not editable state.
     *
     * @param we      locator of element to wait for
     * @param timeout time to wait for element
     * @return returns webElement object on success
     */
    protected WebElement waitForNotClickable(WebElement we, int timeout) {
        return waitForClickable(we, timeout, false);
    }

    /**
     * Wait for element to appear.
     *
     * @param we locator of element to wait for
     * @return web element object on success
     */
    protected WebElement waitForElement(WebElement we) {
        return waitForElement(we, 5);
    }

    /**
     * Wait for a few elements to appear.
     *
     * @param webElements      locator of elements to wait for
     * @param timeOut time to wait for
     * @return web element object on success
     */
    protected List<WebElement> waitForElements(List<WebElement> webElements, int timeOut) {
        try {
            new WebDriverWait(browser, timeOut).until(
                    ExpectedConditions.visibilityOfAllElements(webElements)
            );
        } catch (Exception e) {
            e.getMessage();
        }
        return webElements;
    }


    /**
     * Wait for element to disappear.
     *
     * @param we locator of element to wait for
     * @return web element object on success
     */
    protected WebElement waitForElementNotDisplayed(WebElement we) {
        try {
            new WebDriverWait(browser, 10).until(
                    ExpectedConditions.not(ExpectedConditions.visibilityOf(we))
            );
        } catch (Exception e) {
            e.getMessage();
        }
        return we;
    }

    /**
     * Wait for element to not present in dom
     *
     * @param xpath xpath of element to wait for
     * @return xpath of element on success
     */
    protected String waitForElementNotPresent(String xpath) {
        try {
            new WebDriverWait(browser, 9).until(
                    ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)))
            );
        } catch (Exception e) {
            e.getMessage();
        }
        return xpath;
    }

    /**
     * Verifies if element present in dom
     *
     * @param locatorKey locator of element to verify
     * @return true if element not found in dom
     */
    public boolean isElementPresent(By locatorKey) {
        try {
            browser.findElement(locatorKey);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Wait for text for specified element.
     *
     * @param we   locator of element to wait for
     * @param text text of element to wait for
     * @return web element object on success
     */
    protected WebElement verifyTextPresented(WebElement we, String text) {
        try {
            WebDriverWait wait = new WebDriverWait(browser, 5);
            boolean condition = wait.until(
                    ExpectedConditions.textToBePresentInElement(we, text));
            assertThat(condition, is(true));

        } catch (Exception e) {
            e.getMessage();
        }
        return we;
    }

    /**
     * Returns text of all elements.
     *
     * @param webElements list of web elements with text
     * @return list with text of all web elements
     */
    protected List<String> getTexts(final List<WebElement> webElements) {
        try {
            ArrayList<String> texts = new ArrayList<>();
            webElements.forEach(e -> texts.add(e.getText()));
            return texts;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    /**
     * Wait for element to appear and be in editable state and then click on the element.
     *
     * @param we locator of element to wait for
     * @return web element object on success
     */
    protected WebElement waitForClickableAndClick(WebElement we) {
        waitForClickable(we);
        we.click();
        return we;
    }

    /**
     * Wait for element to appear and be in editable state and then click on the element.
     *
     * @param we locator of element to wait for
     * @return web element object on success
     */
    protected WebElement waitForClickableAndClick(WebElement we, int timeOut) {
        waitForClickable(we,timeOut);
        we.click();

        return we;
    }

    protected String getRandomNumberAsString(int min, int max) {
        int randomValue = new Random().nextInt(max - min) + min;
        return Integer.toString(randomValue);
    }

    protected String getCurrentDate() {
        Date currentDate = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.GERMANY);

        return sdf.format(currentDate);
    }


}
