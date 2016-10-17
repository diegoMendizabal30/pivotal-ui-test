package org.fundacionjala.pivotaluitest.ui.pages.workspace;

import java.util.HashMap;
import java.util.Map;

import org.fundacionjala.pivotaluitest.ui.pages.AbstractBasePage;
import org.fundacionjala.pivotaluitest.ui.pages.Steps;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class represent setting workspace page.
 */
public class SettingWorkspace extends AbstractBasePage {

    @FindBy(id = "workspace_name")
    private WebElement workspaceNameText;

    @FindBy(id = "delete_link")
    private WebElement deleteWorkspaceLink;

    @FindBy(className = "save_bar__submit")
    private WebElement saveChangesWorkspaceLink;

    @FindBy(className = "message")
    private WebElement messageChangesWorkspace;

    /**
     * This method sets a workspace name.
     *
     * @param workspaceName a string with a name to workspace.
     */
    public void setNameWorkspaceTestField(final String workspaceName) {
        workspaceNameText.clear();
        workspaceNameText.sendKeys(workspaceName);
    }

    /**
     * This method makes a click in delete link a workspace name.
     *
     * @return a object delete workspace.
     */
    public DeleteWorkspace clickDeleteWorkspaceLink() {
        deleteWorkspaceLink.click();
        return new DeleteWorkspace();
    }

    /**
     * this method makes click in save change link.
     */
    public void clickSaveChangesWorkspaceLink() {
        saveChangesWorkspaceLink.click();
    }

    /**
     * This method  gets message changes saved.
     *
     * @return a message.
     */
    public String getMessageChangesWorkspace() {
        return messageChangesWorkspace.getText();
    }

    /**
     * Method that to permit set values to create a new Workspace.
     *
     * @param values a map to set of the strategy
     * @return a Map with the values of the workspace created.
     */
    public Map<WorkspaceSteps, Steps> getStrategyStepMap(final Map<WorkspaceSteps, Object> values) {
        final Map<WorkspaceSteps, Steps> strategyMap = new HashMap<>();
        strategyMap.put(WorkspaceSteps.WORKSPACE_NAME,
                () -> setNameWorkspaceTestField(String.valueOf(values.get(WorkspaceSteps.WORKSPACE_NAME))));
        return strategyMap;
    }

}
