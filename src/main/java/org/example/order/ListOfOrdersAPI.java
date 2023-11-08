package org.example.order;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ListOfOrdersAPI {
    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site";
    private static final String LISTORDERS_PATH = "/api/orders";
    private static final String TOKEN_PATH = "/api/auth/token";
    public String accessToken;
    @Step("send GET request to /api/orders")

    public Response putDataWithAvtorization() {
        return RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL)
                .header("Authorization", accessToken)
               // .body(loginUser)
                .when()
                .get(LISTORDERS_PATH);
    }
    @Step("send POST request to /api/auth/token")
    public Response tokenUpdate() {
        return RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL)
                .when()
                .post(TOKEN_PATH);
    }
    @Step("send GET request to /api/orders")
    public Response putListOfOrders() {
        return RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL)
                .when()
                .get(LISTORDERS_PATH);
    }
}
