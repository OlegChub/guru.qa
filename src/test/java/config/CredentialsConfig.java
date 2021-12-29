package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath: config/credentials.properties")
public interface CredentialsConfig extends Config {

    @Key("email")
    @DefaultValue("alchu@mail.rg")
    String getEmail();

    @Key("password")
    @DefaultValue("1q2w3e")
    String getPassword();

}
