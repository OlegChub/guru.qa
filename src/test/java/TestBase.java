import helpers.AllureAttachments;
import helpers.DriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;


public class TestBase {

    @BeforeAll
    static void config() {
        DriverManager.configuration();
    }

    @AfterEach
    void tearDown() {
        AllureAttachments.screenshotAs("Last screenshot");
        AllureAttachments.pageSource();
        AllureAttachments.browserConsoleLogs();
        AllureAttachments.addVideo();

//        Selenide.closeWebDriver();
    }
}
