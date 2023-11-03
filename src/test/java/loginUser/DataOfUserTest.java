package loginUser;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.example.loginUser.DataOfUserAPI;
import org.example.loginUser.LoginUserAPI;
import org.junit.Test;

import static org.apache.http.HttpStatus.SC_OK;
import static org.apache.http.HttpStatus.SC_UNAUTHORIZED;

public class DataOfUserTest {
    DataOfUserAPI dataOfUserAPI = new DataOfUserAPI();
    LoginUserAPI loginUserAPI = new LoginUserAPI();
    @Test
    @DisplayName("Обновление данных пользователя с автоизацией")
    @Description("Метод отправляет данные пользователя на сервер, происходит авторизация пользователя, метод получает assesToken, по токену получает инормацию о пользователю, после по токену обновляет информацию о нем.В случае успешного выполнения запроса будет получен ответ со статусом 200.")
    public void avtorizationUser(){
        dataOfUserAPI.accessToken = dataOfUserAPI.sendAvtorizationDataOfUser().then()
                        .extract()
                        .path("accessToken");
        dataOfUserAPI.changeData()
                .then().log().all()
                .assertThat()
                .statusCode(SC_OK);
    }
    @Test
    @DisplayName("Обновление данных пользователя без авторизации")
    @Description("Метод отправляет данные пользователя на сервер без авторизации, метод не получает assesToken, обновить информацию о нем не получиться.В случае успешного выполнения запроса будет получен ответ со статусом 401.")
    public void withoutAvtorizationUser(){
        dataOfUserAPI.sendDataUpdateWithoutAvto()
                .then().log().all()
                .assertThat()
                .statusCode(SC_UNAUTHORIZED)
                .extract()
                .path("false");
    }

}
