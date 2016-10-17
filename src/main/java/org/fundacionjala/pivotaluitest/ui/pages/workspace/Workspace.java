package org.fundacionjala.pivotaluitest.ui.pages.workspace;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacionjala.pivotaluitest.ui.pages.AbstractBasePage;
import org.fundacionjala.pivotaluitest.ui.pages.Dashboard;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.By.cssSelector;


/**
 * This class represent the workspace page.
 */
public class Workspace extends AbstractBasePage {

    private static final Logger LOGGER = LogManager.getLogger(Workspace.class.getSimpleName());

    private SideBarWorkspace sideBarWorkspace;

    private ToolBarWorkspace toolBarWorkspace;

    @FindBy(className = "raw_context_name")
    private WebElement workspaceNameText;

    @FindBy(css = ".tc_header_item.tc_header_logo")
    private WebElement returnDashboardLink;

    @FindBy(xpath = "//div[contains(@class, 'tn-PanelHeader__heading')]")
    private WebElement projectIntoWorkspaceNameText;


    @FindBy(className = "tn-PanelHeader__heading___3FPBiGiZ")
    private WebElement projectsIntoWorkspaceNameText;


    @FindBy(className = "table")
    private WebElement panelContainerProjects;


    /**
     * This constructor contain side bar and tool bar pages.
     */
    public Workspace() {
        sideBarWorkspace = new SideBarWorkspace();
        toolBarWorkspace = new ToolBarWorkspace();
    }

    /**
     * This method represent a click to return to dashboard.
     *
     * @return a object dashboard page.
     */
    public Dashboard clickReturnDashboardLink() {
        returnDashboardLink.click();
        return new Dashboard();
    }

    /**
     * This method gets the workspace name text.
     *
     * @return a string with workspace name text.
     */
    public String getProjectIntoWorkspaceNameText() {
        wait.until(ExpectedConditions.visibilityOf(panelContainerProjects));
        return projectIntoWorkspaceNameText.getText();
    }

    /**
     * This method gets the workspace name text.
     *
     * @param nameProject a string with name project
     * @return a string with workspace name text.
     */

    public boolean projectsIntoWorkspace(final String nameProject) {
        wait.until(ExpectedConditions.visibilityOf(panelContainerProjects));
        return driver.findElements(cssSelector("span[class=\"full\"]")).stream()
                .anyMatch(element -> element.getText().equals(nameProject.toUpperCase()));
    }


    /**
     * This method parsers a id of a URL.
     *
     * @return the id workspace.
     */
    public String getIdWorkspace() {
        String url = driver.getCurrentUrl();
        String idWorkspace = "";
        Pattern pattern = Pattern.compile("[\\D]");
        Matcher m = pattern.matcher(url);
        if (m.find()) {
            idWorkspace = m.replaceAll("");
        }
        return idWorkspace;
    }

    /**
     * This method is the strategy to the field of a workspace create.
     *
     * @return a map strategy.
     */
    public Map<WorkspaceSteps, Object> mapStrategyWorkspaceFieldsCreate() {
        Map<WorkspaceSteps, Object> strategyMapWorkspaceFieldsCreate = new HashMap<>();
        strategyMapWorkspaceFieldsCreate.put(WorkspaceSteps.WORKSPACE_NAME, toolBarWorkspace.getWorkspaceNameText());
        return strategyMapWorkspaceFieldsCreate;
    }

    /**
     * This method return the side bar of the workspace.
     *
     * @return a object page.
     */
    public SideBarWorkspace getSideWorkspace() {
        return sideBarWorkspace;
    }

    /**
     * This method return the tool bar of the workspace.
     *
     * @return a object page.
     */
    public ToolBarWorkspace getToolBarWorkspace() {
        return toolBarWorkspace;
    }
}
