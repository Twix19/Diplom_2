package org.example.order;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.loginUser.BaseClient;
import org.example.loginUser.LoginUser;
import org.example.user.User;
import org.example.loginUser.DataOfUserAPI;

public class OrderAPI {
    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site";
    private static final String ORDER_PATH = "/api/orders";
    private static final String DATAOFINGREDIENTS_PATH = "/api/ingredients";
    private static final String LOGIN_PATH = "/api/auth/login";

    String idOfIngredients = "{\"ingredients\": [\"61c0c5a71d1f82001bdaaa6d\",\"609646e4dc916e00276b2870\"]}";
    String idOfWrongIngredients = "{\"ingredients\": [\"61c0c5a7182001bdaaa6d\",\"609646e4dc9276b2870\"]}";
    String ingredient = "";
    public String accessToken;
    LoginUser loginUser = new LoginUser("ckn@yandex.ru", "v9lvoe8");
    BaseClient baseClient = new BaseClient();

    @Step("send POST request to /api/auth/login")

    public Response sendAvtorizationDataOfUser() {
        return baseClient.RequestSpecificationspec()
                .body(loginUser)
                .when()
                .post(LOGIN_PATH);
    }
    @Step("send GET request to /api/ingredients")
    public Response putDataOfIngredients() {
        return baseClient.RequestSpecificationspec()
                //.body()
                .when()
                .get(DATAOFINGREDIENTS_PATH);
    }
    @Step("send POST request to /api/ingredients")
    public Response sendDataOfIngredients() {
        return baseClient.RequestSpecificationspec()
                .body(idOfIngredients)
                .when()
                .post(ORDER_PATH);
    }
    @Step("send POST request to /api/orders")
    public Response sendDataWithoutIngredients() {
        return baseClient.RequestSpecificationspec()
                .body(ingredient)
                .when()
                .post(ORDER_PATH);
    }
    @Step("send POST request to /api/orders")
    public Response sendWrongDataOfIngredients() {
        return baseClient.RequestSpecificationspec()
                .body(idOfWrongIngredients)
                .when()
                .post(ORDER_PATH);
    }

}
