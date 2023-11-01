package org.example.loginUser;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DataOfUserAPI {
    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site";
    private static final String LOGIN_PATH = "/api/auth/login";
    LoginUser loginUser = new LoginUser("koar@yandex.ru", "op90ki");
    public String accessToken;
    public Response sendAvtorizationOfUser() {
        return RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL)
                .body(loginUser)
                .when()
                .post(LOGIN_PATH);
    }
}
