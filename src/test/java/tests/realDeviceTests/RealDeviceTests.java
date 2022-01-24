package tests.realDeviceTests;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class RealDeviceTests {

    @Test
    void searchWikipediaTest() {
        $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"))
                .shouldHave(text("The Free Encyclopedia …in over 300 languages"));
        $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"))
                .shouldHave(text("New ways to explore"));
        $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"))
                .shouldHave(text("Reading lists with sync"));
        $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"))
                .shouldHave(text("Send anonymous data"));
        $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_done_button")).click();
        $(MobileBy.id("org.wikipedia.alpha:id/search_container"))
                .shouldBe(value(String.valueOf(visible)));
    }
}
