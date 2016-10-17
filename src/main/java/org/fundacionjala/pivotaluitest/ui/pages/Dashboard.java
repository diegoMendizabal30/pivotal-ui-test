package org.fundacionjala.pivotaluitest.ui.pages;

import java.util.List;

import org.fundacionjala.pivotaluitest.ui.pages.common.CommonActions;
import org.fundacionjala.pivotaluitest.ui.pages.project.ProjectForm;
import org.fundacionjala.pivotaluitest.ui.pages.workspace.CreateWorkspace;
import org.fundacionjala.pivotaluitest.ui.pages.workspace.Workspace;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Dashboard page the PivotalTracker.
 */
public class Dashboard extends AbstractBasePage {
    @FindBy(id = "create_new_project_button")
    private WebElement createProjectButton;

    @FindBy(id = "my_projects_list")
    private WebElement projectsList;

    @FindBy(id = "create_new_workspace_button")
    private WebElement createWorkspaceLink;

    @FindBy(css = "li[id=\"notice\"]")
    private WebElement messageDeleteWorkspace;

    /**
     * This method a clickElement "Create Project" button.
     *
     * @return ProjectForm page.
     */
    public ProjectForm clickCreateProjectButton() {
        CommonActions.clickElement(createProjectButton);
        return new ProjectForm();
    }

    /**
     * This method verify if project exist in the dashboard.
     *
     * @param projectId ProjectId to search.
     * @return Return true if exist the project.
     */
    public Boolean existProject(final String projectId) {
        List<WebElement> projectList = driver.findElements(By.id(String.format("project_%s", projectId)));
        return !projectList.isEmpty();
    }

    /**
     * This method serch a project.
     *
     * @param projectName String Project name.
     * @return StoryDashboard object.
     */
    public StoryDashBoard projectsList(final String projectName) {
        List<WebElement> projects = projectsList.findElements(By.className("project_title"));
        for (WebElement project : projects) {
            if (projectName.equals(project.getText())) {
                CommonActions.clickElement(project);
            }
        }
        return new StoryDashBoard();
    }

    /**
     * This method make click in create workspace link.
     *
     * @return a object create workspace page.
     */
    public CreateWorkspace clickCreateWorkspaceLink() {
        createWorkspaceLink.click();
        return new CreateWorkspace();
    }

    /**
     * This method make click in mame workspace link.
     *
     * @param nameWorkspace is a string with name of workspace
     * @return a object workspace page.
     */
    public Workspace clickNameWorkspaceLink(final String nameWorkspace) {
        driver.findElement(By.xpath("//a[contains(.,'" + nameWorkspace + "')]")).click();
        return new Workspace();
    }

    /**
     * This method verifies if workspace name exist.
     *
     * @param nameWorkspace is a string with a name workspace.
     * @return a boolean.
     */
    public boolean getNameWorkspaceLink(final String nameWorkspace) {
        return driver.findElements(By.className("workspace_title")).stream()
                .anyMatch(element -> element.getText().equals(nameWorkspace));
    }

    /**
     * This method contain a message error.
     *
     * @return a message of workspace when is delete
     */
    public String getMessageDeleteWorkspace() {
        return messageDeleteWorkspace.getText();
    }

    /**
     * This method make a refresh.
     */
    public void refreshPage() {
        driver.navigate().refresh();
    }
}
