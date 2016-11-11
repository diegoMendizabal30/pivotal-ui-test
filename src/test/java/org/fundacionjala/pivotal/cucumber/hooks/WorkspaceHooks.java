package org.fundacionjala.pivotal.cucumber.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.restassured.response.Response;
import org.fundacionjala.pivotal.api.RequestManager;
import org.fundacionjala.pivotal.cucumber.stepdefinition.ui.workspace.WorkspaceStepDef;
import org.fundacionjala.pivotal.ui.pages.workspace.Workspace;

import static org.fundacionjala.pivotal.ui.pages.common.CommonMethods.deleteAllProjects;
import static org.fundacionjala.pivotal.ui.pages.common.CommonMethods.deleteAllWorkspaces;

/**
 * This class manage hooks to workspace.
 */
public class WorkspaceHooks {

    private static final String WORKSPACES_ENDPOINT = "/my/workspaces/";

    private WorkspaceStepDef workspaceStepDef;

    /**
     * This is a constructor to initialize the workspace step definitions.
     *
     * @param newWorkspaceStepDef is a workspace step definitions object.
     */
    public WorkspaceHooks(final WorkspaceStepDef newWorkspaceStepDef) {
        this.workspaceStepDef = newWorkspaceStepDef;
    }

    /**
     * This method hook is used after a workspace is created using selenium.
     */
    @After("@DeleteWorkspace")
    public void deleteWorkspace() {
        Workspace workspace = workspaceStepDef.getWorkspace();
        String endPointDeleteWorkspace = WORKSPACES_ENDPOINT.concat(workspace.getIdWorkspace());
        Response response = RequestManager.delete(endPointDeleteWorkspace);
    }

    /**
     * This method is a hook to perform a cleanup environment.
     */
    @Before("@CleanEnvironment")
    public void cleanEnvironment() {
        deleteAllProjects();
        deleteAllWorkspaces();
    }

    /**
     * This method is a hook to return to the Dashboard page.
     */
    @After("@ReturnDashboard")
    public void returnDashboard() {
        workspaceStepDef.getWorkspace().clickReturnDashboardLink();
    }
}
