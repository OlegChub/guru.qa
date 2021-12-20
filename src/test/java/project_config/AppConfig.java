package project_config;

import org.aeonbits.owner.ConfigFactory;

public class AppConfig {
    public static BrowserConfig config = ConfigFactory.create(BrowserConfig.class, System.getProperties());
    public static RemoteLaunchConfig remoteConfig = ConfigFactory.create(RemoteLaunchConfig.class, System.getProperties());
}
