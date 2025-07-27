package tests;

import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormWithPageObjectsTests extends TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    void practiceFormAllFields() {
        practiceFormPage.openPage()
                .setFirstName("Anastasiia")
                .setLastName("Kenzina")
                .setEmail("kenzina.aa@yandex.ru")
                .setGender("Female")
                .setUserNumber("9025111826")
                .setDateOfBirth( "18","October", "1994" )
                .setSubjects("Math")
                .setHobbies("Sports")
                .setUploadPicture("photo.jpg")
                .setCurrentAddress("Some address 1")
                .setState("NCR")
                .setCity("Delhi")
                .submitForm();
        practiceFormPage.checkResult("Student Name", "Anastasiia Kenzina")
                .checkResult("Student Email", "kenzina.aa@yandex.ru")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "9025111826")
                .checkResult("Date of Birth", "18 October,1994")
                .checkResult("Subjects", "Math")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "photo.jpg")
                .checkResult("Address", "Some address 1")
                .checkResult("State and City", "NCR Delhi");

    }

    @Test
    void practiceFormMinFields() {
        practiceFormPage.openPage()
                .setFirstName("Anastasiia")
                .setLastName("Kenzina")
                .setGender("Female")
                .setUserNumber("9025111826")
                .submitForm();
        practiceFormPage.checkResult("Student Name", "Anastasiia Kenzina")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "9025111826");

    }

    @Test
    void practiceFormFailedTest() {
        practiceFormPage.openPage()
                .setFirstName("Anastasiia")
                .setLastName("Kenzina")
                .setUserNumber("9025111826")
                .submitForm();
        practiceFormPage.checkResultForNegative("Student Name", "Anastasiia Kenzina")
                .checkResultForNegative("Mobile", "9025111826");

    }

}