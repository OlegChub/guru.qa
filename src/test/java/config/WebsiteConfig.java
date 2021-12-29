package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath: config/website_url.properties")
public interface WebsiteConfig extends Config {

    @Key("homeURL")
    @DefaultValue("http://demowebshop.tricentis.com")
    String getURL();

}
