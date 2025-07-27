package pages.components;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultsTable {

    public static void checkResultsTable(String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));
    }

    public static void checkResultsTableForNegative(String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldNotBe(exist);
    }
}
