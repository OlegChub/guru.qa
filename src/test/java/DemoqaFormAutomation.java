import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class DemoqaFormAutomation extends TestBase {

    @Test
    void testDemoqaForm() {

        registrationFormPage
                .openRegistrationFormPage()
                .enterNameInTheField(testData.getFirstName())
                .enterLastNameInTheField(testData.getLastName())
                .enterUserEmailInTheField(testData.getUserEmail())
                .choseUserGender(testData.getGender())
                .enterUserPhoneNumberInTheField(testData.userNumber())
                .calendarInit().setCalendarData(testData.getBirthDayDate()[0], testData.getBirthDayDate()[1],
                        testData.getBirthDayDate()[2]);

        registrationFormPage
                .enterSubjectInTheField(testData.setSubject())
                .chooseHobby(testData.setHobby())
                .uploadPicture(testData.PIC_NAME)
                .enterCurrentAddress(testData.getCurrentAddress())
                .scrollToElement()
                .selectState(testData.getState())
                .selectCity(testData.getCity())
                .pressSubmitBtn();


//        $("#userEmail").setValue(userEmail);
//        $(byText(gender)).click();
//        $("#userNumber").setValue(userNumber);

//        $("#dateOfBirthInput").click();
//        $(".react-datepicker__month-select").click();
//        $(byText(birthday[1])).click();
//        $(".react-datepicker__year-select").click();
//        $(byText(birthday[2])).click();
//        $(byText(birthday[0])).click();
//        System.out.println(123);
//        $("#subjectsInput").setValue("Co");
//        $(byText(subject1)).click();
//        $("#subjectsInput").setValue("En");
//        $(byText(subject2)).click();

//        $(byText(hobby1)).click();
//        $(byText(hobby2)).click();

//        $("#currentAddress").scrollIntoView(true);
//        $("#uploadPicture").setValue(PATH_TO_IMAGE);
//        $("#uploadPicture").uploadFile(new File(TestData.PATH_TO_IMAGE));
//
//        $("#currentAddress").setValue(currentAddress);
//
//        $(byText("Select State")).click();
//        $(byText(state)).click();
//        $(byText("Select City")).click();
//        $(byText(city)).click();

//        $("#submit").click();

        checkFields("Student Name", testData.getFirstName() + " " + testData.getLastName());
        checkFields("Student Email", testData.getUserEmail());
        checkFields("Gender", testData.getGender());
        checkFields("Mobile", testData.userNumber());
        checkFields("Date of Birth", dateOfBirthFormatter(testData.getBirthDayDate()));
        checkFields("Subjects", testData.getSubject());
        checkFields("Hobbies", testData.getHobby());
        checkFields("Picture", testData.PIC_NAME);
        checkFields("State and City", testData.getState() + " " + testData.getCity());
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