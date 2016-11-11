package org.fundacionjala.pivotal.ui.pages.project;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.pivotal.ui.pages.AbstractBasePage;
import org.fundacionjala.pivotal.ui.pages.common.CommonActions;

import static org.fundacionjala.pivotal.ui.pages.project.ProjectFormSetting.ACCOUNT;
import static org.fundacionjala.pivotal.ui.pages.project.ProjectFormSetting.PROJECT_NAME;
import static org.fundacionjala.pivotal.ui.pages.project.ProjectFormSetting.PROJECT_PRIVACY;

/**
 * This class is Project form to PivotalTracker.
 */
public class ProjectForm extends AbstractBasePage {
    @FindBy(className = "tc-project-name__input")
    private WebElement projectNameTextField;
    @FindBy(className = "tc-account-selector")
    private WebElement accountDropDownList;
    @FindBy(className = "tc-account-selector__option-account-name")
    private WebElement accountOptionDropDownList;
    @FindBy(css = "button.tc-create-project-footer__button.tc-create-project-footer__button--submit")
    private WebElement createButton;
    @FindBy(css = "div[data-aid='create-account-button']")
    private WebElement createAccountButtonOptionDropDownList;
    @FindBy(css = "input.tc-account-creator__name")
    private WebElement newAccountProjectTextField;

    /**
     * This method set the projectName in the text field.
     *
     * @param projectName String whit the projectName.
     */
    private void setProjectNameTextField(final String projectName) {
        CommonActions.clearTextField(projectNameTextField);
        CommonActions.sendKeys(projectNameTextField, projectName);
    }

    /**
     * This method set the Account in the text field or DropDownList.
     *
     * @param account That is to search.
     */
    private void setAccountDropDownList(final String account) {
        CommonActions.clickElement(accountDropDownList);
        List<WebElement> menuBodyList = driver.findElements(By.xpath("//div[contains(text(), '" + account + "')]"));
        if (menuBodyList.isEmpty()) {
            CommonActions.clickElement(createAccountButtonOptionDropDownList);
            CommonActions.clearTextField(newAccountProjectTextField);
            CommonActions.sendKeys(newAccountProjectTextField, account);
        } else {

            final int index = 0;
            CommonActions.clickElement(menuBodyList.get(index));
        }
    }

    /**
     * This method click on the new project button.
     *
     * @return {@link ProjectManagement}
     */
    public ProjectManagement clickCreateProjectButton() {
        CommonActions.clickElement(createButton);
        return new ProjectManagement();
    }

    /**
     * This method selected privacy project.
     *
     * @param projectPrivacyType return project privacy type.
     */
    private void selectedProjectPrivacy(final ProjectPrivacy projectPrivacyType) {
        WebElement projectPrivacy =
                driver.findElement(By.cssSelector("input[data-aid='" + projectPrivacyType.toString() + "']"));
        CommonActions.clickElement(projectPrivacy);
    }

    /**
     * Executes the configurations sent.
     *
     * @param configureMap is a map that contains the configurations.
     */
    public void setConfiguration(final Map<ProjectFormSetting, String> configureMap) {
        Map<ProjectFormSetting, ProjectFormStep> strategyOption = strategyConfigureSetting(configureMap);
        Set<ProjectFormSetting> keys = configureMap.keySet();
        for (ProjectFormSetting key : keys) {
            strategyOption.get(key).executeStep();
        }
    }

    /**
     * Create an strategy steps configuration options filling a map with
     * all the existing configurations.
     *
     * @param configureMap is a map that contains all the configurations.
     * @return the configure map with strategies.
     */
    private Map<ProjectFormSetting, ProjectFormStep> strategyConfigureSetting(
            final Map<ProjectFormSetting, String> configureMap) {
        Map<ProjectFormSetting, ProjectFormStep> strategyMap = new HashMap<>();
        strategyMap.put(PROJECT_NAME, () -> setProjectNameTextField(configureMap.get(PROJECT_NAME)));
        strategyMap.put(ACCOUNT, () -> setAccountDropDownList(configureMap.get(ACCOUNT)));
        strategyMap.put(PROJECT_PRIVACY,
                () -> selectedProjectPrivacy(ProjectPrivacy.valueOf(configureMap.get(PROJECT_PRIVACY).toUpperCase())));
        return strategyMap;
    }
}
