package tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import com.codeborne.selenide.Configuration;

import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void basicBrowserSettings() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }
    @Test
    void practiceFormTests() {
        open("/automation-practice-form");

        //вводим имя
        $("#firstName").setValue("Anastasiia");
        //вводим фамилию
        $("#lastName").setValue("Kenzina");
        //вводим email
        $("#userEmail").setValue("kenzina.aa@yandex.ru");
        //выбираем женский пол
        $("#genterWrapper").$(byText("Female")).click();
        //вводим телефон
        $("#userNumber").setValue("9025111826");
        //открываем выпадашку с календарем
        $("#dateOfBirthInput").click();
        //выбираем месяц
        $(".react-datepicker__month-select").selectOption("October");
        //выбираем год
        $(".react-datepicker__year-select").selectOption("1994");
        //выбираем день
        $(".react-datepicker__day.react-datepicker__day--018").click();

        //вводим comp, появляется подсказка
        $("#subjectsInput").setValue("comp");
        //выбираем "информатику"
        $$(".subjects-auto-complete__option").findBy(text("Computer Science")).click();

        //выбираем хобби спорт
        $("#hobbiesWrapper").$(byText("Sports")).click();

        //загружаем картинку
        $("#uploadPicture").uploadFromClasspath("photo.jpg");

        //вводим адрес
        $("#currentAddress").setValue("Russia, Irkutsk");

        //выбираем штат и город
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();

        //отправляем заполненную форму
        $("#submit").click();

        //проверка текста в форме после отправки
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(Condition.text("Student Name Anastasiia Kenzina"));
        $(".table-responsive").shouldHave(Condition.text("Student Email kenzina.aa@yandex.ru"));
        $(".table-responsive").shouldHave(Condition.text("Gender Female"));
        $(".table-responsive").shouldHave(Condition.text("Mobile 9025111826"));
        $(".table-responsive").shouldHave(Condition.text("Date of Birth 18 October,1994"));
        $(".table-responsive").shouldHave(Condition.text("Subjects Computer Science"));
        $(".table-responsive").shouldHave(Condition.text("Hobbies Sports"));
        $(".table-responsive").shouldHave(Condition.text("Picture photo.jpg"));
        $(".table-responsive").shouldHave(Condition.text("Address Russia, Irkutsk"));
        $(".table-responsive").shouldHave(Condition.text("State and City NCR Delhi"));
    }
}
