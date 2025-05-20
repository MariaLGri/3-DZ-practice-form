package homePageObjectsLesson6_7;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    static void installСonfiguration() {
        Configuration.browserSize = "1920x1080"; // разрешение, ну это понятно
        Configuration.pageLoadStrategy = "eager"; // чтоб не ждать загрузки всего сайта , картинок и т.д
        Configuration.baseUrl = "https://demoqa.com"; // выносим абсолютный адресс из опен
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub"; //хром на стороннем сервисе
    }
    @AfterEach
    void webDriverTearDown() {
        Selenide.closeWebDriver();
    }

}
