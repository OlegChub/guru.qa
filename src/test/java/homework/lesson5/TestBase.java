package homework.lesson5;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

import static homework.lesson5.TestData.TestDataLesson5.*;


public class TestBase {
    @BeforeAll
    static void config() {
        Configuration.browserSize = BROWSER_SIZE;
        Configuration.baseUrl = HOST;
        Configuration.browser = BROWSER_NAME;
    }
}

