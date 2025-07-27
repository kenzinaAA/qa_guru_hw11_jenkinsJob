package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {
    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; //default 4000
    }

    @Test
    void fillFormTest() {
        open("/text-box");
        $("#userName").setValue("Anastasiia Kenzina");
        $("#userEmail").setValue("kenzina.aa@yandex.ru");
        $("#currentAddress").setValue("Irkutsk");
        $("#permanentAddress").setValue("Irkutsk");
        $("#submit").pressEnter();


        $("#output #name").shouldHave(text("Anastasiia Kenzina"));
        $("#output #email").shouldHave(text("kenzina.aa@yandex.ru"));
        $("#output #currentAddress").shouldHave(text("Irkutsk"));
        $("#output #permanentAddress").shouldHave(text("Irkutsk"));
    }
}
