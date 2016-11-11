package org.fundacionjala.pivotal.ui.pages.account;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.pivotal.ui.pages.AbstractBasePage;
import org.fundacionjala.pivotal.ui.pages.common.CommonActions;

/**
 * This is the Account page class.
 */
public class Account extends AbstractBasePage {

    private static final String MANAGE_ACCOUNT = "MANAGE ACCOUNT";

    @FindBy(id = "new_account_link")
    private WebElement createAccountButton;


    @FindBy(id = "add_account_button")
    private WebElement addAccountButton;

    @FindBy(id = "account_name")
    private WebElement accountNameTextField;

    @FindBy(className = "header_button")
    private List<WebElement> manageAccountButtonList;

    /**
     * This method set the account name in the text field.
     *
     * @param accountName String  whit the account name.
     */
    private void setAccountNameTextField(final String accountName) {
        CommonActions.clearTextField(accountNameTextField);
        CommonActions.sendKeys(accountNameTextField, accountName);
    }

    /**
     * This method do click on "Manage Account" button.
     *
     * @param manageAccountButton WebElement that represent a "Management Account".
     * @return ManageAccount page.
     */
    private ManageAccount clickManageAccount(final WebElement manageAccountButton) {
        CommonActions.clickElement(manageAccountButton);
        return new ManageAccount();
    }

    /**
     * This method doing click on "Create Account" button.
     */
    private void clickCreateAccountButton() {
        CommonActions.clickElement(createAccountButton);
    }

    /**
     * This method added a new account.
     *
     * @return ManageAccount page.
     */
    private ManageAccount clickAddAccountButton() {
        CommonActions.clickElement(addAccountButton);
        return new ManageAccount();
    }

    /**
     * This method created a new account.
     *
     * @param accountName String  whit the account name.
     * @return ManageAccount page.
     */
    public ManageAccount createAccount(final String accountName) {
        clickCreateAccountButton();
        setAccountNameTextField(accountName);
        return clickAddAccountButton();
    }

    /**
     * This method deleted all accounts.
     *
     * @param accountList List the elements to deleted.
     * @return Return true if deleted all projects.
     */
    public boolean deleteAllAccounts(final List<WebElement> accountList) {
        if (!accountList.isEmpty()) {
            int index = 1;
            WebElement webElement = accountList.get(index);
            String text = webElement.getText();
            if (text.equals(MANAGE_ACCOUNT)) {
                deleteAccount(webElement);
            }
            return deleteAllAccounts(getManageAccountButtonList());
        }
        return true;
    }

    /**
     * This method deleted account.
     *
     * @param webElement WebElement for delete account.
     */
    private void deleteAccount(final WebElement webElement) {
        String attributeValue = webElement.getAttribute("href");
        attributeValue = attributeValue.replace("plans", "settings");
        int indexOf = attributeValue.indexOf("/accounts");
        attributeValue = attributeValue.substring(indexOf);
        ManageAccount manageAccount = clickManageAccount(webElement);
        SettingAccount settingAccount = manageAccount.clickSetting(attributeValue);
        settingAccount.clickDeleteAccountLink();
    }

    /**
     * This method obtains a of WebElement list.
     *
     * @return List the WebElement the button type.
     */
    public List<WebElement> getManageAccountButtonList() {
        return manageAccountButtonList;
    }

}
