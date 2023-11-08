package org.example.loginUser;

import static io.restassured.RestAssured.given;
import  io.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
public class BaseClient {
    private static final String BASE_URI = "https://stellarburgers.nomoreparties.site";
    private static final String LOGIN_PATH = "/api/auth/login";
    private static final String DATA_PATH = "/api/auth/user";
    public RequestSpecification spec() {
        return given()
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter())
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .basePath(LOGIN_PATH)
                ;
    }
    public RequestSpecification specTwo() {
        return given()
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter())
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI)
                .basePath(DATA_PATH)
                ;
    }
}
