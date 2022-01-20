package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:realDevice.properties")
public interface RealDeviceConfig extends Config {
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
