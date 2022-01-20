package helpers;

import com.codeborne.selenide.Configuration;
import driver.BrowserstackMobileDriver;
import driver.EmulatorDriver;

public class DeviceHostSelector {
    public static String getDeviceHostProperty() {
        String prop = System.getProperty("deviceHost");
        String ConfigBrowser;
        switch (prop) {
            case ("emulation"):
                ConfigBrowser = EmulatorDriver.class.getName();
                break;
            case ("browserstack"):
                ConfigBrowser = BrowserstackMobileDriver.class.getName();
                break;
            default:
                ConfigBrowser = BrowserstackMobileDriver.class.getName();
        }

        return Configuration.browser = ConfigBrowser;
    }
}
