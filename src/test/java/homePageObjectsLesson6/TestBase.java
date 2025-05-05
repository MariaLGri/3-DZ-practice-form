package homePageObjectsLesson6;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    static void installСonfigurations() {
        Configuration.browserSize = "1920x1080"; // разрешение, ну это понятно
        Configuration.pageLoadStrategy = "eager"; // чтоб не ждать загрузки всего сайта , картинок и т.д
        Configuration.baseUrl = "https://demoqa.com"; // выносим абсолютный адресс из опен
    }
    @AfterEach
    void afterEachexEcute() {
        Selenide.closeWebDriver();
    }

}
