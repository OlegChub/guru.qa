package config;

import org.aeonbits.owner.ConfigFactory;

public class AppConfig {
    public static BrowserConfig browserConfig = ConfigFactory.create(BrowserConfig.class, System.getProperties());
    public static WebsiteConfig websiteConfig = ConfigFactory.create(WebsiteConfig.class, System.getProperties());

}
