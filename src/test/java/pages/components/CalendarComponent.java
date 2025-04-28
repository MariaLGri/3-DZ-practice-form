package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarComponent {
    public void setData(String day, String month, String year ){
        $("#dateOfBirthInput").click(); //кликаем на поле чтобы активировать календарь
        $(".react-datepicker__month-select").selectOption("May"); // выбор в календаре мясяца
        $(".react-datepicker__year-select").selectOption("1900"); //выбор года
        $$("div.react-datepicker__day").findBy(text("22")).click();// возрат полученной коллекции, ищем в ней 22 и кликаем на число даты, разобрать для понимания


    }

}
