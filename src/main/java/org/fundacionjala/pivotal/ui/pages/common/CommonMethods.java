package org.fundacionjala.pivotal.ui.pages.common;

import java.util.ArrayList;
import java.util.Map;

import static io.restassured.path.json.JsonPath.from;
import static org.fundacionjala.pivotal.api.RequestManager.delete;
import static org.fundacionjala.pivotal.api.RequestManager.get;
import static org.fundacionjala.pivotal.utils.Constants.PROJECTS_ENDPOINT;
import static org.fundacionjala.pivotal.utils.Constants.PROJECT_ID;
import static org.fundacionjala.pivotal.utils.Constants.WORKSPACES_ENDPOINT;
import static org.fundacionjala.pivotal.utils.Constants.WORKSPACE_ID;

/**
 * This class contains common methods.
 */
public final class CommonMethods {

    /**
     * This the constructor of the class.
     */
    private CommonMethods() {
    }

    /**
     * This method deletes all projects for the API.
     */
    public static void deleteAllProjects() {
        ArrayList<Map<String, ?>> jsonAsArrayList = from(get(PROJECTS_ENDPOINT).asString()).get("");
        if (jsonAsArrayList.size() > 0) {
            for (Map<String, ?> object : jsonAsArrayList) {
                delete(PROJECTS_ENDPOINT + object.get(PROJECT_ID).toString());
            }
        }
    }

    /**
     * This method deletes all workspace for the API.
     */
    public static void deleteAllWorkspaces() {
        ArrayList<Map<String, ?>> jsonAsArrayList = from(get(WORKSPACES_ENDPOINT).asString()).get("");
        if (jsonAsArrayList.size() > 0) {
            for (Map<String, ?> object : jsonAsArrayList) {
                delete(WORKSPACES_ENDPOINT + object.get(WORKSPACE_ID).toString());
            }
        }
    }

}
