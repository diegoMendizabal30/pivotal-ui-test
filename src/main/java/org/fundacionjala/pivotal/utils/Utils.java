package org.fundacionjala.pivotal.utils;

import java.util.List;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/**
 * Class to help with operations.
 */
public final class Utils {

    /**
     * Private constructor.
     */
    private Utils() {
    }

    /**
     * Method to build the name of key for a given a table header column name.
     *
     * @param key table column name.
     * @return the key built.
     */
    public static String replaceSpaceWithUnderscore(final String key) {
        return key.toLowerCase().replaceAll(" ", "_");
    }

    /**
     * Method to find an element into and List of Response.
     *
     * @param value        the searched value.
     * @param responseList the List where the the Value is searched.
     * @return a JsonPath if the value is found.
     */
    public static JsonPath findElementJson(final String value, final List<Response> responseList) {
        return responseList.stream()
                .filter(e -> e.jsonPath().get("name").equals(value))
                .findFirst()
                .get()
                .jsonPath();
    }
}
