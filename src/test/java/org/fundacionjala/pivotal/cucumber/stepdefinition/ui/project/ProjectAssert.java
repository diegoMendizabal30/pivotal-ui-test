package org.fundacionjala.pivotal.cucumber.stepdefinition.ui.project;

import java.util.Map;

import cucumber.api.java.en.Then;

import org.fundacionjala.pivotal.ui.pages.Dashboard;
import org.fundacionjala.pivotal.ui.pages.project.ProjectFormSetting;
import org.fundacionjala.pivotal.ui.pages.project.ProjectManagement;

import static org.fundacionjala.pivotal.ui.pages.project.ProjectFormSetting.PROJECT_NAME;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * This class is manage the project asserts.
 */
public class ProjectAssert {
    private Map<ProjectFormSetting, String> settingMap;
    private String projectId;

    /**
     * Constructor where initialize the values.
     *
     * @param projectStep ResourcesStep.
     */
    public ProjectAssert(final ProjectStep projectStep) {
        settingMap = projectStep.getSettingMap();
    }

    /**
     * this method verify that a new project is created.
     */
    @Then("Verify that a new project is created")
    public void verifyThatANewProjectIsCreated() {
        ProjectManagement projectManagement = new ProjectManagement();
        final String expected = projectManagement.getProjectName();
        final String actual = settingMap.get(PROJECT_NAME);
        projectId = projectManagement.getProjectId();
        assertEquals(expected, actual);
    }

    /**
     * this method verify that a new project is displayed in dashboard.
     */
    @Then("Verify that a new project is displayed in dashboard")
    public void verifyThatANewProjectIsDisplayedInDashboard() {
        Dashboard dashboard = new Dashboard();
        assertTrue(dashboard.existProject(projectId));
    }
}
