package homePageObjectsLesson6_7;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;
public class RegFormNewRandomTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    RandomUtils randomUtils = new RandomUtils();
    @Test
    void regFormTest() {
             registrationPage
                .openPage()
                .setFirstName(randomUtils.firstNameF)
                .setLastName(randomUtils.lastNameF)
                .setEmail(randomUtils.userEmailF)
                .setGender(randomUtils.genterWrapper)
                .setUserNumber(randomUtils.ruPhone)
                .setDataOfBirth(randomUtils.BirthInput, randomUtils.monthOfBirthInput, randomUtils.yearOfBirthInput)
                .setSubjects(randomUtils.subjects)
                .setHobbies()
                .addPicture(randomUtils.piktureF)
                .setAddress(randomUtils.streetAddress)
                .setState(randomUtils.state)
                .setCiti(randomUtils.city)
                .submitClick()
                // проверки
                .checkResult("Student Name", randomUtils.firstNameF+" "+randomUtils.lastNameF)
                .checkResult("Student Email", randomUtils.userEmailF)
                .checkResult("Gender", randomUtils.genterWrapper)
                .checkResult("Mobile", randomUtils.ruPhone)
                .checkResult("Date of Birth", randomUtils.BirthInput+" "+randomUtils.monthOfBirthInput+","+randomUtils.yearOfBirthInput)
                .checkResult("Subjects", randomUtils.subjects)
                .checkResult("Hobbies", randomUtils.hobbiesInput)
                .checkResult("Picture", randomUtils.piktureF)
                .checkResult("Address", randomUtils.streetAddress)
                .checkResult("State and City", randomUtils.state +" "+randomUtils.city);

    }
    @Test
    void regFormMainTest() {
        registrationPage
                .openPage()
                .setFirstName(randomUtils.firstNameF)
                .setLastName(randomUtils.lastNameF)
                .setGender(randomUtils.genterWrapper)
                .setUserNumber(randomUtils.ruPhone)
                .submitClick()
                .checkResult("Student Name", randomUtils.firstNameF+" "+randomUtils.lastNameF)
                .checkResult("Gender", randomUtils.genterWrapper)
                .checkResult("Mobile", randomUtils.ruPhone);
    }
    @Test
        // неверный ввод номера телефона
    void regFormNegativeTest() {
        registrationPage
                .openPage()
                .setUserNumber(randomUtils.randomLetters)
                .submitClick()
                .chekFieldError();
    }
}





