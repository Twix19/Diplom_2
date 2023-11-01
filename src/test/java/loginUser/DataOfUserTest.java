package loginUser;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.example.loginUser.DataOfUserAPI;
import org.junit.Test;

import static org.apache.http.HttpStatus.SC_OK;

public class DataOfUserTest {
    DataOfUserAPI dataOfUserAPI = new DataOfUserAPI();
    @Test
    @DisplayName("Обновление данных пользователя")
    @Description("Метод отправляет данные пользователя на сервер, происходит авторизация пользователя, метод получает assesToken, по токену получает инормацию о пользователю, после по токену обновляет информацию о нем.В случае успешного выполнения запроса будет получен ответ со статусом 200.")
    public void avtorizationUser(){
        dataOfUserAPI.sendAvtorizationOfUser()
                .then().log().all()
                .assertThat()
                .statusCode(SC_OK);
        dataOfUserAPI.accessToken = dataOfUserAPI.sendAvtorizationOfUser().then()
                .extract()
                .path("accessToken");
    }

}
