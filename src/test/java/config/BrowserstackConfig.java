package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:browserstack.properties")
public interface BrowserstackConfig extends Config {
    @Key("browserstackUser")
    String browserstackUser();

    @Key("browserstackKey")
    String browserstackKey();

    @Key("appLink")
    String appLink();

    @Key("device")
    String device();

    @Key("os_version")
    String osVersion();

    @Key("browserstackURL")
    String browserstackURL();
}
