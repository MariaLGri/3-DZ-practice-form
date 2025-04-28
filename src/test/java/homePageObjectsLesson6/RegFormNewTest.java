package homePageObjectsLesson6;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegFormNewTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void regFormTest() {
        registrationPage
                .openPage()
                .setFirstName("Maria")
                .setLastName("Grishina")
                .setEmail("Mariann@inbox.com")
                .setGender("Other")
                .setUserNumber("9603447567")
                .setDataOfBirth("22", "May", "1900")
                .setSubjects("a")
                .setHobbies();

//проверки
//        registrationPage.chekResalt("Student Name", "Maria Grishina" );
    }
//subjectsWrapper
}





