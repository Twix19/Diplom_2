package org.example.order;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.loginUser.LoginUser;
import org.example.user.User;

public class OrderAPI {
    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site";
    private static final String ORDER_PATH = "/api/orders";
    private static final String DATAOFINGREDIENTS_PATH = "/api/ingredients";
    private static final String LOGIN_PATH = "/api/auth/login";

    // public String idOfIngredients = "\"61c0c5a71d1f82001bdaaa6f\", \"61c0c5a71d1f82001bdaaa70\"";
    String idOfIngredients = "{\"ingredients\": [\"60d3b41abdacab0026a733c6\",\"609646e4dc916e00276b2870\"]}";
    String ingredient = "";
    LoginUser loginUser = new LoginUser("ckn@yandex.ru", "v9lvoe8");
    public Response sendAvtorizationOfUser() {
        return RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL)
                .body(loginUser)
                .when()
                .post(LOGIN_PATH);
    }
    public Response putDataOfIngredients() {
        return RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL)
                //.body()
                .when()
                .get(DATAOFINGREDIENTS_PATH);
    }
    public Response sendDataOfIngredients() {
        return RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL)
                .body(idOfIngredients)
                .when()
                .post(ORDER_PATH);
    }
    public Response sendDataWithoutIngredients() {
        return RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL)
                .body(ingredient)
                .when()
                .post(ORDER_PATH);
    }

}
