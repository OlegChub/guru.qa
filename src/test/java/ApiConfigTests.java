import io.qameta.allure.Description;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import project_config.ApiConfig;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ApiConfigTests {

    @Test
    public void apiConfigTestLocal() {

        ApiConfig apiConfig = ConfigFactory.create(ApiConfig.class, System.getProperties());

        assertThat(apiConfig.baseUrl()).isEqualTo("https://github.com/OlegChub");
        assertThat(apiConfig.token()).isEqualTo("12345");
    }

    @Test
    @Description("Test with using data from remote file")
    public void apiConfigTestRemote() throws IOException {

        String content = "baseURL=https://github.com/OlegChub\n" +
                "token=67890";

        // создаем файл и записываем туда данные
        Path props = Paths.get("/tmp/api_config.properties");
        Files.write(props, content.getBytes(StandardCharsets.UTF_8));

        ApiConfig apiConfig = ConfigFactory.create(ApiConfig.class, System.getProperties());

        assertThat(apiConfig.baseUrl()).isEqualTo("https://github.com/OlegChub");
        assertThat(apiConfig.token()).isEqualTo("67890");

        //удаляем созданный файл
        Files.delete(props);
    }
}
