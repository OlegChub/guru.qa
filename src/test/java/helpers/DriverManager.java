package helpers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.remote.DesiredCapabilities;
import project_config.AppConfig;

import static helpers.URLbuilder.urlBuilder;
import static project_config.AppConfig.remoteConfig;

public class DriverManager {

    public static void configuration() {
        Configuration.browser = AppConfig.config.browser();
        Configuration.browserVersion = AppConfig.config.browserVersion();
        Configuration.browserSize = AppConfig.config.browserSize();

        if (remoteConfig.remoteWebDriver()) {
            String adminLogin = remoteConfig.login();
            String adminPassword = remoteConfig.password();
            String remoteUrl = remoteConfig.remoteUrl();

            String buildRemoteUrl = urlBuilder(adminLogin, adminPassword, remoteUrl);

            Configuration.remote = buildRemoteUrl;
        }

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;

        SelenideLogger.addListener("Allure", new AllureSelenide());
    }

}
