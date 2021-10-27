import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DemoqaFormAutomation {
    private static final String PATH_TO_IMAGE = System.getProperty("user.dir")+"/src/test/resources/chucknorris.jpg";

    @BeforeAll
    static void configuration() {
        Configuration.startMaximized = true;
    }

    @Test
    void testDemoqaForm() {
        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue("Chuck");
        $("#lastName").setValue("Norris");
        $("#userEmail").setValue("ChuckNorris@mail.com");
        $(byText("Other")).click();
        $("#userNumber").setValue("0000000001");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(byText("March")).click();
        $(".react-datepicker__year-select").click();
        $(byText("1900")).click();
        $(byText("1")).click();

        $("#subjectsInput").setValue("Co");
        $(byText("Computer Science")).click();
        $("#subjectsInput").setValue("En");
        $(byText("English")).click();

        $(byText("Sports")).click();
        $(byText("Music")).click();

        $("#currentAddress").scrollIntoView(true);
        $("#uploadPicture").setValue(PATH_TO_IMAGE);

        $("#currentAddress").setValue("Universe");

        $(byText("Select State")).click();
        $(byText("Rajasthan")).click();
        $(byText("Select City")).click();
        $(byText("Jaipur")).click();

        $("#submit").click();
    }
}
