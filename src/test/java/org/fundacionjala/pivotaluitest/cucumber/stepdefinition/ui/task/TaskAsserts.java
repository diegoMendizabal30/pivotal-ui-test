package org.fundacionjala.pivotaluitest.cucumber.stepdefinition.ui.task;

import cucumber.api.java.en.Then;
import org.fundacionjala.pivotaluitest.api.Mapper;
import org.fundacionjala.pivotaluitest.ui.pages.StoryDashBoard;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Asserts For Task.
 */
public class TaskAsserts {
    /**
     * Method for verify if the task exist.
     *
     * @param taskTextCreated String whit the task.
     */

    @Then("^The task: (.*) is created$")
    public void theTaskThisIsATaskTestIsCreated(final String taskTextCreated) {
        StoryDashBoard projectDashboard = new StoryDashBoard();
        assertTrue(projectDashboard.taskTextExist(taskTextCreated));
    }

    /**
     * This method delete the task.
     * @param taskCreated String whit the task that will be deleted.
     */
    @Then("^The task: (.*) is deleted$")
    public void theTaskTasksDescriptionIsDeleted(final String taskCreated) {
        String taskRequested = Mapper.mapEndpoint(taskCreated);
        StoryDashBoard storyDashBoard = new StoryDashBoard();
        assertFalse(storyDashBoard.taskTextExist(taskRequested));
    }
}
