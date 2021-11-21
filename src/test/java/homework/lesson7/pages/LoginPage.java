package homework.lesson7.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    private static final String LOGIN_PAGE_URL = "https://www.saucedemo.com";
    private static final String USER_LOGIN = "standard_user";
    private static final String PASSWORD = "secret_sauce";
    private SelenideElement
            logo = $(".login_logo"),
            userName = $("#user-name"),
            userPassword = $("#password"),
            loginButton = $("#login-button");

    public LoginPage openLoginPage() {
        open(LOGIN_PAGE_URL);
        logo.isDisplayed();
        return this;
    }

    public void enterLoginCredentials() {
        userName.sendKeys(USER_LOGIN);
        userPassword.sendKeys(PASSWORD);
        loginButton.click();
    }
}
