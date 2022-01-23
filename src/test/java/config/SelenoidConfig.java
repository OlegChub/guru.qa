package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:deviceHost.properties")
public interface SelenoidConfig extends Config {

    @Key("selenoidUrl")
    String selenoidUrl();

    @Key("selenoidAppVersion")
    String selenoidAppVersion();

    @Key("selenoidAppUrl")
    String selenoidAppUrl();
}
