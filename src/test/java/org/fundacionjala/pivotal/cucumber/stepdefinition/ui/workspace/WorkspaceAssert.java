package org.fundacionjala.pivotal.cucumber.stepdefinition.ui.workspace;

import java.util.List;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.fundacionjala.pivotal.api.Mapper;
import org.fundacionjala.pivotal.ui.pages.Dashboard;
import org.fundacionjala.pivotal.ui.pages.workspace.CreateWorkspace;
import org.fundacionjala.pivotal.ui.pages.workspace.SettingWorkspace;
import org.fundacionjala.pivotal.ui.pages.workspace.ToolBarWorkspace;
import org.fundacionjala.pivotal.ui.pages.workspace.Workspace;
import org.fundacionjala.pivotal.ui.pages.workspace.WorkspaceSteps;

import static junit.framework.TestCase.assertFalse;
import static org.fundacionjala.pivotal.utils.Constants.SAVED_MESSAGE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * This class is to assertion to workspace.
 */

public class WorkspaceAssert {

    private WorkspaceStepDef workspaceStepDef;

    /**
     * This is a constructor  to workspace assert.
     *
     * @param newWorkspaceStepDef a object with steps definitions of workspace.
     */
    public WorkspaceAssert(final WorkspaceStepDef newWorkspaceStepDef) {
        this.workspaceStepDef = newWorkspaceStepDef;
    }

    /**
     * This is an assert that compare the created name .
     */
    @And("^the display name equals to workspace created$")
    public void theDisplayNameEqualsTo() {
        workspaceStepDef.getValuesMapCreateEdit().keySet().forEach(step
                -> assertEquals(String.valueOf(new Workspace().mapStrategyWorkspaceFieldsCreate().get(step)),
                workspaceStepDef.getValuesMapCreateEdit().get(step)));


        workspaceStepDef.getWorkspace().clickReturnDashboardLink();
        assertTrue(new Dashboard().getNameWorkspaceLink((String) workspaceStepDef
                .getValuesMapCreateEdit().get(WorkspaceSteps.WORKSPACE_NAME)));
    }

    /**
     * This is an assert that verify the displayed message.
     *
     * @param message is a string with a message.
     */
    @Then("^A message should be displayed: (.*)$")
    public void aMessageDisplayedWorkspaceNameCanTBeBlank(final String message) {
        CreateWorkspace createWorkspace = new CreateWorkspace();
        assertEquals(message, createWorkspace.messageError());
        createWorkspace.clickCancelCreateWorkspaceLink();
    }

    /**
     * This is an assert that compare the created name .
     *
     * @param nameProject is a string with project name.
     */
    @Then("^I expect the workspace store (.*)$")
    public void iExpectAWorkspaceWithTheProjectSelected(final String nameProject) {
        assertEquals(Mapper.mapEndpoint(nameProject).toUpperCase(), new Workspace().getProjectIntoWorkspaceNameText());
        workspaceStepDef.getWorkspace().clickReturnDashboardLink();
    }


    /**
     * This is an assert that compare the created name.
     *
     * @param nameProjects is a list with the project names.
     */
    @Then("^I expect the workspace store$")
    public void iExpectAWorkspaceWithTheProjectSelected(final List<String> nameProjects) {
        nameProjects
                .forEach(name -> assertTrue(new Workspace().projectsIntoWorkspace(Mapper.mapEndpoint(name))));
        workspaceStepDef.getWorkspace().clickReturnDashboardLink();
    }

    /**
     * This is an assert that compare a message.
     *
     * @param nameWorkspace a string with a message
     */
    @Then("^I expect the next message: (.*)$")
    public void iExpectTheNextMessageWorkspaceWasSuccessfullyDeleted(final String nameWorkspace) {

        if (SAVED_MESSAGE.equalsIgnoreCase(nameWorkspace)) {
            assertEquals(nameWorkspace, new SettingWorkspace().getMessageChangesWorkspace());

            new ToolBarWorkspace().clickStoriesWorkspaceTab();

            workspaceStepDef.getValuesMapCreateEdit().keySet().forEach(step
                    -> assertEquals(String.valueOf(new Workspace().mapStrategyWorkspaceFieldsCreate().get(step)),
                    workspaceStepDef.getValuesMapCreateEdit().get(step)));

            new Workspace().clickReturnDashboardLink();
            assertTrue(new Dashboard().getNameWorkspaceLink((String) workspaceStepDef
                    .getValuesMapCreateEdit().get(WorkspaceSteps.WORKSPACE_NAME)));
        } else {
            assertEquals(Mapper.mapEndpoint(nameWorkspace), new Dashboard().getMessageDeleteWorkspace());
            new Workspace().clickReturnDashboardLink();
            assertFalse(new Dashboard().getNameWorkspaceLink((Mapper.mapEndpoint(nameWorkspace))));
        }
    }
}
