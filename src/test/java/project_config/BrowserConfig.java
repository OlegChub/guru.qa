package project_config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/launch.properties"

})
public interface BrowserConfig extends Config {

    @DefaultValue("Chrome")
    String browser();

    @DefaultValue("89.0")
    String browserVersion();

    @DefaultValue("1920x1080")
    String browserSize();

}