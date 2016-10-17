package org.fundacionjala.pivotaluitest.cucumber.stepdefinition.ui.project;

import java.util.Map;

import cucumber.api.java.en.When;

import org.fundacionjala.pivotaluitest.api.Mapper;
import org.fundacionjala.pivotaluitest.ui.pages.Dashboard;
import org.fundacionjala.pivotaluitest.ui.pages.account.Account;
import org.fundacionjala.pivotaluitest.ui.pages.account.ManageAccount;
import org.fundacionjala.pivotaluitest.ui.pages.common.CommonNavigator;
import org.fundacionjala.pivotaluitest.ui.pages.menu.TopMenu;
import org.fundacionjala.pivotaluitest.ui.pages.project.ProjectForm;
import org.fundacionjala.pivotaluitest.ui.pages.project.ProjectFormSetting;

/**
 * This class is manage the project step.
 */
public class ProjectStep {
    private Map<ProjectFormSetting, String> settingMap;
    private TopMenu topMenu;

    /**
     * Constructor where initialize the values.
     */
    public ProjectStep() {
        topMenu = new TopMenu();
    }

    /**
     * This method added a new project.
     *
     * @param newSettingMap SettingMap that contains the setting for project.
     */
    @When("^I added a new project$")
    public void iAddedANewProject(final Map<ProjectFormSetting, String> newSettingMap) {
        settingMap = newSettingMap;
        Dashboard dashboardPage = new Dashboard();
        ProjectForm projectForm = dashboardPage.clickCreateProjectButton();
        projectForm.setConfiguration(newSettingMap);
        projectForm.clickCreateProjectButton();
    }

    /**
     * This method deleted all account the project.
     */
    @When("^I delete all account the project$")
    public void deleteAllAccountForProject() {
        topMenu.clickUserNameDropDown();
        Account account = topMenu.clickAccountDropDownItem();
        account.deleteAllAccounts(account.getManageAccountButtonList());
        CommonNavigator.goToDashboard();
    }

    /**
     * This method created a new account.
     *
     * @param accountName String  whit the account name.
     */
    @When("^I create a new account (.*)$")
    public void createANewAccount(final String accountName) {
        topMenu.clickUserNameDropDown();
        Account account = topMenu.clickAccountDropDownItem();
        ManageAccount manageAccount = account.createAccount(accountName);
        manageAccount.waitPage();
        CommonNavigator.goToDashboard();
    }

    /**
     * this methos update the task.
     *
     * @param projectCreated String the old task.
     * @param textForUpdate  String whit the new task.
     */
    @When("^I update the project (.*) for: (.*)$")
    public void updateTheProject(final String projectCreated, final String textForUpdate) {
        String oldTaskText = Mapper.mapEndpoint(projectCreated);
    }

    /**
     * This method obtain settingMap.
     *
     * @return SettingMap to Map type.
     */
    Map<ProjectFormSetting, String> getSettingMap() {
        return settingMap;
    }
}
