package org.fundacionjala.pivotaluitest.ui.pages.workspace;

import org.fundacionjala.pivotaluitest.ui.pages.AbstractBasePage;
import org.fundacionjala.pivotaluitest.ui.pages.Dashboard;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class create a form to create a new Workspace.
 */
public class DeleteWorkspace extends AbstractBasePage {
    //mover commons confirm delete
    @FindBy(id = "confirm_delete")
    private WebElement confirmDeleteButton;

    @FindBy(className = "cancel")
    private WebElement cancelDeleteButton;

    /**
     * This method makes a click in cancel button.
     */
    public void clickCancelDeleteLink() {
        cancelDeleteButton.click();
    }

    /**
     * This method makes a click in confirm Delete Button.
     *
     * @return a object dashboard page.
     */
    public Dashboard clickConfirmDeleteLink() {
        confirmDeleteButton.click();
        return new Dashboard();
    }

}
