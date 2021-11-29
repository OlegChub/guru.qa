
import Pages.RegistrationFormPage;
import org.junit.jupiter.api.Test;

import static Pages.VerificationPopUp.*;
import static TestData.TestData.*;

public class DemoqaFormAutomation extends TestBaseRemote {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @Test
    void testDemoqaForm() {

        registrationFormPage
                .openRegistrationFormPage()
                .enterNameInTheField(FIRST_NAME)
                .enterLastNameInTheField(LAST_NAME)
                .enterUserEmailInTheField(USER_EMAIL)
                .choseUserGender(GENDER)
                .enterUserPhoneNumberInTheField(USER_NUMBER)
                .calendarInit().setCalendarData(getBirthdayItem("day"), getBirthdayItem("month"),
                        getBirthdayItem("year"));

        registrationFormPage
                .enterSubjectInTheField(SUBJECT)
                .chooseHobby(HOBBY)
                .uploadPicture(PIC_NAME)
                .enterCurrentAddress(ADDRESS)
                .scrollToElement()
                .selectState(STATE)
                .selectCity(CITY)
                .pressSubmitBtn();

        // Verification
        checkVerificationPopUpTitle();
        checkFieldsInVerificationPopUp("Student Name", FIRST_NAME + " " + LAST_NAME);
        checkFieldsInVerificationPopUp("Student Email", USER_EMAIL);
        checkFieldsInVerificationPopUp("Gender", GENDER);
        checkFieldsInVerificationPopUp("Mobile", USER_NUMBER);
        checkFieldsInVerificationPopUp("Date of Birth", dateOfBirthFormatter(BIRTHDAY));
        checkFieldsInVerificationPopUp("Subjects", SUBJECT);
        checkFieldsInVerificationPopUp("Hobbies", HOBBY);
        checkFieldsInVerificationPopUp("Picture", PIC_NAME);
        checkFieldsInVerificationPopUp("Address", ADDRESS);
        checkFieldsInVerificationPopUp("State and City", STATE + " " + CITY);
    }


}