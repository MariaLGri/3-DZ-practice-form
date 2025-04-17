package testDZ4;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class SelenidePageTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080"; // разрешение, ну это понятно
        Configuration.pageLoadStrategy = "eager"; // чтоб не ждать загрузки всего сайта , картинок и т.д
        Configuration.baseUrl = "https://github.com"; // выносим абсолютный адресс из опен
}
      @Test
void searchSelenideCodeTest(){
          open("/selenide/selenide");
// ищем вкладку и кликаем на неё
         $(".UnderlineNav-body").$(byText("Wiki")).click();
          //Возращаем все элементы ссылок и ищем ту которая содержит текст, проверяем что текст видимый, кликаем
          $$("a.internal.present").findBy(text("Soft assertions")).shouldBe(visible).click();
// ищем по тексту и проверим , что его видно
         $(byText( "3. Using JUnit5 extend test class:")).shouldBe(visible)
                 .parent().sibling(0)// возращаемся вверх , к родителю и исем вниз сестренский ближний (нулевой) элемент
                 .$("pre")
                 .shouldHave(text("@ExtendWith({SoftAssertsExtension.class}) class Tests {\n" +
                                 "  @Test\n" +
                                 "  void test() {\n" +
                                 "    Configuration.assertionMode = SOFT;\n" +
                                 "    open(\"page.html\");\n" +
                                 "    $(\"#first\").should(visible).click();\n" +
                                 "    $(\"#second\").should(visible).click();\n" +
                                 "  }\n" +
                                 "}"
                  ));
          $("#wiki-body").$(".markdown-body").shouldHave(
                  text("@ExtendWith({SoftAssertsExtension.class})\n" +
                          "class Tests {\n" +
                          "  @Test\n" +
                          "  void test() {\n" +
                          "    Configuration.assertionMode = SOFT;\n" +
                          "    open(\"page.html\");\n" +
                          "\n" +
                          "    $(\"#first\").should(visible).click();\n" +
                          "    $(\"#second\").should(visible).click();\n" +
                          "  }\n" +
                          "}"));
      }
}