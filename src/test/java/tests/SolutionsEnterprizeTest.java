package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class SolutionsEnterprizeTest {

    @BeforeAll
    static void BeforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true;
        //Configuration.timeout = 5000;
    }

@Test

    void solutionsEnterprizeTest() {

    //открываем страницу github
    open("/");

    //находим раздел меню Solutions и наводим курсор
    $(".HeaderMenu-nav").$(byText("Solutions")).hover();

    //в раскрывшемся меню выбираем раздел Enterprize
    $("ul.list-style-none").$(byText("Enterprises")).click();

    //проверяем, что загрузилась нужная страница
    webdriver().shouldHave(urlContaining("/enterprise"));
    //проверяем заголовок на странице
    $(".application-main h1").shouldBe(visible).$(byText("The AI-powered developer platform"));
}
}
