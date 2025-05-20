package homePageObjectsLesson6_7;

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
                .setDataOfBirth("30", "April", "2025")
                .setSubjects("Math")
                .setHobbies()
                .addPicture("prt.png")
                .setAddress("г. Пенза, ул. Щербакова 89")
                .setState("NCR")
                .setCiti("Delhi")
                .submitClick()
                // проверки
                .checkResult("Student Name", "Maria Grishina")
                .checkResult("Student Email", "Mariann@inbox.com")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "9603447567")
                .checkResult("Date of Birth", "30 April,2025")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports, Reading, Music")
                .checkResult("Picture", "prt.png")
                .checkResult("Address", "г. Пенза, ул. Щербакова 89")
                .checkResult("State and City", "NCR Delhi");

    }
    @Test
    void regFormMainTest() {
        registrationPage
                .openPage()
                .setFirstName("Maria")
                .setLastName("Grishina")
                .setGender("Female")
                .setUserNumber("9603447567")
                .submitClick()
                .checkResult("Student Name", "Maria Grishina")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "9603447567");
    }
    @Test
        // неверный ввод номера телефона
    void regFormNegativeTest() {
        registrationPage
                .openPage()
                .setUserNumber("*************")
                .submitClick()
                .chekFieldError();
    }
}





