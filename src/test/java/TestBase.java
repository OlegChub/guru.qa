import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void configuration() {
        Configuration.browser = "Chrome";
        Configuration.startMaximized = true;
    }

}

