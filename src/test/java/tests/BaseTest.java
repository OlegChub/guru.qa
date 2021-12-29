package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static config.AppConfig.browserConfig;
import static config.AppConfig.websiteConfig;


public class BaseTest {

//    static AppConfig appConfig=new AppConfig();

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = websiteConfig.getURL();
        Configuration.baseUrl = websiteConfig.getURL();
        Configuration.browser = browserConfig.getBrowserName();
        Configuration.browserVersion = browserConfig.getBrowserVersion();
        Configuration.startMaximized = browserConfig.getBrowserStartMaximized();

    }

    @AfterEach
    void tearDown() {
        Selenide.closeWebDriver();
    }

}
