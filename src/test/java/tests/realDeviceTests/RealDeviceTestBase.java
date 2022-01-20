package tests.realDeviceTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import driver.RealDeviceDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class RealDeviceTestBase {
    @BeforeAll
    public static void setup() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        Configuration.browser = RealDeviceDriver.class.getName();
        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
    }

    @BeforeEach
    public void startDriver() {
        open();
    }


    @AfterEach
    public void afterEach() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        closeWebDriver();
    }
}
