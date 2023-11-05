package order;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.example.order.OrderAPI;
import org.junit.Test;
import static org.apache.http.HttpStatus.*;

public class OrderTest {
  OrderAPI orderAPI = new OrderAPI();
  @Test
  @DisplayName("Создание заказа с авторизацией")
  @Description("Метод отправляет данные пользователя на сервер для авторизации,получает данные об ингредиентах,создаёт заказ id ингредиентов .В случае успешного выполнения запроса будет получен ответ со статусом 200.")
  public void createOrderWithAvtorization(){
    orderAPI.sendAvtorizationDataOfUser();
    orderAPI.putDataOfIngredients();
    orderAPI.sendDataOfIngredients()
            .then().log().all()
            .assertThat()
            .statusCode(SC_OK);
    orderAPI.accessToken = orderAPI.sendAvtorizationDataOfUser().then()
            .extract()
            .path("accessToken");
  }

  @Test
  @DisplayName("Создание заказа без авторизации")
  @Description("Метод получает данные об ингредиентах,создаёт заказ с помощью id ингредиентов без авторизации .В случае успешного выполнения запроса будет получен ответ со статусом 200.")
  public void createOrderWithoutAvtorization(){
    orderAPI.putDataOfIngredients();
    orderAPI.sendDataOfIngredients()
            .then().log().all()
            .assertThat()
            .statusCode(SC_OK)
            .extract()
            .path("true");
  }

  @Test
  @DisplayName("Создание заказа с ингредиентами")
  @Description("Метод отправляет данные пользователя на сервер для авторизации,получает данные об ингредиентах,создаёт заказ с ингредиентами .В случае успешного выполнения запроса будет получен ответ со статусом 200.")
  public void createOrderWithIngredients(){
    orderAPI.sendAvtorizationDataOfUser();
    orderAPI.putDataOfIngredients();
    orderAPI.sendDataOfIngredients()
            .then().log().all()
            .assertThat()
            .statusCode(SC_OK)
            .extract()
            .path("true");
  }


  @Test
  @DisplayName("Создание заказа без ингредиентов")
  @Description("Метод отправляет данные пользователя на сервер для авторизации,получает данные об ингредиентах,создаёт заказ без ингредиентов .В случае успешного выполнения запроса будет получен ответ со статусом 400.")
  public void createOrderWithoutIngredientHash(){
    orderAPI.sendAvtorizationDataOfUser();
    orderAPI.putDataOfIngredients();
    orderAPI.sendDataWithoutIngredients()
            .then().log().all()
            .assertThat()
            .statusCode(SC_BAD_REQUEST)
            .extract()
            .path("false");
  }
  @Test
  @DisplayName("Создание заказа с неверным хешом ингредиента")
  @Description("Метод отправляет данные пользователя на сервер для авторизации,получает данные об ингредиентах,создаёт заказ с помощью id ингредиентов .В случае успешного выполнения запроса будет получен ответ со статусом 503.")
  public void createOrderWithIncorrectIngredientHash(){
    orderAPI.sendAvtorizationDataOfUser();
    orderAPI.putDataOfIngredients();
    orderAPI.sendWrongDataOfIngredients()
            .then().log().all()
            .assertThat()
            .statusCode(SC_INTERNAL_SERVER_ERROR)
            .extract()
            .path("false");
  }


}
