import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import project_config.ApiConfig;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ApiConfigTest {

    @Test
    public void apiConfigTest() {

        System.getProperty("token");

        ApiConfig apiConfig = ConfigFactory.create(ApiConfig.class, System.getProperties());

        assertThat(apiConfig.baseUrl()).isEqualTo("https://github.com/OlegChub");
        assertThat(apiConfig.token()).isEqualTo("12345");
    }
}
