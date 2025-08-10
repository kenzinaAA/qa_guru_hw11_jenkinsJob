package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;
import static io.qameta.allure.Allure.step;

@Tag("demoqa")
public class PracticeFormWithPageObjectsTests extends TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage();
    @Test
    @DisplayName("Проверка заполнения всех полей")
    void practiceFormAllFields() {
        step("Открываем форму регистрации", () -> {
            practiceFormPage.openPage();
        });
        step("Закрываем банеры, если всплыли", () -> {
                    practiceFormPage.removeBanners();
                });
        step("Заполняем все поля формы и отправляем", () -> {
            practiceFormPage.setFirstName("Anastasiia")
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
        });
        step("Проверяем заполненную форму", () -> {
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
        });
    }

    @Test
    @DisplayName("Проверка заполнения только обязательных полей")
    void practiceFormMinFields() {
        step("Открываем форму регистрации", () -> {
            practiceFormPage.openPage();
        });

        step("Заполняем обязательные поля формы регистрации и отправляем", () -> {
            practiceFormPage.removeBanners()
                .setFirstName("Anastasiia")
                .setLastName("Kenzina")
                .setGender("Female")
                .setUserNumber("9025111826")
                .submitForm();
        });
        step("Проверяем заполненную форму", () -> {
            practiceFormPage.checkResult("Student Name", "Anastasiia Kenzina")
                    .checkResult("Gender", "Female")
                    .checkResult("Mobile", "9025111826");
        });
    }

    @Test
    @DisplayName("Проверка заполнения не всех обязательных полей")
    void practiceFormFailedTest() {
        step("Открываем форму регистрации", () -> {
            practiceFormPage.openPage();
        });

        step("Заполняем не все обязательные поля формы регистрации и пытаемся отправить", () -> {
                    practiceFormPage.removeBanners()
                            .setFirstName("Anastasiia")
                            .setLastName("Kenzina")
                            .setUserNumber("9025111826")
                            .submitForm();
        });

        step("Проверяем, что данные не отправились и окно с заполненной формой не появилось", () -> {
            practiceFormPage.checkResultForNegative("Student Name")
                    .checkResultForNegative("Mobile");
        });
    }
}