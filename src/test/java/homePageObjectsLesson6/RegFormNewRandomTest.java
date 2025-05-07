package homePageObjectsLesson6;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.util.Locale;

public class RegFormNewRandomTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    @Test
    void regFormTest() {
        Faker faker = new Faker(new Locale("en-GB"));

        String firstNameF = faker.name().firstName();
        String lastNameF = faker.name().lastName();
        String userEmailF = faker.internet().emailAddress();
        String streetAddress = faker.address().streetAddress();
        String gender = faker.bool().bool();

        registrationPage
                .openPage()
                .setFirstName(firstNameF)
                .setLastName(lastNameF)
                .setEmail(userEmailF)
                .setGender(gender)
                .setUserNumber("9603447567")
                .setDataOfBirth("30", "April", "2025")
                .setSubjects("a")
                .setHobbies()
                .addPicture("prt.JPG")
                .setAddress(streetAddress)
                .setState("NCR")
                .setCiti("a")
                .submitClick()
                // проверки
                .checkResult("Student Name", "Maria Grishina")
                .checkResult("Student Email", "Mariann@inbox.com")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "9603447567")
                .checkResult("Date of Birth", "30 April,2025")
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





