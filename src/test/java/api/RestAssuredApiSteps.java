package api;

import config.CredentialsConfig;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.restassured.RestAssured.given;

public class RestAssuredApiSteps {
    static CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class, System.getProperties());

    public static Cookies authCookies;

    public static Cookies loginAndGetCookies() {
        return authCookies =
                given()
                        .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                        .formParam("Email", config.getEmail())
                        .formParam("Password", config.getPassword())
                        .when()
                        .post("/login")
                        .then()
                        .statusCode(302)
                        .extract().response().getDetailedCookies();
    }

    public static Response addToWishListWithResponse(Cookies cookies) {
        return
                given()
                        .cookies(cookies)
                        .when()
                        .post("/addproducttocart/details/43/2")
                        .then()
                        .statusCode(200)
                        .extract().response();
    }

    public static void addAuthCookieToBrowser(String cookieName) {
        getWebDriver().manage().addCookie(
                new Cookie(cookieName, authCookies.getValue(cookieName)));
    }

}
