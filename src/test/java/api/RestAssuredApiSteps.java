package api;

import io.restassured.http.Cookies;
import io.restassured.response.Response;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.restassured.RestAssured.given;

public class RestAssuredApiSteps {
//    CredentialsConfig credentialsConfig= ConfigFactory.create(CredentialsConfig.class,)
public static Cookies authCookies;

    public static Cookies loginAndGetCookies() {
        return authCookies =
                given()
                        .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                        .formParam("Email", "alchu@mail.rg")
                        .formParam("Password", "1q2w3e")
                        .when()
                        .post("/login")
                        .then()
                        .statusCode(302)
                        .extract().response().getDetailedCookies();
    }

    public static Response addToWishListWithResponse(Cookies cookies) {
        return
                given()
                        .cookies(authCookies)
                        .when()
                        .post("/addproducttocart/details/43/2")
                        .then()
                        .statusCode(200)
                        .extract().response();
    }

    public static void addAuthCookieToBrowser() {
        getWebDriver().manage().addCookie(
                new Cookie("NOPCOMMERCE.AUTH", authCookies.getValue("NOPCOMMERCE.AUTH")));
    }

}
