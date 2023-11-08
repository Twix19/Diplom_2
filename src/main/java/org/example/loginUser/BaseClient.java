package org.example.loginUser;

import static io.restassured.RestAssured.given;
import  io.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
public class BaseClient {
    private static final String BASE_URI = "https://stellarburgers.nomoreparties.site";

    public RequestSpecification RequestSpecificationspec() {
        return given()
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter())
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI);

    }
}
