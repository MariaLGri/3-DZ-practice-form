package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genterWrapper = $("#genterWrapper"),
            userNumber = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput");
            CalendarComponent calendarComponent= new CalendarComponent();
    SelenideElement subjectsInput =  $("#subjectsInput"),
            hobbies_1 =  $("label[for=hobbies-checkbox-1]" ),
            hobbies_2 =  $("label[for=hobbies-checkbox-2]" ),
            hobbies_3 =  $(" label[for=hobbies-checkbox-3]");




public RegistrationPage openPage(){
    open("/automation-practice-form");
    executeJavaScript("$('#fixedban').remove()"); // убирает рекламу
    executeJavaScript("$('footer').remove()"); // убирает рекламу
    return this;
}

    public RegistrationPage setFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setLastName(String value){
    lastNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setEmail(String value){
        emailInput.setValue(value);
        return this;
    }
    public RegistrationPage setGender(String value){
        genterWrapper.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setUserNumber(String value) {
        userNumber.setValue(value);
        return this;
    }
    public RegistrationPage setDataOfBirth(String day, String month, String year ) {
    new CalendarComponent().setData(day,month,year);
        calendarInput.click(); //кликаем на поле чтобы активировать календарь
        calendarComponent.setData(day,month,year);
        return this;
    }

    public RegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value);
        return this;
    }

    public RegistrationPage setHobbies() {
        hobbies_1.click();
        hobbies_2.click();
        hobbies_3.click();
        return this;



//проверки
//    public RegistrationPage chekResalt (String key, String value){
//        $$(".table-responsive").findBy(text(key)).shouldHave(text(value));
//        return this;
  }
}
