package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class VerificationPopUp {
    private static final String REGISTRATION_FORM_FINAL_POPUP_TITLE = "Thanks for submitting the form";
    private static final String DATE_PATTERN = "%s %s,%s";

    private static SelenideElement popUpTitle = $("#example-modal-sizes-title-lg");

    public static void checkVerificationPopUpTitle() {
        popUpTitle.shouldHave(text(REGISTRATION_FORM_FINAL_POPUP_TITLE));
    }

    public static void checkFieldsInVerificationPopUp(String label, String value) {
        $(byXpath("//td[text()='" + label + "']/following-sibling::td")).shouldHave(Condition.matchText(value));
    }

    public static String dateOfBirthFormatter(String[] arr) {
        String dateFormatted = String.format(DATE_PATTERN, arr[0], arr[1], arr[2]);
        return dateFormatted;
    }

}
