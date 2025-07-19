package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {
    @BeforeAll
    static void BeforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true;
        //Configuration.timeout = 5000;
    }

    @Test
    //использование Selenide.actions()
    void selenideActionsTest() {
        //открываем страницу drag_and_drop
        open("/drag_and_drop");

        //находим элементы A и B
        //зададим элементы A и B через переменные
        var columnA = $("#column-a");
        var columnB = $("#column-b");
        //проверяем заголовки и видимость элементов A и B
        columnA.shouldHave(text("A")).shouldBe(visible);
        columnB.shouldHave(text("B")).shouldBe(visible);

        //захватываем и перетаскиваем B на место A
        actions().clickAndHold(columnB).moveToElement(columnA).release().perform();

        //проверяем, что заголовки у элементов поменялись местами
        columnA.shouldHave(text("B")).shouldBe(visible);
        columnB.shouldHave(text("A")).shouldBe(visible);

    }
    @Test
    //использование $(element).dragAndDrop($(to-element))
    void dragAndDropTest() {
        //открываем страницу drag_and_drop
        open("/drag_and_drop");

        //находим элементы A и B
        //зададим элементы A и B через переменные
        var columnA = $("#column-a");
        var columnB = $("#column-b");
        //проверяем заголовки и видимость элементов A и B
        columnA.shouldHave(text("A")).shouldBe(visible);
        columnB.shouldHave(text("B")).shouldBe(visible);

        //захватываем и перетаскиваем B на место A
        columnA.dragAndDrop(to(columnB));

        //проверяем, что заголовки у элементов поменялись местами
        columnA.shouldHave(text("B")).shouldBe(visible);
        columnB.shouldHave(text("A")).shouldBe(visible);

    }
}
