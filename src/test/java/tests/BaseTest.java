package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;


public class BaseTest {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "http://demowebshop.tricentis.com";
        Configuration.baseUrl = "http://demowebshop.tricentis.com";
        Configuration.browser = "Chrome";
        Configuration.browserVersion = "94.0";
        Configuration.startMaximized = true;

    }

    @AfterEach
    void tearDown() {
        Selenide.closeWebDriver();
    }

}
