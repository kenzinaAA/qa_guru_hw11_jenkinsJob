package tests;

import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

import static data.TestDataPracticeForm.*;

public class PracticeFormWithFakerTests extends TestBase {
    PracticeFormPage practiceFormPage = new PracticeFormPage();
    @Test
    void practiceFormAllFields() {
        practiceFormPage.openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(phoneNumber)
                .setDateOfBirth(dayOfBirth,monthOfBirth,yearOfBirth)
                .setSubjects(subject)
                .setHobbies(hobby)
                .setUploadPicture(picture)
                .setCurrentAddress(address)
                .setState(state)
                .setCity(city)
                .submitForm();
        practiceFormPage.checkResult("Student Name", fullName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNumber)
                .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", picture)
                .checkResult("Address", address)
                .checkResult("State and City", stateAndCity);

    }

    @Test
    void practiceFormMinFields() {
        practiceFormPage.openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(phoneNumber)
                .submitForm();
        practiceFormPage.checkResult("Student Name", fullName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNumber);

    }

    @Test
    void practiceFormFailedTest() {
        practiceFormPage.openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserNumber(phoneNumber)
                .submitForm();
        practiceFormPage.checkResultForNegative("Student Name")
                .checkResultForNegative("Mobile");

    }

}