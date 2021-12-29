package tests;

import api.RestAssuredApiSteps;
import com.codeborne.selenide.Condition;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static api.RestAssuredApiSteps.authCookies;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ApiUiTests extends BaseTest {

    @Test
    @DisplayName("Add to wishlist and check it on WEB")
    void addToWishList() {
        RestAssuredApiSteps.loginAndGetCookies();
        Response wishListItemsQuantity = RestAssuredApiSteps.addToWishListWithResponse(authCookies);
        String getWishListItemCounter = wishListItemsQuantity.path("updatetopwishlistsectionhtml");

        open("/Themes/DefaultClean/Content/images/logo.png");
        RestAssuredApiSteps.addAuthCookieToBrowser();

        open("");

        $(".wishlist-qty").shouldHave(Condition.text(getWishListItemCounter));
    }
}
