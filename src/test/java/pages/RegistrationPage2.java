package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.TablCheckResultComponent;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage2 {
    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genterWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput =  $("#subjectsInput"),
            hobbies_1 =  $("label[for=hobbies-checkbox-1]" ),
            hobbies_2 =  $("label[for=hobbies-checkbox-2]" ),
            hobbies_3 =  $(" label[for=hobbies-checkbox-3]"),
            picture = $("#uploadPicture"),
            address=  $("#currentAddress"),

            selectState = $("#react-select-3-input"),
            selectCiti = $("#react-select-4-input"),
            buttonclick =$("#submit");

     CalendarComponent calendarComponent= new CalendarComponent();
     public RegistrationPage2 openPage(){
    open("/automation-practice-form");
    executeJavaScript("$('#fixedban').remove()"); // убирает рекламу
    executeJavaScript("$('footer').remove()"); // убирает рекламу
    return this;
}

    public RegistrationPage2 setFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }
    public RegistrationPage2 setLastName(String value){
    lastNameInput.setValue(value);
        return this;
    }
    public RegistrationPage2 setEmail(String value){
        emailInput.setValue(value);
        return this;
    }
    public RegistrationPage2 setGender(String value){
        genterWrapper.$(byText(value)).click();
        return this;
    }
    public RegistrationPage2 setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }
    public RegistrationPage2 setDataOfBirth(String day, String month, String year ) {
    new CalendarComponent().setData(day,month,year);
        calendarInput.click(); //кликаем на поле чтобы активировать календарь
        calendarComponent.setData(day,month,year);
        return this;
    }
    public RegistrationPage2 setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage2 setHobbies() {
        hobbies_1.click();
        hobbies_2.click();
        hobbies_3.click();
        return this;
     }
    public RegistrationPage2 addPicture(String imagePath){
        picture.uploadFromClasspath(imagePath);
        return this;
        }
    public RegistrationPage2 setAddress(String value){
        address.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage2 setState(String value){
        selectState.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage2 setCiti(String value){
        selectCiti.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage2 submitClick() {
        buttonclick.click();
        return this;
    }
//проверка
     public RegistrationPage2 checkResult (String key, String expectedValue){
        new TablCheckResultComponent().checkResultTab(key, expectedValue);
         return this;
      }
      //негативная проверка правильности ввода номера телефона
    public RegistrationPage2 chekFieldError(){
        userNumberInput.shouldHave(cssClass("form-control"));
        userNumberInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        return this;
}
}
