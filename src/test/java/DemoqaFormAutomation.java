
import Pages.RegistrationFormPage;
import org.junit.jupiter.api.Test;

import static Pages.VerificationPopUp.*;
import static TestData.TestData.*;

public class DemoqaFormAutomation extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

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
        checkFieldsInVerificationPopUp("Student Name", getFirstName() + " " + getLastName());
        checkFieldsInVerificationPopUp("Student Email", getUserEmail());
        checkFieldsInVerificationPopUp("Gender", getGender());
        checkFieldsInVerificationPopUp("Mobile", getUserNumber());
        checkFieldsInVerificationPopUp("Date of Birth", dateOfBirthFormatter(getBirthDayDate()));
        checkFieldsInVerificationPopUp("Subjects", getSubject());
        checkFieldsInVerificationPopUp("Hobbies", getHobby());
        checkFieldsInVerificationPopUp("Picture", PIC_NAME);
        checkFieldsInVerificationPopUp("State and City", getState() + " " + getCity());
    }


}