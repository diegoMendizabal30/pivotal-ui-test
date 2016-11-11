package org.fundacionjala.pivotal.cucumber.hooks;

import java.util.List;
import java.util.Map;

import cucumber.api.java.Before;

import org.fundacionjala.pivotal.api.RequestManager;

import static org.fundacionjala.pivotal.api.RequestManager.delete;

/**
 * Hook to delete all projects that is created with the feature.
 */
public class ProjectHook {
    private static final String PROJECTS_ENDPOINT = "/projects/";

    private static final String ID_KEY = "id";

    /**
     * Method to delete all projects that meets with the condition.
     */
    @Before("@deleteAllProjects")
    public final void deleteAllProjects() {
        List<Map<String, ?>> projects = RequestManager.get(PROJECTS_ENDPOINT).jsonPath().get();
        for (Map<String, ?> object : projects) {
            delete(PROJECTS_ENDPOINT + object.get(ID_KEY).toString());
        }
    }
}
