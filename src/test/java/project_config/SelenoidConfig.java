package project_config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath: config/selenoid.properties"})
public interface SelenoidConfig extends Config {

    @DefaultValue("false")
    Boolean selenoid_host_enable();

    @DefaultValue("http://localhost:4444/wd/hub")
    String selenoid_host();

}
