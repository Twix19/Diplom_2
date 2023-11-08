package org.example.loginUser;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DataOfUserAPI {
    private static final String LOGIN_PATH = "/api/auth/login";
    private static final String DATA_PATH = "/api/auth/user";
    LoginUser loginUser = new LoginUser("ckn@yandex.ru", "v9lvoe8");
    BaseClient baseClient = new BaseClient();
    public String accessToken;
    @Step("send POST request to /api/auth/login")

    public Response sendAvtorizationDataOfUser() {
        return baseClient.RequestSpecificationspec()
                .body(loginUser)
                .when()
                .post(LOGIN_PATH);
    }
    @Step("send PATCH request to /api/auth/user")

    public Response changeData() {
        return baseClient.RequestSpecificationspec()
                .header("Authorization", accessToken)
                .body(loginUser)
                .when()
                .patch(DATA_PATH);
    }
    @Step("send PATCH request to /api/auth/user")

    public Response sendDataUpdateWithoutAvto() {
        return baseClient.RequestSpecificationspecTwo()
                .when()
                .patch(DATA_PATH);
    }
}
