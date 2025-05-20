package jankensLesson;
import homePageObjectsLesson6_7.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;

import static io.qameta.allure.Allure.step;

public class RegFormNewRandomJankensTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    RandomUtils randomUtils = new RandomUtils();
    @Test
    @DisplayName("Проверка регистрации на форме")
    //@Tag("first")
        void regFormTest()
    {

        step("Открытие формы регистрации", () -> {
             registrationPage
                .openPage();
        });
            step("Заполнение формы ", () -> {
                registrationPage .setFirstName(randomUtils.firstNameF)
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
        step("Проверяем корректность заполнения формы", () -> {
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
        });
    }
}





