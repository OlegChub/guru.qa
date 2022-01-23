package helpers;

import config.RunConfig;
import driver.BrowserstackMobileDriver;
import driver.EmulatorDriver;
import driver.RealDeviceDriver;
import driver.SelenoidDriver;
import org.aeonbits.owner.ConfigFactory;

public class RunHelper {
    private final RunConfig config = ConfigFactory.create(RunConfig.class, System.getProperties());

    private RunHelper() {
    }

    public static RunHelper runHelper() {
        return new RunHelper();
    }

    public Class<?> getDriverClass() {
        switch (config.deviceHost()) {
            case "browserstack":
                return BrowserstackMobileDriver.class;
            case "local":
                return EmulatorDriver.class;
            case "real":
                return RealDeviceDriver.class;
            case "selenoid":
                return SelenoidDriver.class;
            default:
                throw new RuntimeException("Incorrect device host");
        }
    }
}
