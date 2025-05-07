package homePageObjectsLesson6;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static homePageObjectsLesson6.TestData.*;

public class RegFormTestDataTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    @Test
    void regFormTest() {
        registrationPage
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDataOfBirth(dataOfBirthDay, dataOfBirthMonth, dataOfBirthYear)
                .setSubjects(subjects)
                .setHobbies()
                .addPicture(picture)
                .setAddress(address)
                .setState(state)
                .setCiti(citi)
                .submitClick()
                // проверки
                .checkResult("Student Name", firstName+" "+lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth",dataOfBirthDay+" "+dataOfBirthMonth+","+dataOfBirthYear)
                .checkResult("Subjects", subjects)
                .checkResult("Hobbies", "Sports, Reading, Music")
                .checkResult("Picture", picture)
                .checkResult("Address", address)
                .checkResult("State and City", state+" "+citi);

    }
    @Test
    void regFormMainTest() {
        registrationPage
                .openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(userNumber)
                .submitClick()
                .checkResult("Student Name", firstName+" "+lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber);
    }
    @Test
        // неверный ввод номера телефона
    void regFormNegativeTest() {
        registrationPage
                .openPage()
                .setUserNumber(userNumberNigativ)
                .submitClick()
                .chekFieldError();
    }
}





