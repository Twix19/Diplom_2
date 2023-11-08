package com.user;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.example.user.UserAPI;
import org.junit.Test;

import static org.apache.http.HttpStatus.SC_FORBIDDEN;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.equalTo;

public class UserTest {
    UserAPI userAPI = new UserAPI();

    @Test
    @DisplayName("Создание пользователя")
    @Description("Метод отправляет данные пользователя на сервер.В случае успешного выполнения запроса будет получен ответ со статусом 200.")
    public void createUser(){
        userAPI.sendCreationDataOfUser()
                .then().log().all()
                .assertThat()
                .statusCode(SC_OK)
                .extract()
                .path("true");
    }
    @Test
    @DisplayName("Создание существующего пользователя")
    @Description("Метод отправляет данные пользователя, который уже зарегестрирован на сайте.В случае успешного выполнения запроса будет получен ответ со статусом 403.")
    public void createExcitingUser(){
        userAPI.sendDataOfExistingUser()
                .then().log().all()
                .assertThat()
                .statusCode(SC_FORBIDDEN)
                .extract()
                .path("false", String.valueOf(equalTo("User already exists")));
    }
    @Test
    @DisplayName("Создание пользователя с пропущенными данными")
    @Description("Метод отправляет недостаточно данных пользователя.В случае успешного выполнения запроса будет получен ответ со статусом 403.")
    public void createUserWithMissingFields(){
        userAPI.sendDataWithMissingFields()
                .then().log().all()
                .assertThat()
                .statusCode(SC_FORBIDDEN)
                .extract()
                .path("false", String.valueOf(equalTo("Email, password and name are required fields")));
    }
}

