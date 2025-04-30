package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.TablCheckResultComponent;
import pages.components.TextBoxResultComponent;
//import pages.components.TextBoxResultComponent;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxPage {
    private SelenideElement
            fullNameInput = $("#userName"),
            emailInput = $ ("#userEmail"),
            currentAddress = $ ("#currentAddress"),
            permanentAddress = $ ("#permanentAddress"),
            buttonclick =$("#submit");
TextBoxResultComponent textBoxResultComponent = new TextBoxResultComponent();
public TextBoxPage openPage(){
    open("/text-box");
    executeJavaScript("$('#fixedban').remove()"); // убирает рекламу
    executeJavaScript("$('footer').remove()"); // убирает рекламу
    return this;
}
public TextBoxPage setFullName(String  value){
fullNameInput.setValue(value);
return this;
}
    public TextBoxPage setEmail(String  value){
        emailInput.setValue(value);
        return this;
    }
    public TextBoxPage setCurrentAddress(String  value){
        currentAddress.setValue(value);
        return this;
    }
    public TextBoxPage setPermanentAddress(String  value){
        permanentAddress.setValue(value);
        return this;
    }
    public TextBoxPage submitClick() {
        buttonclick.click();
        return this;
    }
//проверка
    public void checkResultTextBox (){
        new TextBoxResultComponent().checkResultBox();
    }
}
