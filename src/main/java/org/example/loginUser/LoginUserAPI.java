package org.example.loginUser;

import io.qameta.allure.Step;
import io.restassured.response.Response;


public class LoginUserAPI {

    private static final String LOGIN_PATH = "/api/auth/login";
    private static final String DELETE_PATH = "/api/auth/user";
    BaseClient baseClient = new BaseClient();
    LoginUser loginUser = new LoginUser("esesyuiiut@yandex.ru", "ecew8tfbbkd90ki"); // при создании нового курьера нужно вписывать сюда эмаил и пароль пользователя, которого создали
    WrongLogin wrongLogin = new WrongLogin("djgjgsc@yandex.ru", "hcksdck"); //для теста с несуществующим логином и паролем

    public String accessToken;

    @Step("send POST request to /api/auth/login")
    public Response sendAvtorizationDataOfUser() {
        return baseClient.RequestSpecificationspec()
                .body(loginUser)
                .when()
                .post(LOGIN_PATH);
    }
    @Step("send POST request to /api/auth/login")
    public Response sendWrongAvtorizationDataOfUser() {
        return baseClient.RequestSpecificationspec()
                .body(wrongLogin)
                .when()
                .post(LOGIN_PATH);

    }

    @Step("send DELETE request to /api/auth/user")
    public Response deleteUser(String accessToken){
        return baseClient.RequestSpecificationspec()
                .header("Authorization", accessToken)
                .when()
                .delete(DELETE_PATH);
    }
    @Step("send PATCH request to /api/auth/user")

    public Response sendAvtorizationData() {
        return baseClient.RequestSpecificationspec()
                .header("Authorization", accessToken)
                .body(loginUser)
                .when()
                .post(LOGIN_PATH);
    }


}
