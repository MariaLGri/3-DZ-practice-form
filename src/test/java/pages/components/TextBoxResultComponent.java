package pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebElementCondition;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TextBoxResultComponent {
    public void checkResultBox(){
    $("#output").shouldHave(text("""
Name:Maria Grishina

Email:Mariann@inbox.com

Current Address :г. Пенза, ул. Щербакова 89

Permananet Address :г. Пенза, ул. Щербакова 89
                        """));
    }

}