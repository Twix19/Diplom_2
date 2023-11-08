package org.example.loginUser;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class LoginUserAPI {
    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site";
    private static final String LOGIN_PATH = "/api/auth/login";
    LoginUser loginUser = new LoginUser("esesyuiiut@yandex.ru", "ecew8tfbbkd90ki"); // при создании нового курьера нужно вписывать сюда эмаил и пароль пользователя, которого создали
    WrongLogin wrongLogin = new WrongLogin("djgjgsc@yandex.ru", "hcksdck"); //для теста с несуществующим логином и паролем

   @Step("send POST request to /api/auth/login")
    public Response sendAvtorizationDataOfUser() {
        return RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL)
                .body(loginUser)
                .when()
                .post(LOGIN_PATH);
    }
    @Step("send POST request to /api/auth/login")
    public Response sendWrongAvtorizationDataOfUser() {
        return RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL)
                .body(wrongLogin)
                .when()
                .post(LOGIN_PATH);

    }
}
