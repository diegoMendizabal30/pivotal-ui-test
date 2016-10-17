package org.fundacionjala.pivotaluitest.ui.pages.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.fundacionjala.pivotaluitest.ui.browser.DriverManager;
import org.fundacionjala.pivotaluitest.utils.Environment;

/**
 * This class contains all commons methods.
 */
public final class CommonNavigator {

    private static final String DASHBOARD = "dashboard";
    private static final Logger LOGGER = LogManager.getLogger(Environment.class);

    /**
     * Constructor private.
     */
    private CommonNavigator() {
    }

    /**
     * This method got to dashboard page.
     */
    public static void goToDashboard() {
        final String url = String.format("%s/%s", Environment.getInstance().getBaseUrl(), DASHBOARD);
        DriverManager.getInstance().getDriver().navigate().to(url);
        try {
            AlertMessage alertMessage = new AlertMessage();
            alertMessage.clickOKAlertMessage();
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
        }
    }
}
