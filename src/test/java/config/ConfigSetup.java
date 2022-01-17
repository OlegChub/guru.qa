package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath: resources/credentials.properties"
})
public interface ConfigSetup extends Config {
    @DefaultValue("souzcounter@yandex.ru")
    String browserstackUser();

    @DefaultValue("browserstack1701")
    String browserstackKey();

    @DefaultValue("bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c")
    String appLink();
}
