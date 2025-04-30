package dz_3_4_5.dz5;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class mainGitHubTest {

    @Test
    void searchSelenideCodeTest() {

        open("https://github.com");
        $$("button").findBy(text("Solutions")).hover();
        $$("a[href=\"https://github.com/enterprise\"]").find(text("Enterprises")).click();
        $(".application-main ").$("h1#hero-section-brand-heading").shouldHave(text("The AI-powered"));
    }

    @Test
    void DragDropTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        actions().moveToElement($("div#column-a")).clickAndHold().moveToElement($("div#column-b")).release().perform();
        $("#column-b").shouldHave(text("A"));
        $("#column-a").shouldHave(text("B"));


    }

//    @Test
//    void DragDropTwoTest() {
//        open("https://the-internet.herokuapp.com/drag_and_drop");
//        sleep(2000);
//
//        $("#column-b").dragAndDrop($("#column-b")); // ошибка несовместимые типы: SelenideElement невозможно преобразовать в DragAndDropOptions
//
//    }

}