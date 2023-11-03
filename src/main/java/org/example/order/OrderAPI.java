package org.example.order;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
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

    public Response sendAvtorizationDataOfUser() {
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
    public Response sendWrongDataOfIngredients() {
        return RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL)
                .body(idOfWrongIngredients)
                .when()
                .post(ORDER_PATH);
    }

}
