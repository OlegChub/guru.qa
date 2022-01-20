package driver;

import com.codeborne.selenide.WebDriverProvider;
import config.RealDeviceConfig;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static utils.FileUtils.getAbsolutePath;

public class RealDeviceDriver implements WebDriverProvider {
    RealDeviceConfig configSetup = ConfigFactory.create(RealDeviceConfig.class, System.getProperties());


    public URL getBrowserstackUrl() {
        try {
            return new URL(configSetup.localHost());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        desiredCapabilities.setCapability("platformName", configSetup.mobilePlatform());
        desiredCapabilities.setCapability("version", configSetup.mobilePlatformVersion());

        desiredCapabilities.setCapability("deviceName", configSetup.mobileDeviceName());

        desiredCapabilities.setCapability("locale", "en");
        desiredCapabilities.setCapability("language", "en");
        desiredCapabilities.setCapability("appPackage", "org.wikipedia.alpha");
        desiredCapabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");
        desiredCapabilities.setCapability("app",
                getAbsolutePath(configSetup.appPath()));


        return new AndroidDriver(getBrowserstackUrl(), desiredCapabilities);
    }
}
