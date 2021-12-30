package tests;

import api.RestAssuredApiSteps;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static api.RestAssuredApiSteps.authCookies;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class ApiUiTests extends BaseTest {
    String getWishListItemCounter;
    String cookieName = "NOPCOMMERCE.AUTH";
    Response wishListItemsQuantity;

    @Test
    @Tags({@Tag("Api"), @Tag("Api+UI")})
    @DisplayName("Add to wishlist and check it on WEB")
    void addToWishList() {
        step("Login and get cookies", () -> {
            RestAssuredApiSteps.loginAndGetCookies();
        });

        step("Add product to wishlist", () -> {
            wishListItemsQuantity = RestAssuredApiSteps.addToWishListWithResponse(authCookies);
        });

        step("Get wishlist goods added quantity", () -> {
            getWishListItemCounter = wishListItemsQuantity.path("updatetopwishlistsectionhtml");
        });

        step("Open minimal content, because cookie can be set when site is opened", () -> {
            open("/Themes/DefaultClean/Content/images/logo.png");
        });

        step("Add auth cookie to browser", () -> {
            RestAssuredApiSteps.addAuthCookieToBrowser(cookieName);
        });

        step("Open main page", () -> {
            open("");
        });

        step("Check added items quantity on Web", () -> {
            $(".wishlist-qty").shouldHave(text(getWishListItemCounter));
        });

    }
}
