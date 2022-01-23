package driver;

import com.codeborne.selenide.WebDriverProvider;
import config.SelenoidConfig;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class SelenoidDriver implements WebDriverProvider {
    SelenoidConfig configSetup = ConfigFactory.create(SelenoidConfig.class, System.getProperties());


    public URL getBrowserstackUrl() {
        try {
            return new URL(configSetup.selenoidUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        desiredCapabilities.setCapability("deviceName", "android");
        desiredCapabilities.setCapability("version", configSetup.selenoidAppVersion());

        desiredCapabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");
        desiredCapabilities.setCapability("appPackage", "org.wikipedia.alpha");

        desiredCapabilities.setCapability("app", configSetup.selenoidAppUrl());


        return new AndroidDriver(getBrowserstackUrl(), desiredCapabilities);
    }
}
