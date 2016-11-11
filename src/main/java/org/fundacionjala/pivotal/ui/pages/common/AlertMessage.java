package org.fundacionjala.pivotal.ui.pages.common;

import org.fundacionjala.pivotal.ui.browser.DriverManager;

/**
 * this class manage the alert messages.
 */
public class AlertMessage {
    /**
     * this method click on the ok button of the alert.
     */
    void clickOKAlertMessage() {
        DriverManager.getInstance().getDriver().switchTo().alert().accept();
    }
}
