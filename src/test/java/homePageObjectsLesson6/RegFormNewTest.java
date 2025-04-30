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
                .setHobbies()
                .addPicture("prt.JPG")
                .setAddress("г. Пенза, ул. Щербакова 89")
                .setState("n")
                .setCiti("a")
                .submitClick()
                // проверки
                .checkResult("Student Name", "Maria Grishina")
                .checkResult("Student Email", "Mariann@inbox.com")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "9603447567")
                .checkResult("Date of Birth", "22 May,1900")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports, Reading, Music")
                .checkResult("Picture", "prt.JPG")
                .checkResult("Address", "г. Пенза, ул. Щербакова 89")
                .checkResult("State and City", "NCR Gurgaon");

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





