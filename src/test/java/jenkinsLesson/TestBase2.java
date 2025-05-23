package jenkinsLesson;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase2 {

    String selenoidUserLogin = System.getProperty("selenoidUserLogin", "user1");
    String selenoidUserPassword = System.getProperty("selenoidUserPassword", "1234");
    String selenoidUrl = System.getProperty(
            "selenoidUrl", "selenoid.autotests.cloud");
    static String browser = System.getProperty("browser", "chrome");
    static String browserVersion = System.getProperty("browserVersion", "136.0.7");
    static String browserSize = System.getProperty("browserSize", "1920x1080");
    @BeforeAll
    static void installСonfiguration() {

        Configuration.browser = browser;
        Configuration.browserVersion = browserVersion;
        Configuration.browserSize = browserSize;

        Configuration.pageLoadStrategy = "eager"; // чтоб не ждать загрузки всего сайта , картинок и т.д
        Configuration.baseUrl = "https://demoqa.com"; // выносим абсолютный адресс из опен
       Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub"; //хром на стороннем сервисе
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
// добавить видеозапись с экрана
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }
    @AfterEach

    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        //Selenide.closeWebDriver();
    }
}
