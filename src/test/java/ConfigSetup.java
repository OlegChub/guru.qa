import org.aeonbits.owner.Config;

@Config.Sources(
        "classpath: resources/credentials.properties"
)
public class ConfigSetup implements Config {
    String getBrowserstackUser;
    String getBrowserstackPassword;
    String getBrowserstackAppLink;


}
