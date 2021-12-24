package helpers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.remote.DesiredCapabilities;
import project_config.AppConfig;

import static project_config.AppConfig.selenoidConfig;

public class DriverManager {

    public static void configuration() {
        Configuration.browser = AppConfig.config.browser();
        Configuration.browserVersion = AppConfig.config.browserVersion();
        Configuration.browserSize = AppConfig.config.browserSize();

        if (selenoidConfig.selenoid_host_enable()) {
            Configuration.remote = selenoidConfig.selenoid_host();
        }

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;

        SelenideLogger.addListener("Allure", new AllureSelenide());
    }

}
