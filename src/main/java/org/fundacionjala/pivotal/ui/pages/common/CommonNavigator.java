package org.fundacionjala.pivotal.ui.pages.common;

import org.fundacionjala.pivotal.ui.browser.DriverManager;
import org.fundacionjala.pivotal.utils.Environment;

/**
 * This class contains all commons methods.
 */
public final class CommonNavigator {

    private static final String DASHBOARD = "dashboard";

    /**
     * Constructor private.
     */
    private CommonNavigator() {
    }

    /**
     * This method go to dashboard page.
     */
    public static void goToDashboard() {
        final String url = String.format("%s/%s", Environment.getInstance().getBaseUrl(), DASHBOARD);
        DriverManager.getInstance().getDriver().navigate().to(url);
    }
}
