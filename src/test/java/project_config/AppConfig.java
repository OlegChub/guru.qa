package project_config;

import org.aeonbits.owner.ConfigFactory;

public class AppConfig {
    public static BrowserConfig config = ConfigFactory.create(BrowserConfig.class, System.getProperties());
    public static SelenoidConfig selenoidConfig = ConfigFactory.create(SelenoidConfig.class, System.getProperties());
}
