package loginUser;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.example.loginUser.LoginUserAPI;
import org.junit.Test;

import static org.apache.http.HttpStatus.SC_OK;
import static org.apache.http.HttpStatus.SC_UNAUTHORIZED;
import static org.hamcrest.CoreMatchers.equalTo;

public class LoginUserTest {
    LoginUserAPI loginUserAPI = new LoginUserAPI();
    @Test
    @DisplayName("Авторизация под существующим пользователем")
    @Description("Метод отправляет данные пользователя на сервер.В случае успешного выполнения запроса будет получен ответ со статусом 200.")
    public void avtorizationUser(){
        loginUserAPI.sendAvtorizationDataOfUser()
                .then().log().all()
                .assertThat()
                .statusCode(SC_OK)
                .extract()
                .path("true");
    }
    @Test
    @DisplayName("Авторизация с неверным логином и паролем")
    @Description("Метод отправляет неверные данные пользователя на сервер.В случае успешного выполнения запроса будет получен ответ со статусом 401.")
    public void avtorizationWrongUser(){
        loginUserAPI.sendWrongAvtorizationDataOfUser()
                .then().log().all()
                .assertThat()
                .statusCode(SC_UNAUTHORIZED)
                .extract()
                .path("false", String.valueOf(equalTo("email or password are incorrect")));
    }
}
