package Pages;

import Pages.components.CalendarComponent;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormPage {
    private static final String REGISTRATION_FORM_PAGE_URL = "https://demoqa.com/automation-practice-form";
    private static final String REGISTRATION_FORM_PAGE_TITLE = "Student Registration Form";

    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstName = $("#firstName"),
            lastName = $("#lastName"),
            userEmail = $("#userEmail"),
            userNumber = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            stateSelection = $(byText("Select State")),
            citySelection = $(byText("Select City")),
            scrollToElement = $("#currentAddress"),
            submitBtn =  $("#submit");

    public RegistrationFormPage openRegistrationFormPage() {
        open(REGISTRATION_FORM_PAGE_URL);
        formTitle.shouldHave(text(REGISTRATION_FORM_PAGE_TITLE));
        return this;
    }

    public RegistrationFormPage enterNameInTheField(String name) {
        firstName.setValue(name);
        return this;
    }

    public RegistrationFormPage enterLastNameInTheField(String surname) {
        lastName.setValue(surname);
        return this;
    }

    public RegistrationFormPage enterUserEmailInTheField(String email) {
        userEmail.setValue(email);
        return this;
    }

    public RegistrationFormPage choseUserGender(String gender) {
        $(byText(gender)).click();
        return this;
    }

    public RegistrationFormPage enterUserPhoneNumberInTheField(String phoneNumber) {
        userNumber.setValue(phoneNumber);
        return this;
    }

    public RegistrationFormPage enterSubjectInTheField(String subject) {
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }
    public RegistrationFormPage chooseHobby(String hobby) {
        $(byText(hobby)).click();
        return this;
    }

    public RegistrationFormPage uploadPicture(String pathToImage) {
        uploadPicture.uploadFromClasspath(pathToImage);
        return this;
    }
    public RegistrationFormPage enterCurrentAddress(String address) {
        currentAddress.setValue(address);
        return this;
    }
    public RegistrationFormPage selectState(String state) {
        stateSelection.click();
        $(byText(state)).click();
        return this;
    }
    public RegistrationFormPage selectCity(String city) {
        citySelection.click();
        $(byText(city)).click();
        return this;
    }
    public RegistrationFormPage scrollToElement() {
        scrollToElement.scrollIntoView(true);
        return this;
    }
    public RegistrationFormPage pressSubmitBtn() {
        submitBtn.click();
        return this;
    }

    public CalendarComponent calendarInit() {
        return new CalendarComponent();
    }

}
