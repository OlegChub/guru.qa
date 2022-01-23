package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:deviceHost.properties")
public interface RunConfig extends Config {

    @Key("browserstackUser")
    @DefaultValue("browserstack")
    String deviceHost();
}
