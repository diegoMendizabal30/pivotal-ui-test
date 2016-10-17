package org.fundacionjala.pivotaluitest.ui.pages.common;

import org.fundacionjala.pivotaluitest.ui.browser.DriverManager;

/**
 * this class manage the alert messages.
 */
public class AlertMessage {
    /**
     * this method click on the ok button of the alert.
     */
    public void clickOKAlertMessage() {
        DriverManager.getInstance().getDriver().switchTo().alert().accept();
    }
}
