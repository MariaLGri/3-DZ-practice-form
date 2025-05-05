package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarComponent {
    public void setData(String day, String month, String year ){
        $("#dateOfBirthInput").click(); //кликаем на поле чтобы активировать календарь
        $(".react-datepicker__month-select").selectOption(month); // выбор в календаре мясяца
        $(".react-datepicker__year-select").selectOption(year); //выбор года
        $$("div.react-datepicker__day:not(.react-datepicker__day--outside-month)").findBy(text(day)).click();


    }

}
