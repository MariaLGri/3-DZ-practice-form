package homePageObjectsLesson6_7;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegFormNewAnnotationsParamTest{
    @BeforeAll
    static void installСonfig() {
       Configuration.browserSize = "1920x1080"; // разрешение, ну это понятно
        Configuration.pageLoadStrategy = "eager"; // чтоб не ждать загрузки всего сайта , картинок и т.д
    }

     //Параметризированные тесты
    @ValueSource(strings = {
            "Путешествие по Японии"
    })
    @ParameterizedTest(name = "Проверка поиска видео по значению {0}, список не должен быть пустым ")
    @Tag("BLOCKER")
   void search1Test (String search1) {
        open("https://rutube.ru/");
        $(".wdp-search-line-module__input").setValue(search1).pressEnter();
        $(".search-filters-module__searchFilters").$(byText("Видео")).click();
        $$(".wdp-grid-module__gridWrapper div[aria-labelledby]").shouldBe(sizeGreaterThan(0));
        sleep(3000);

    }

    @CsvSource(value = {
            "London 1900|The City of London, London's" ,
            " Чужой 1979 год|Жанр: фантастика"
    }, delimiter = '|')
    @ParameterizedTest(name = "Проверка поиска видео по значению {0}, список ссылок не должен быть пустым, в одном из описаний должен содержаться текст {1}")
    @Tag("BLOCKER")
    public void search2Test(String searchQueryTest, String searchTextTest) {
        open("https://rutube.ru/");
        $(".wdp-search-line-module__input").setValue(searchQueryTest).pressEnter();
        String actualValue = $(".wdp-search-line-module__input").getAttribute("value");
        System.out.println("Фактический ввод: " + actualValue);  // Должно совпадать с searchQueryTest
        $(".search-filters-module__searchFilters").$(byText("Видео")).click();
        $$("div[aria-labelledby] a").shouldBe(sizeGreaterThan(0));
        $(".wdp-grid-module__grid").shouldHave(text(searchTextTest));

    }

    @CsvFileSource(resources = "/testData/searchFilm.csv", delimiter = '|')
    @ParameterizedTest(name = "Проверка поиска видео по значению {0}, список ссылок не должен быть пустым, в одном из описаний должен содержаться текст {1}(из файла .csv)")
    @Tag("BLOCKER")

    public void search3Test(String searchQueryTest, String searchTextTest) {
        open("https://rutube.ru/");
        $(".wdp-search-line-module__input").setValue(searchQueryTest).pressEnter();
        String actualValue = $(".wdp-search-line-module__input").getAttribute("value");
        System.out.println("Фактический ввод: " + actualValue);  // Должно совпадать с searchQueryTest
        $(".search-filters-module__searchFilters").$(byText("Видео")).click();
        $$("div[aria-labelledby] a").shouldBe(sizeGreaterThan(0));
        $(".wdp-grid-module__grid").shouldHave(text(searchTextTest));

    }

}





