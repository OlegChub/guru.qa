package project_config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "file:tmp/api_config.properties",
        "classpath:config/api_config.properties"
})
public interface ApiConfig extends Config {
    @Key("baseURL")
    @DefaultValue("https://github.com/OlegChub")
    String baseUrl();

    @Key("token")
    String token();
}
