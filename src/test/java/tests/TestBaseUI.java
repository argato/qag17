package tests;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static helper.AttachmentsHelper.attachPageSource;
import static helper.AttachmentsHelper.attachScreenshot;
import static helper.AttachmentsHelper.attachVideo;
import static helper.DriverHelper.configureDriver;
import static helper.DriverHelper.getConsoleLogs;
import static helper.DriverHelper.getSessionId;
import static helper.DriverHelper.isVideoOn;

import helper.AttachmentsHelper;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({AllureJunit5.class})
public class TestBaseUI extends TestBase {

  @BeforeAll
  static void setUp() {
    configureDriver();
  }

  @AfterEach
  void afterTest() {
    String sessionId = getSessionId();
    attachScreenshot("Last screenshot");
    attachPageSource();
    AttachmentsHelper.attachAsText("Browser console logs", getConsoleLogs());
    if (isVideoOn()) {
      attachVideo(sessionId);
    }
    closeWebDriver();
  }

}
