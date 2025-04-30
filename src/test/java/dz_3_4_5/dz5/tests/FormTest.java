package dz_3_4_5.dz5.tests;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormTest {
    @BeforeAll
     static void beforeAll() {
        Configuration.browserSize = "1920x1080"; // разрешение, ну это понятно
        Configuration.pageLoadStrategy = "eager"; // чтоб не ждать загрузки всего сайта , картинок и т.д
        Configuration.baseUrl = "https://demoqa.com"; // выносим абсолютный адресс из опен
    }
    @AfterEach
    void afterEach() {
        Selenide.closeWebDriver();
    }


    @Test
    void practiceFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()"); // убирает рекламу
        executeJavaScript("$('footer').remove()"); // убирает рекламу


        $("#firstName").setValue("Maria");
        $("#lastName").setValue("Grishina");
        $("#userEmail").setValue("Mariann@inbox.com");
        $("#genterWrapper").$(byText("Other")).click(); //выбор редио
        $("#userNumber").setValue("9603447567");

        $("#dateOfBirthInput").click(); //кликаем на поле чтобы активировать календарь
        $(".react-datepicker__month-select").selectOption("May"); // выбор в календаре мясяца
        $(".react-datepicker__year-select").selectOption("1900"); //выбор года
        $$("div.react-datepicker__day").findBy(text("22")).click();// возрат полученной коллекции, ищем в ней 22 и кликаем на число даты, разобрать для понимания

        $("#subjectsInput").setValue("a").pressEnter();

        $("label[for=hobbies-checkbox-1]").click();
        $("label[for=hobbies-checkbox-2]").click();
        $("label[for=hobbies-checkbox-3]").click();
        $("#uploadPicture").uploadFromClasspath("prt.JPG");
        $("#currentAddress").setValue("г. Пенза, ул. Щербакова 89").pressEnter();

        $("#react-select-3-input").setValue("n").pressEnter();
        $("#react-select-4-input").setValue("a").pressEnter();
        $("#submit").click();

        $$(".table-responsive").findBy(text("Student Name")).shouldHave(text("Maria Grishina")); // возврат, поиск, проверка (сложно!!!)
        $$(".table-responsive").findBy(text("Student Email")).shouldHave(text("Mariann@inbox.com"));
        $$(".table-responsive").findBy(text("Gender")).shouldHave(text("Other"));
        $$(".table-responsive").findBy(text("Mobile")).shouldHave(text("9603447567"));
        $$(".table-responsive").findBy(text("Date of Birth")).shouldHave(text("22 May,1900"));
        $$(".table-responsive").findBy(text("Subjects")).shouldHave(text("Maths"));
        $$(".table-responsive").findBy(text("Hobbies")).shouldHave(text("Sports, Reading, Music"));
        $$(".table-responsive").findBy(text("Picture")).shouldHave(text("prt.JPG"));
        $$(".table-responsive").findBy(text("Address")).shouldHave(text("г. Пенза, ул. Щербакова 89"));
        $$(".table-responsive").findBy(text("State and City")).shouldHave(text("NCR Gurgaon"));
        $("#closeLargeModal").click();// закрытие формы

    }
}
