package homePageObjectsLesson6_7;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;

import static io.qameta.allure.Allure.step;

public class RegFormNewRandomTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    RandomUtils randomUtils = new RandomUtils();
    @Test
    @Tag("first")
        void regFormTest()
    {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открытие и заполнение формы", () -> {
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
                .submitClick();
        });
                // проверки
        registrationPage .checkResult("Student Name", randomUtils.firstNameF+" "+randomUtils.lastNameF)
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





