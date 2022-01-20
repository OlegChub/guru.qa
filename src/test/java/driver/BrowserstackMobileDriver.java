package driver;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserstackConfig;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {
    BrowserstackConfig configSetup = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());


    public static URL getBrowserstackUrl() {
        try {
            return new URL("http://hub.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        desiredCapabilities.setCapability("browserstack.user", configSetup.browserstackUser());
        desiredCapabilities.setCapability("browserstack.key", configSetup.browserstackKey());

        // Set URL of the application under test
        desiredCapabilities.setCapability("app", configSetup.appLink());

        // Specify device and os_version for testing
        desiredCapabilities.setCapability("device", configSetup.device());
        desiredCapabilities.setCapability("os_version", configSetup.osVersion());

        // Set other BrowserStack capabilities
        desiredCapabilities.setCapability("project", "First Java Project");
        desiredCapabilities.setCapability("build", "browserstack-build-1");
        desiredCapabilities.setCapability("name", "first_test");
        return new AndroidDriver(getBrowserstackUrl(), desiredCapabilities);
    }
}
