package org.example.order;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.loginUser.BaseClient;

public class ListOfOrdersAPI {
    private static final String LISTORDERS_PATH = "/api/orders";
    public String accessToken;
    BaseClient baseClient = new BaseClient();
    @Step("send GET request to /api/orders")

    public Response putDataWithAvtorization() {
        return baseClient.RequestSpecificationspec()
                .header("Authorization", accessToken)
                .when()
                .get(LISTORDERS_PATH);
    }

    @Step("send GET request to /api/orders")
    public Response putListOfOrders() {
        return baseClient.RequestSpecificationspec()
                .when()
                .get(LISTORDERS_PATH);
    }
}
