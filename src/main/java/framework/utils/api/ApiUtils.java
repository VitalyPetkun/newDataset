package framework.utils.api;

import framework.utils.SmartLogger;
import io.restassured.http.ContentType;
import com.sun.net.httpserver.Headers;

import static io.restassured.RestAssured.*;

public class ApiUtils {

    protected ApiUtils() {
    }

    public static void setupBaseUri(String currentBaseUri) {
        SmartLogger.logInfo("Setup baseUri ".concat(currentBaseUri));
        baseURI = currentBaseUri;
    }

    protected static Response doGet(Headers headers, ContentType contentType, String endPoints) {
        SmartLogger.logInfo("Get request ".concat(baseURI).concat(endPoints).
                concat(" with headers: ").concat(headers.toString()));
        return new Response(given().headers(headers).accept(contentType).when().get(endPoints).then());
    }

    protected static Response doPost(Headers headers, ContentType contentType, String body, String endPoints) {
        SmartLogger.logInfo("Post request ".concat(baseURI).concat(endPoints).
                concat(" with headers: ").concat(headers.toString()));
        return new Response(given().headers(headers).contentType(contentType).
                body(body).when().post(endPoints).then());
    }

    protected static Response doPut(Headers headers, ContentType contentType, String body, String endPoints) {
        SmartLogger.logInfo("Put request ".concat(baseURI).concat(endPoints).
                concat(" with headers: ").concat(headers.toString()));
        return new Response(given().headers(headers).contentType(contentType).
                body(body).when().put(endPoints).then());
    }

    protected static Response doPatch(Headers headers, ContentType contentType, String body, String endPoints) {
        SmartLogger.logInfo("Patch request ".concat(baseURI).concat(endPoints).
                concat(" with headers: ").concat(headers.toString()));
        return new Response(given().headers(headers).contentType(contentType).
                body(body).when().patch(endPoints).then());
    }


    protected static Response doDelete(Headers headers, ContentType contentType, String endPoints) {
        SmartLogger.logInfo("Delete request ".concat(baseURI).concat(endPoints).
                concat(" with headers: ").concat(headers.toString()));
        return new Response(given().headers(headers).contentType(contentType).when().delete(endPoints).then());
    }
}
