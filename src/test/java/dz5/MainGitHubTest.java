package dz5;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class MainGitHubTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080"; // разрешение, ну это понятно
        Configuration.pageLoadStrategy = "eager"; // чтоб не ждать загрузки всего сайта , картинок и т.д

    }
    @Test
    void searchSelenideCodeTest(){
        open("https://github.com");
        $$("button").findBy(text("Solutions")).hover();
        $$("a[href=\"https://github.com/enterprise\"]").find(text("Enterprises")).click();
        $(".application-main ").$("h1#hero-section-brand-heading").shouldHave(text("The AI-powered"));

    }

}