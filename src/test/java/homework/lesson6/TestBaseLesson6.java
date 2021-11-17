package homework.lesson6;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;

import static homework.lesson5.testData.TestDataLesson5.*;

public class TestBaseLesson6 {
    @BeforeAll
    static void config(){
        Configuration.browser=BROWSER_NAME;
        Configuration.browserSize=BROWSER_SIZE;
        SelenideLogger.addListener("Allure", new AllureSelenide());
    }
}
