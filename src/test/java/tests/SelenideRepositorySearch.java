import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch {

    @BeforeAll
    static void BeforeAll(){
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
    }
    @Test
    void ShouldFindSelenideRepositoryAtTheTop(){

        // открыть главную страницу
        open("https://github.com/");
        // ввести в поле поиска selenide и нажать enter
        $(".placeholder").$(byText("Search or jump to...")).click();
        $("#query-builder-test").setValue("selenide").pressEnter();
        // кликнуть на первый репозиторий из списка найденных
        $$("[data-testid='results-list']").first().$("a").click(); //команда через $$
        // проверка: заголовок selenide/selenide
        $("#repository-container-header").$("a[rel='author']").shouldHave(Condition.text("selenide"));

    }
}