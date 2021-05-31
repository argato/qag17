package tests;

import static com.codeborne.selenide.Selenide.refresh;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class CartTestsUI extends TestBaseUI {

  private final ServiceUI serviceUI = new ServiceUI();
  private final ServiceAPI serviceAPI = new ServiceAPI();

  @Test
  @DisplayName("Проверка в UI счетчика корзины авторизованного пользователя после добавления товара в корзину по API")
  @Tag("UI")
  void checkUICartCounterAfterAPIRequestTest() {
    String cookies = serviceUI.getCookieAfterWebAuth();
    int result = serviceUI.getCurrentValueInCartUI() + 1;
    serviceAPI.addToCart(cookies);
    refresh();
    serviceUI.checkCartCounter(result);
  }

  @Test
  @DisplayName("Проверка счетчика корзины авторизованного пользователя после добавления товара в корзину по UI")
  @Tag("UI")
  void checkCartCounterUITest() {
    serviceUI.authorizationUI();
    int result = serviceUI.getCurrentValueInCartUI() + 1;
    serviceUI.addToCart("build-your-own-expensive-computer-2");
    serviceUI.checkCartCounter(result);
  }
}
