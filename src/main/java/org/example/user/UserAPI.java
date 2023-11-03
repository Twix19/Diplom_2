package org.example.user;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserAPI {
    private static final String BASE_URL = "https://stellarburgers.nomoreparties.site";
    private static final String USER_PATH = "/api/auth/register";
    User user = new User("koggffr@yandex.ru", "opbkd90ki", "Lola");
    User userWithoutPasssword = new User("kosacr@yandex.ru", "", "Lola");


    public Response sendCreationDataOfUser() {
        return RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL)
                .body(user)
                .when()
                .post(USER_PATH);
    }

    public Response sendDataOfExistingUser() {
        return RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL)
                .body(user)
                .when()
                .post(USER_PATH);
    }

    public Response sendDataWithMissingFields() {
        return RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL)
                .body(userWithoutPasssword)
                .when()
                .post(USER_PATH);

    }
}