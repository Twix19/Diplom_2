package org.example.loginUser;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.user.User;

public class LoginUserAPI {
    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site";
    private static final String LOGIN_PATH = "/api/auth/login";
    // User user = new User("", "", "");
    LoginUser loginUser = new LoginUser("ckn@yandex.ru", "v9lvoe8"); // при создании нового курьера нужно вписывать сюда эмаил и пароль пользователя, которого создали
    WrongLogin wrongLogin = new WrongLogin("djgjgsc@yandex.ru", "hcksdck"); //для теста с несуществующим логином и паролем
    public Response sendAvtorizationDataOfUser() {
        return RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL)
                .body(loginUser)
                .when()
                .post(LOGIN_PATH);
    }
    public Response sendWrongAvtorizationDataOfUser() {
        return RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL)
                .body(wrongLogin)
                .when()
                .post(LOGIN_PATH);

    }


}
