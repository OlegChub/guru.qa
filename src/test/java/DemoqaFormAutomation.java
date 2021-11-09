
import org.junit.jupiter.api.Test;

import static Pages.VerificationPopUp.*;
import static TestData.TestData.*;

public class DemoqaFormAutomation extends TestBase {

    @Test
    void testDemoqaForm() {

        registrationFormPage
                .openRegistrationFormPage()
                .enterNameInTheField(getFirstName())
                .enterLastNameInTheField(getLastName())
                .enterUserEmailInTheField(getUserEmail())
                .choseUserGender(setGender())
                .enterUserPhoneNumberInTheField(getUserNumber())
                .calendarInit().setCalendarData(getBirthDayDate()[0], getBirthDayDate()[1],
                        getBirthDayDate()[2]);

        registrationFormPage
                .enterSubjectInTheField(setSubject())
                .chooseHobby(setHobby())
                .uploadPicture(PIC_NAME)
                .enterCurrentAddress(getCurrentAddress())
                .scrollToElement()
                .selectState(getState())
                .selectCity(getCity())
                .pressSubmitBtn();

        // Verification
        checkVerificationPopUpTitle();
        checkFields("Student Name", getFirstName() + " " + getLastName());
        checkFields("Student Email", getUserEmail());
        checkFields("Gender", getGender());
        checkFields("Mobile", getUserNumber());
        checkFields("Date of Birth", dateOfBirthFormatter(getBirthDayDate()));
        checkFields("Subjects", getSubject());
        checkFields("Hobbies", getHobby());
        checkFields("Picture", PIC_NAME);
        checkFields("State and City", getState() + " " + getCity());
    }


}