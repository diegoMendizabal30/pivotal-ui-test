package org.fundacionjala.pivotaluitest.ui.pages.workspace;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacionjala.pivotaluitest.ui.pages.AbstractBasePage;
import org.fundacionjala.pivotaluitest.ui.pages.common.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class represent a tool bar workspace page.
 */
public class ToolBarWorkspace extends AbstractBasePage {

    private static final Logger LOGGER = LogManager.getLogger(Workspace.class.getSimpleName());

    @FindBy(css = "a[data-aid='navTab-settings']")
    private WebElement settingsWorkspaceTab;

    @FindBy(css = "a[data-aid='navTab-stories']")
    private WebElement storiesWorkspaceTab;


    @FindBy(className = "raw_context_name")
    private WebElement workspaceNameText;

    @FindBy(className = "page_header_container")
    private WebElement toolBarContainer;

    /**
     * This method represent a click in settings tab.
     *
     * @return a object setting workspace page.
     */
    public SettingWorkspace clickSettingsWorkspaceTab() {
        settingsWorkspaceTab.click();
        return new SettingWorkspace();
    }

    /**
     * This method represent a click in stories tab.
     *
     * @return a object setting workspace page.
     */
    public Workspace clickStoriesWorkspaceTab() {
        storiesWorkspaceTab.click();
        return new Workspace();
    }

    /**
     * This method  gets text of tool bar container.
     *
     * @return a string with a text.
     */
    public String getWorkspaceNameText() {
        return CommonActions.getText(workspaceNameText);
    }

}
