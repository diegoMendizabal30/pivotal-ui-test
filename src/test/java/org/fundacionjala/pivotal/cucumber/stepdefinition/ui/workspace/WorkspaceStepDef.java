package org.fundacionjala.pivotal.cucumber.stepdefinition.ui.workspace;

import java.util.List;
import java.util.Map;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.fundacionjala.pivotal.api.Mapper;
import org.fundacionjala.pivotal.ui.pages.Dashboard;
import org.fundacionjala.pivotal.ui.pages.workspace.CreateWorkspace;
import org.fundacionjala.pivotal.ui.pages.workspace.DeleteWorkspace;
import org.fundacionjala.pivotal.ui.pages.workspace.SettingWorkspace;
import org.fundacionjala.pivotal.ui.pages.workspace.SideBarWorkspace;
import org.fundacionjala.pivotal.ui.pages.workspace.Workspace;
import org.fundacionjala.pivotal.ui.pages.workspace.WorkspaceSteps;

/**
 * This class handler the step definitions of workspace.
 */
public class WorkspaceStepDef {

    private CreateWorkspace createWorkspace;

    private Workspace workspace;

    private Dashboard dashboard;

    private SideBarWorkspace sideBarWorkspace;

    private SettingWorkspace settingWorkspace;

    private DeleteWorkspace deleteWorkspace;

    private Map<WorkspaceSteps, Object> valuesMapCreateEdit;

    /**
     * This is step definitions to create workspace.
     *
     * @param mapCreate is a map with values to create workspace
     */

    @Given("^I create a new Workspace$")
    public void iCreateANewWorkspace(final Map<WorkspaceSteps, Object> mapCreate) {
        new Dashboard().refreshPage();
        this.valuesMapCreateEdit = mapCreate;
        createWorkspace = new Dashboard().clickCreateWorkspaceLink();
        valuesMapCreateEdit.keySet()
                .forEach(step -> createWorkspace.getStrategyStepMap(valuesMapCreateEdit).get(step).executeStep());

        workspace = createWorkspace.clickCreateWorkspaceLink();
        sideBarWorkspace = workspace.getSideWorkspace();
    }

    /**
     * This is step definitions to add a project.
     */
    @When("^I click on Add Projects button$")
    public void iClickOnAddProjectsButton() {
        new SideBarWorkspace().clickAddProjectButton();
    }

    /**
     * This is step definitions to add a list projects.
     *
     * @param projects is a list of projects.
     */
    @And("^I add the$")
    public void iAddTheProject(final List<String> projects) {
        SideBarWorkspace sideBarWorkspaces = new SideBarWorkspace();
        projects.forEach(name -> {
            sideBarWorkspaces.clickListProjectLink();
            sideBarWorkspaces.clickProjectNameLink(Mapper.mapEndpoint(name));
        });
        sideBarWorkspaces.clickSaveWorkspaceLink();
    }

    /**
     * This a step definitions to save a workspace.
     */
    @And("^I click on Save Workspace button$")
    public void iClickOnSaveWorkspaceButton() {
        new SideBarWorkspace().clickSaveWorkspaceLink();
    }

    /**
     * This is a step definitions to go to a workspace.
     *
     * @param nameWorkspace is a string with the name workspace.
     */
    @Given("^I go to the (.*)$")
    public void iGoToTheWorkspace(final String nameWorkspace) {
        Dashboard newDashboard = new Dashboard();
        newDashboard.refreshPage();
        String finalNameWorkspace = Mapper.mapEndpoint(nameWorkspace);
        workspace = newDashboard.clickNameWorkspaceLink(finalNameWorkspace);
        new SideBarWorkspace().clickAddProjectButton();
    }

    /**
     * This is a method to go a settings tab.
     */
    @When("^I click in the settings tab$")
    public void iGoToTheSettingsTab() {
        settingWorkspace = workspace.getToolBarWorkspace().clickSettingsWorkspaceTab();
    }

    /**
     * This is a method to make a click in delete confirm.
     */
    @And("^I click on Delete link and confirm$")
    public void iClickOnDeleteLink() {
        deleteWorkspace = settingWorkspace.clickDeleteWorkspaceLink();
        dashboard = deleteWorkspace.clickConfirmDeleteLink();
    }

    /**
     * This a method ti edit name of a workspace.
     *
     * @param mapEdit is a map with the name of a workspace.
     */
    @And("^I edit the name with$")
    public void iEditTheNameWith(final Map<WorkspaceSteps, Object> mapEdit) {
        valuesMapCreateEdit = mapEdit;
        valuesMapCreateEdit.keySet()
                .forEach(step -> settingWorkspace.getStrategyStepMap(valuesMapCreateEdit).get(step).executeStep());
        settingWorkspace.clickSaveChangesWorkspaceLink();
    }

    /**
     * This method gets a workspace.
     *
     * @return a object workspace page.
     */
    public Workspace getWorkspace() {
        return workspace;
    }

    /**
     * This method gets value of a map.
     *
     * @return a map with values.
     */
    Map<WorkspaceSteps, Object> getValuesMapCreateEdit() {
        return valuesMapCreateEdit;
    }

}
