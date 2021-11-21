package homework;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;

import static homework.TestData.BROWSER_NAME;
import static homework.TestData.BROWSER_SIZE;

public class TestBaseWithListener {
    @BeforeAll
    static void config(){
        Configuration.browser=BROWSER_NAME;
        Configuration.browserSize=BROWSER_SIZE;
        SelenideLogger.addListener("Allure", new AllureSelenide());
    }
}
