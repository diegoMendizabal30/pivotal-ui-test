package org.fundacionjala.pivotal.cucumber.hooks;

import cucumber.api.java.After;
import org.fundacionjala.pivotal.ui.pages.common.CommonNavigator;

/**
 * Hook for DashBoard.
 */
public class GoToDashBoardHook {
    /**
     * This hook take us to the dashboard.
     */
    @After("@toDashBoard")
    public void loginToPivotal() {
        CommonNavigator.goToDashboard();
    }
}
