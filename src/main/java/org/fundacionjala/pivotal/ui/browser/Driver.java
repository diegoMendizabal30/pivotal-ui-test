package org.fundacionjala.pivotal.ui.browser;

import org.openqa.selenium.WebDriver;

/**
 * This interface define the methods related to initialize the Selenium driver.
 */
public interface Driver {

    /**
     * Initialize the Selenium web driver.
     *
     * @return {@link WebDriver}.
     */
    WebDriver initDriver();
}
