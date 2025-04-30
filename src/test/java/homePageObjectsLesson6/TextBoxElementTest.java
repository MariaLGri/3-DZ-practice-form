package homePageObjectsLesson6;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;
public class TextBoxElementTest extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();
    @Test
    void textBoxtest(){
       textBoxPage.openPage()
               .setFullName("Maria Grishina")
               .setEmail("Mariann@inbox.com")
               .setCurrentAddress("г. Пенза, ул. Щербакова 89")
               .setPermanentAddress("г. Пенза, ул. Щербакова 89")
               .submitClick()
       //проверка
        .checkResultTextBox();
    }

}
