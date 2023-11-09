package org.example.user;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.loginUser.BaseClient;

public class UserAPI {

    private static final String USER_PATH = "/api/auth/register";
    User user = new User("kjkgkgkgk@yandex.ru", "ecew8tfbbkd90ki", "Loluas");
    User userWithoutPasssword = new User("kosacr@yandex.ru", "", "Lola");
    User excitingUser = new User("ehdhoeecflx@yandex.ru", "ecew82ubkd90ki", "Loluas");
    BaseClient baseClient = new BaseClient();


    @Step("send POST request to /api/auth/register")
    public Response sendCreationDataOfUser() {
        return baseClient.RequestSpecificationspec()
                .body(user)
                .when()
                .post(USER_PATH);
    }
    @Step("send POST request to /api/auth/register")

    public Response sendDataOfExistingUser() {
        return baseClient.RequestSpecificationspec()
                .body(excitingUser)
                .when()
                .post(USER_PATH);
    }
    @Step("send POST request to /api/auth/register")

    public Response sendDataWithMissingFields() {
        return baseClient.RequestSpecificationspec()
                .body(userWithoutPasssword)
                .when()
                .post(USER_PATH);

    }

}