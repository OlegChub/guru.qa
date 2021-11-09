import Pages.RegistrationFormPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void configuration() {
        Configuration.startMaximized = true;
    }

}

