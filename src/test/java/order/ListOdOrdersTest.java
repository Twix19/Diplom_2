package order;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.example.loginUser.LoginUserAPI;
import org.example.order.ListOfOrdersAPI;
import org.junit.Test;

import static org.apache.http.HttpStatus.SC_OK;
import static org.apache.http.HttpStatus.SC_UNAUTHORIZED;

public class ListOdOrdersTest {
    ListOfOrdersAPI listOfOrdersAPI = new ListOfOrdersAPI();
    LoginUserAPI loginUserAPI = new LoginUserAPI();


    @Test
    @DisplayName("Получение заказов авторизованным пользователем")
    @Description("Метод отправляет данные пользователя на сервер, получает список его заказов .В случае успешного выполнения запроса будет получен ответ со статусом 200.")
    public void listOfOrdersOfAvtorizationUser(){
        loginUserAPI.sendAvtorizationDataOfUser();
        listOfOrdersAPI.accessToken = loginUserAPI.sendAvtorizationDataOfUser().then()
                .extract()
                .path("accessToken");
                System.out.println("accessToken");
        listOfOrdersAPI.putListOfOrders()
                .then().log().all()
                .assertThat()
                .statusCode(SC_OK);
    }
    @Test
    @DisplayName("Получение заказов неавторизованным пользователем")
    @Description("Метод ожидает получить заказы неавторизованнго пользователя.В случае успешного выполнения запроса будет получен ответ со статусом 401.")
    public void listOfOrdersOfNotAvtorizationUser(){
        listOfOrdersAPI.putListOfOrders()
                .then().log().all()
                .assertThat()
                .statusCode(SC_UNAUTHORIZED)
                .extract()
                .path("false");
    }
}
