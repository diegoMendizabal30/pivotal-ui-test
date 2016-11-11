package org.fundacionjala.pivotal.ui.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * This class initialize the Chrome Selenium Web Driver.
 */
public class Firefox implements Driver {

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver initDriver() {
        return new FirefoxDriver();
    }
}
