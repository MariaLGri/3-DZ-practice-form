package pages;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.TablCheckResultComponent;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
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
     public RegistrationPage openPage(){
    open("/automation-practice-form");
    executeJavaScript("$('#fixedban').remove()"); // убирает рекламу
    executeJavaScript("$('footer').remove()"); // убирает рекламу
    return this;
}

    public RegistrationPage setFirstName(String value){
        firstNameInput.scrollIntoView(true).setValue(value);
        return this;
    }
    public RegistrationPage setLastName(String value){
    lastNameInput.scrollIntoView(true).setValue(value);
        return this;
    }
    public RegistrationPage setEmail(String value){
        emailInput.scrollIntoView(true).setValue(value);
        return this;
    }
    public RegistrationPage setGender(String value){
        genterWrapper.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setUserNumber(String value) {
        userNumberInput.scrollIntoView(true).setValue(value);
        return this;
    }
    public RegistrationPage setDataOfBirth(String day, String month, String year ) {
    new CalendarComponent().setData(day,month,year);
        calendarInput.click(); //кликаем на поле чтобы активировать календарь
        calendarComponent.setData(day,month,year);
        return this;
    }
    public RegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage setHobbies() {
        hobbies_1.click();
        hobbies_2.click();
        hobbies_3.click();
        return this;
     }
    public RegistrationPage addPicture(String imagePath){
        picture.uploadFromClasspath(imagePath);
        return this;
        }
    public RegistrationPage setAddress(String value){
        address.scrollIntoView(true).setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage setState(String value){
        selectState.scrollIntoView(true).setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage setCiti(String value){
        selectCiti.scrollIntoView(true).setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage submitClick() {
        buttonclick.scrollIntoView(true).click();
        return this;
    }
//проверка
     public RegistrationPage checkResult (String key, String expectedValue){
        new TablCheckResultComponent().checkResultTab(key, expectedValue);
         return this;
      }
      //негативная проверка правильности ввода номера телефона
    public RegistrationPage chekFieldError(){
        userNumberInput.shouldHave(cssClass("form-control"));
        userNumberInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
        return this;
}
}
