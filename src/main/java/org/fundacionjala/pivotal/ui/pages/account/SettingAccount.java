package org.fundacionjala.pivotal.ui.pages.account;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.pivotal.ui.pages.AbstractBasePage;
import org.fundacionjala.pivotal.ui.pages.common.CommonActions;

/**
 * This class doing the manage the setting the account.
 */
public class SettingAccount extends AbstractBasePage {
    @FindBy(css = "a.button.current")
    private WebElement settingButton;
    @FindBy(css = "div.description > a")
    private WebElement deleteAccountLink;

    /**
     * This method doing click on "Ok alert Message" button.
     */
    private void clickOKAlertMessage() {
        driver.switchTo().alert().accept();
    }

    /**
     * This method doing click on "Delete Account" link.
     */
    void clickDeleteAccountLink() {
        CommonActions.clickElement(deleteAccountLink);
        clickOKAlertMessage();
    }
}
