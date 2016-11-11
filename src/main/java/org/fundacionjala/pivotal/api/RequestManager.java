package org.fundacionjala.pivotal.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * Class to manage the Request.
 */
public final class RequestManager {

    private static final RequestSpecification REQUEST_SPECIFICATION =
            Connection.getInstance().getRequestSpecification();

    /**
     * Private constructor.
     */
    private RequestManager() {
    }

    /**
     * Method that execute the get request.
     *
     * @param endPoint route of the get end point.
     * @return the response of the request
     */
    public static Response get(final String endPoint) {
        return given().spec(REQUEST_SPECIFICATION)
                .when()
                .get(endPoint);
    }

    /**
     * Method that execute the post request.
     *
     * @param endPoint route of the end point.
     * @param body     Json data.
     * @return the Response of the request.
     */
    public static Response post(final String endPoint, final String body) {
        return given().spec(REQUEST_SPECIFICATION)
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(endPoint);
    }

    /**
     * Method that execute a post request given a Map as a data.
     *
     * @param endPoint route of the endpoint.
     * @param body     data to be send as params.
     * @return response of the request.
     */
    public static Response post(final String endPoint, final Map<String, Object> body) {
        return given().spec(REQUEST_SPECIFICATION)
                .params(body)
                .when()
                .post(endPoint);
    }

    /**
     * Method that execute the put request.
     *
     * @param endPoint route of the endpoint.
     * @param body     data to be updated.
     * @return the Response.
     */
    public static Response put(final String endPoint, final String body) {
        return given().spec(REQUEST_SPECIFICATION)
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .put(endPoint);
    }

    /**
     * Method that execute the put request given a Map as a data.
     *
     * @param endPoint route of the endpoint.
     * @param body     data to be updated.
     * @return the Response.
     */
    public static Response put(final String endPoint, final Map<String, Object> body) {
        return given().spec(REQUEST_SPECIFICATION)
                .params(body)
                .when()
                .put(endPoint);
    }

    /**
     * Method that execute the delete request.
     *
     * @param endPoint route of the end point.
     * @return the response of the delete request.
     */
    public static Response delete(final String endPoint) {
        return given().spec(REQUEST_SPECIFICATION)
                .when()
                .delete(endPoint);
    }
}
