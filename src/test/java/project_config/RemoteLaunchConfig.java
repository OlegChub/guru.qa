package project_config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/remote.properties"})
public interface RemoteLaunchConfig extends Config {

    Boolean remoteWebDriver();

    String remoteUrl();

    String login();

    String password();

}
