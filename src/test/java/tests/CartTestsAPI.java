package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class CartTestsAPI extends TestBase {

  private final ServiceAPI serviceAPI = new ServiceAPI();

  @Test
  @DisplayName("Проверка счетчика корзины не авторизованного по API пользователя после добавления товара в корзину по API")
  @Tag("API")
  void addItemToCartAsNewUserTest() {
    String cookies = serviceAPI.getCookieNewUser();
    serviceAPI.addToCartWithCheckResult(cookies, 1);
  }

  @Test
  @DisplayName("Проверка счетчика корзины авторизованного по API пользователя после добавления товара в корзину по API")
  @Tag("API")
  void checkCartCounterAuthUserAPITest() {
    String cookies = serviceAPI.getCookieAfterAPIAuth();
    int result = serviceAPI.getCurrentValueInCartAPI(cookies) + 1;
    serviceAPI.addToCartWithCheckResult(cookies, result);
  }

  @Test
  @DisplayName("Проверка счетчика корзины авторизованного по API пользователя после добавления товара(2 шт.) в корзину по API")
  @Tag("API")
  void checkCartCounterAuthUserDoubleItemTest() {
    String cookies = serviceAPI.getCookieAfterAPIAuth();
    int currentCount = serviceAPI.getCurrentValueInCartAPI(cookies);
    serviceAPI.addToCartConfigured(cookies, currentCount, 31, 2);
  }
}
