package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;
public class TextBoxWithPageObjectsTests extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void formBoxTests() {
        TextBoxPage textBoxPage = new TextBoxPage();

        textBoxPage.openPage()
                .setUserName("Anastasiia Kenzina")
                .setUserEmail("kenzina.aa@yandex.ru")
                .setCurrentAddress("Irkutsk")
                .setPermanentAddress("Irkutsk")
                .submitForm();
        textBoxPage.checkResults ("Name:", "Anastasiia Kenzina")
                .checkResults ("Email:", "kenzina.aa@yandex.ru")
                .checkResults ("Current Address :", "Irkutsk")
                .checkResults ("Permananet Address :", "Irkutsk");


    }
}

