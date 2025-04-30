package dz_3_4_5.dz5.testDZ4;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class SelenidePageTest {
    @BeforeAll
    static void beforeConfig() {
        Configuration.pageLoadStrategy = "eager"; // чтоб не ждать загрузки всего сайта , картинок и т.д
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void searchSelenideCodeTest() {
        open("https://github.com/selenide/selenide");
        $(".UnderlineNav-body").$(byText("Wiki")).click();
        $("[data-filterable-for='wiki-pages-filter']").$(withText("more pages…")).click();
        $("[data-filterable-for='wiki-pages-filter']").$(byText("SoftAssertions")).shouldBe(visible).click();
        $(byText("3. Using JUnit5 extend test class:")).shouldBe(visible).parent().sibling(0).$("pre").shouldHave(text("""
                @ExtendWith({SoftAssertsExtension.class})
                class Tests {
                  @Test
                  void test() {
                    Configuration.assertionMode = SOFT;
                    open("page.html");
                                                   
                    $("#first").should(visible).click();
                    $("#second").should(visible).click();
                  }
                }
                """
        ));

        $("#wiki-body").$(".markdown-body").shouldHave(text("""
                  class Tests {
                  @RegisterExtension 
                  static SoftAssertsExtension softAsserts = new SoftAssertsExtension();

                  @Test
                  void test() {
                    Configuration.assertionMode = SOFT;
                    open("page.html");

                    $("#first").should(visible).click();
                    $("#second").should(visible).click();
                  }
                }
                                          """
        ));
    }


}