import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DemoqaFormAutomation {
    private final String PIC_NAME = "chucknorris.jpg";
    private final String PATH_TO_IMAGE = System.getProperty("user.dir") + "/src/test/resources/" + PIC_NAME;

    @BeforeAll
    static void configuration() {
        Configuration.startMaximized = true;
    }

    @Test
    void testDemoqaForm() {
        String firstName = "Chuck";
        String lastName = "Norris";
        String userEmail = "ChuckNorris@mail.com";
        String gender = "Other";
        String userNumber = "0000000001";
        String[] birthday = {"11", "March", "1900"};
        String subject1 = "Computer Science";
        String subject2 = "English";
        String hobby1 = "Sports";
        String hobby2 = "Music";
        String currentAddress = "Universe";
        String state = "Rajasthan";
        String city = "Jaipur";

        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $(byText(gender)).click();
        $("#userNumber").setValue(userNumber);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(byText(birthday[1])).click();
        $(".react-datepicker__year-select").click();
        $(byText(birthday[2])).click();
        $(byText(birthday[0])).click();

        $("#subjectsInput").setValue("Co");
        $(byText(subject1)).click();
        $("#subjectsInput").setValue("En");
        $(byText(subject2)).click();

        $(byText(hobby1)).click();
        $(byText(hobby2)).click();

        $("#currentAddress").scrollIntoView(true);
        $("#uploadPicture").setValue(PATH_TO_IMAGE);

        $("#currentAddress").setValue(currentAddress);

        $(byText("Select State")).click();
        $(byText(state)).click();
        $(byText("Select City")).click();
        $(byText(city)).click();

        $("#submit").click();

        checkFields("Student Name", firstName + " " + lastName);
        checkFields("Student Email", userEmail);
        checkFields("Gender", gender);
        checkFields("Student Name", firstName);
        checkFields("Mobile", userNumber);
        checkFields("Date of Birth", dateOfBirthFormatter(birthday));
        checkFields("Subjects", subject1 + ", " + subject2);
        checkFields("Hobbies", hobby1 + ", " + hobby2);
        checkFields("Picture", PIC_NAME);
        checkFields("State and City", state + " " + city);
    }

    private static void checkFields(String label, String value) {
        $(byXpath("//td[text()='" + label + "']/following-sibling::td")).shouldHave(Condition.matchText(value));
    }

    private static String dateOfBirthFormatter(String[] arr) {
        final String DATE_PATTERN = "%s %s,%s";
        String dateFormatted = String.format(DATE_PATTERN, arr[0], arr[1], arr[2]);

        return dateFormatted;
    }
}
