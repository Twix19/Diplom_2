package org.example.loginUser;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DataOfUserAPI {
    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site";
    private static final String LOGIN_PATH = "/api/auth/login";
    private static final String DATA_PATH = "/api/auth/user";
    LoginUser loginUser = new LoginUser("ckn@yandex.ru", "v9lvoe8");
    public String accessToken;

    public Response sendAvtorizationDataOfUser() {
        return RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL)
                .body(loginUser)
                .when()
                .post(LOGIN_PATH);
    }

    public Response changeData() {
        return RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL)
                .header("Authorization", accessToken)
                .body(loginUser)
                .when()
                .patch(DATA_PATH);
    }
    public Response sendDataUpdateWithoutAvto() {
        return RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL)
                .when()
                .patch(DATA_PATH);
    }
}
