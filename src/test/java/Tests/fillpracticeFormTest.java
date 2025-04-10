package Tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class fillpracticeFormTest {
    @BeforeAll
     static void beforeAll() {
        Configuration.browserSize = "1920x1080"; // разрешение, ну это понятно
        Configuration.pageLoadStrategy = "eager"; // чтоб не ждать загрузки всего сайта , картинок и т.д
        Configuration.baseUrl = "https://demoqa.com"; // выносим абсолютный адресс из опен
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }
    @Test
    void PracticeForm() {
        open("/automation-practice-form");
        $("#firstName").setValue("Maria");
        $("#lastName").setValue("Grishina");
        $("#userEmail").setValue("Mariann@inbox.com");
        $("#gender-radio-3").click();

        $("#submit").click();

        $("#output #name").shouldHave(text("Maria"));
        $("#output #email").shouldHave(text("maria@gmail.com"));
        $("#output #currentAddress").shouldHave(text("Some street 1"));
        $("#output #permanentAddress").shouldHave(text("Another street 1"));
    }

}
