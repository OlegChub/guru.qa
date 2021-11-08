import Pages.RegistrationFormPage;
import Pages.components.CalendarComponent;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    TestData testData=new TestData();

    @BeforeAll
    static void configuration() {
        Configuration.startMaximized = true;
    }

}

