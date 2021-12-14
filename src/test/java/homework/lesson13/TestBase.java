package homework.lesson13;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;


public class TestBase {
    @BeforeAll
    static void config() {
        ProjectConfiguration config = ConfigFactory.create(ProjectConfiguration.class, System.getProperties());
        Configuration.browser = config.browser();
//        Configuration.browserSize=config.browserSize();
//        Configuration.remote= config.remoteUrl();


        SelenideLogger.addListener("Allure", new AllureSelenide());
    }
}
