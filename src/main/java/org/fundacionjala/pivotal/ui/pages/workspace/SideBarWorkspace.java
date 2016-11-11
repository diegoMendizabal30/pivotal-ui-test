package org.fundacionjala.pivotal.ui.pages.workspace;


import org.fundacionjala.pivotal.ui.pages.AbstractBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class represent the side bar workspace.
 */
public class SideBarWorkspace extends AbstractBasePage {

    @FindBy(css = "ul[class=\"wu3Gt__DropdownMenu__menuList WorkspaceSidebar__addProjectMenu___3iT7aSmD\"]")
    private WebElement addProjectLinks;

    @FindBy(xpath = "//button[contains(.,'add project')]")
    private WebElement addProjectLink;

    @FindBy(className = "WorkspaceSidebar__projectsDropdown___2ncE8K1p")
    private WebElement listProjectLink;

    @FindBy(css = "button[class=\"save\"]")
    private WebElement saveWorkspaceLink;

    /**
     * This method represent a click in add project button.
     */
    public void clickAddProjectButton() {
        addProjectLink.click();
    }

    /**
     * This method represent a click in add project.
     */
    public void clickListProjectLink() {
        listProjectLink.click();
    }

    /**
     * This method represent a click in a project fo the list.
     *
     * @param projectName is a string with the name of project.
     */
    public void clickProjectNameLink(final String projectName) {
        addProjectLinks.findElement(By.xpath("//li[contains(.,'" + projectName + "')]")).click();
    }

    /**
     * This method represent a click in save button.
     *
     * @return a oject Workspace page.
     */
    public Workspace clickSaveWorkspaceLink() {
        saveWorkspaceLink.click();
        return new Workspace();
    }
}
