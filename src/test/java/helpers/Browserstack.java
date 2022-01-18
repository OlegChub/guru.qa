package helpers;

import config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;

public class Browserstack {
    static BrowserstackConfig configSetup = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());

    public static String videoUrl(String sessionId) {
        return given()
                .auth().basic(configSetup.browserstackUser(), configSetup.browserstackKey())
                .when()
                .get("https://api-cloud.browserstack.com/app-automate/sessions/" + sessionId + ".json")
                .then()
                .statusCode(200)
                .log().body()
                .extract()
                .path("automation_session.video_url");
    }
}
