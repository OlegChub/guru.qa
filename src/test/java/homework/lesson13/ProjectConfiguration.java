package homework.lesson13;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/launch.properties"

})
public interface ProjectConfiguration extends Config {

    @DefaultValue("Chrome")
    String browser();

    @DefaultValue("91.0")
    String browserVersion();

    @DefaultValue("1920x1080")
    String browserSize();

    @DefaultValue("")
    String remoteUrl();
}