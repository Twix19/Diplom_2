package order;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.example.order.ListOfOrdersAPI;
import org.junit.Test;

import static org.apache.http.HttpStatus.SC_OK;
import static org.apache.http.HttpStatus.SC_UNAUTHORIZED;

public class ListOdOrdersTest {
    ListOfOrdersAPI listOfOrdersAPI = new ListOfOrdersAPI();

    @Test
    @DisplayName("Получение заказов авторизованным пользователем") //работает
    @Description("Метод отправляет данные пользователя на сервер, получает список его заказов .В случае успешного выполнения запроса будет получен ответ со статусом 200.")
    public void listOfOrdersOfAvtorizationUser(){
        listOfOrdersAPI.putListOfOrdersWithouAvtorization()
                .then().log().all()
                .assertThat()
                .statusCode(SC_OK)
                .extract()
                .path("true");
    }
    @Test
    @DisplayName("Получение заказов неавторизованным пользователем") //работает
    @Description("Метод ожидает получить заказы неавторизованнго пользователя.В случае успешного выполнения запроса будет получен ответ со статусом 401.")
    public void listOfOrdersOfNotAvtorizationUser(){
        listOfOrdersAPI.putListOfOrdersWithouAvtorization()
                .then().log().all()
                .assertThat()
                .statusCode(SC_UNAUTHORIZED)
                .extract()
                .path("false");
    }
}
