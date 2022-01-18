package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath: resources/credentials.properties"
})
public interface ConfigSetup extends Config {
    @DefaultValue("alchu_5QWANU")
    @Key("browserstackUser")
    String browserstackUser();

    @DefaultValue("yzxWEUPx6sKZNv2GgQJZ")
    @Key("browserstackKey")
    String browserstackKey();

    @DefaultValue("bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c")
    @Key("appLink")
    String appLink();

    @DefaultValue("Google Pixel 3")
    String device();

    @DefaultValue("9.0")
    String osVersion();

    @DefaultValue("http://hub.browserstack.com/wd/hub")
    @Key("browserstackURL")
    String browserstackURL();
}
