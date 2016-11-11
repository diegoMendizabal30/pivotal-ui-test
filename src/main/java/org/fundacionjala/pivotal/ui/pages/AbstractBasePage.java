package org.fundacionjala.pivotal.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.fundacionjala.pivotal.ui.browser.DriverManager;

/**
 * This base page abstract class.
 */
public abstract class AbstractBasePage {

    protected WebDriver driver;

    protected WebDriverWait wait;

    /**
     * This builds initialize the AbstractBasePage.
     */
    public AbstractBasePage() {
        driver = DriverManager.getInstance().getDriver();
        wait = DriverManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

}
