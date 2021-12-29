package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath: config/browser.properties")
public interface BrowserConfig extends Config {

    @Key("browserName")
    @DefaultValue("Chrome")
    String getBrowserName();

    @Key("browserVersion")
    @DefaultValue("94.0")
    String getBrowserVersion();

    @Key("browserStartMaximized")
    @DefaultValue("true")
    Boolean getBrowserStartMaximized();

}
