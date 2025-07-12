package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SoftAssertionsJUnit5Tests {
    @BeforeAll
    static void BeforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true;
        //Configuration.timeout = 5000;
    }

    @Test
    void SoftAssertionsSearchTest() {

        //открываем страницу selenide в github
        open("/selenide/selenide");

        //переходим в раздел Wiki проекта
        $("#wiki-tab").click();

        //находим страницу SoftAssertions
        $("#wiki-pages-filter").setValue("SoftAssertions");

        //открываем страницу SoftAssertions
        $(byText("SoftAssertions")).click();

        //проверяем, что внутри есть пример кода для JUnit5
        $("#wiki-body").shouldHave(text(
                "@ExtendWith({SoftAssertsExtension.class})\n" +
                        "class Tests {\n" +
                        "  @Test\n" +
                        "  void test() {\n" +
                        "    Configuration.assertionMode = SOFT;\n" +
                        "    open(\"page.html\");\n" +
                        "\n" +
                        "    $(\"#first\").should(visible).click();\n" +
                        "    $(\"#second\").should(visible).click();\n" +
                        "  }\n" +
                        "}"));

    }
}
