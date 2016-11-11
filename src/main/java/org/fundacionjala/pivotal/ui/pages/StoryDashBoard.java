package org.fundacionjala.pivotal.ui.pages;

import java.util.List;

import org.fundacionjala.pivotal.api.Mapper;
import org.fundacionjala.pivotal.ui.pages.common.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class have the actions on the Story Board.
 */
public class StoryDashBoard extends AbstractBasePage {


    private static final String TASK_TEXT_AREA = "//textarea[@class='editor tracker_markup std']";
    private static final String EDIT_BUTTON = "a[class=\"autosaves undraggable edit\"]";
    private static final String SAVE_BUTTON = "button[class=\"autosaves std save\"]";
    private static final String DELETE_BUTTON = "a[class=\"autosaves undraggable delete\"]";
    public static final String ALL_DELETE_BUTTONS = "//li[contains(@class,'task draggable droppable task')]";
    @FindBy(name = "task[description]")
    private WebElement taskTextField;

    @FindBy(css = "button.autosaves.std.add")
    private WebElement addButton;

    @FindBy(css = "section[class=\"tasks full\"]")
    private WebElement taskList;

    @FindBy(css = "a[class=\"autosaves undraggable edit\"]")
    private WebElement editButton;

    @FindBy(css = " div[class=\"tasks_index\"]")
    private WebElement taskIndex;


    /**
     * Deploys the story board.
     *
     * @param storyName String name of the Story.
     */
    public void clickForStoryDeploy(final String storyName) {
        CommonActions.clickElement(driver.findElement(
                By.cssSelector("header[class=\"preview\"] >a[title=" + storyName + "] "
                + "+ [class=\"expander undraggable")));
    }

    /**
     * Set the text for the task.
     *
     * @param taskText String description of the task.
     */
    public void setTaskText(final String taskText) {
        CommonActions.sendKeys(taskTextField, taskText);
        CommonActions.clickElement(addButton);
    }

    /**
     * Verifies If the Task exist.
     *
     * @param taskText String of the task.
     * @return boolean  element exist
     */
    public boolean taskTextExist(final String taskText) {
        List<WebElement> taskCreated = taskList.findElements(By.cssSelector("div.description.tracker_markup"));
        return taskCreated.stream().anyMatch(x -> x.getText().equals(taskText));
    }

    /**
     * this method  find the ald task and update whit the a new task.
     *
     * @param oldText      String old task created.
     * @param textToUpdate String new task to update.
     */
    public void updateTheTasks(final String oldText, final String textToUpdate) {
        List<WebElement> tasksElements = taskIndex
                .findElements(By.xpath("//li[contains(@class,'task draggable droppable task')]"));
        tasksElements.stream()
                .filter(webElement -> oldText.equals(webElement.getText()))
                .forEach(webElement -> updateTheTask(webElement, textToUpdate));
    }

    /**
     * this method is in charge to update the task.
     *
     * @param webElement   Web element whit in the task
     * @param textToUpdate String the new task to update.
     */
    private void updateTheTask(final WebElement webElement, final String textToUpdate) {
        CommonActions.clickElement(webElement);
        CommonActions.clickElement(webElement
                .findElement(By.cssSelector(EDIT_BUTTON)));
        CommonActions.sendKeys(webElement
                .findElement(By.xpath(TASK_TEXT_AREA)), textToUpdate);
        CommonActions.clickElement(webElement.findElement(By.cssSelector(SAVE_BUTTON)));
    }

    /**
     * this method finds the task and press the delete button.
     *
     * @param taskCreated task created.
     */
    public void deleteTask(final String taskCreated) {
        String task = Mapper.mapEndpoint(taskCreated);
        List<WebElement> tasksElements = taskIndex
                .findElements(By.xpath(ALL_DELETE_BUTTONS));
        tasksElements.stream().filter(webElement -> task.equals(webElement.getText()))
                .forEach(this::deleteTask);
    }

    /**
     * Delete The task requested.
     *
     * @param webElement Web Element whit in the task.
     */
    private void deleteTask(final WebElement webElement) {
        CommonActions.clickElement(webElement);
        CommonActions.clickElement(webElement
                .findElement(By.cssSelector(DELETE_BUTTON)));
    }

}
