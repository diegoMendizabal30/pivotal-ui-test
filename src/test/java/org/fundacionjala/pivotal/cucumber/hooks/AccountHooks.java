package org.fundacionjala.pivotal.cucumber.hooks;

import cucumber.api.java.Before;

import org.fundacionjala.pivotal.ui.pages.account.Account;
import org.fundacionjala.pivotal.ui.pages.common.CommonNavigator;
import org.fundacionjala.pivotal.ui.pages.menu.TopMenu;

/**
 * Created by Administrator on 10/14/2016.
 */
public class AccountHooks {
    /**
     * Method to delete all projects that meets with the condition.
     */
    @Before("@deleteAllAccounts")
    public final void deleteAllAccounts() {
        TopMenu topMenu = new TopMenu();
        topMenu.clickUserNameDropDown();
        Account account = topMenu.clickAccountDropDownItem();
        account.deleteAllAccounts(account.getManageAccountButtonList());
        CommonNavigator.goToDashboard();
    }
}
