package pages.components;

import com.codeborne.selenide.ElementsCollection;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

public class TablCheckResultComponent {
    private final ElementsCollection
            table = $$(".table-responsive");
    public void checkResultTab(String key, String expectedValue)
    {
table.findBy(text(key)).shouldHave(text(expectedValue));
        
    }

}



