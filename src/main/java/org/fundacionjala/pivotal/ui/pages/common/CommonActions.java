package org.fundacionjala.pivotal.ui.pages.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.fundacionjala.pivotal.ui.browser.DriverManager;
import org.fundacionjala.pivotal.utils.Environment;

/**
 * This is class wait to load the element.
 */
public final class CommonActions {

    /**
     * Constructor private.
     */
    private CommonActions() {
    }

    /**
     * This method waits the element.
     *
     * @param webElement Element to wait.
     */
    @Deprecated
    public static void waitUntil(final WebElement webElement) {
        final WebDriver driver = DriverManager.getInstance().getDriver();
        final WebDriverWait wait = new WebDriverWait(driver, Environment.getInstance().getTimeout());
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    /**
     * This method waits and clear the element.
     *
     * @param webElement Element to wait and clear.
     */
    public static void clearTextField(final WebElement webElement) {
        DriverManager.getInstance().getWait().until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
    }

    /**
     * This method waits and fill the element.
     *
     * @param webElement Element to wait and fill.
     * @param text       text to fill.
     */
    public static void sendKeys(final WebElement webElement, final String text) {
        DriverManager.getInstance().getWait().until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
        webElement.sendKeys(text);
    }

    /**
     * This method waits and clickElement the element.
     *
     * @param webElement Element to wait and clickElement.
     */
    public static void clickElement(final WebElement webElement) {
        DriverManager.getInstance().getWait().until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    /**
     * This method waits and clickElement the element.
     *
     * @param webElement Element to wait and clickElement.
     * @return text to element.
     */
    public static String getText(final WebElement webElement) {
        DriverManager.getInstance().getWait().until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getText();
    }
}
