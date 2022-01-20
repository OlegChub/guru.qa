package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:emulator.properties")
public interface MobileConfig extends Config {
    @Key("platformName")
    String mobilePlatform();

    @Key("version")
    String mobilePlatformVersion();

    @Key("deviceName")
    String mobileDeviceName();

    @Key("appPath")
    String appPath();

    @Key("localHost")
    String localHost();
}
