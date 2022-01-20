package tests.emulatorTests;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class EmulatorTests {

    @Test
    @DisplayName("Search results list is not empty")
    void checkSearchVariantsArePresent() {
        back();
        step("Click on search field", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
        });
        step("Insert search request", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack");
        });
        step("Check that search result not null", () -> {
            $$(byClassName("android.widget.TextView")).shouldHave(sizeGreaterThan(0));
        });
    }


    @Test
    @DisplayName("Open page from search results list")
    void checkPageIsPresent() {
        back();
        step("Click on search field", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
        });
        step("Insert search request", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("van Gogh");
        });
        step("Click on the first link from results list", () -> {
            $(MobileBy.xpath("//*[@text='Vincent van Gogh']")).click();
        });
        step("Check page", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/view_page_subtitle_text")).shouldHave(text("Dutch painter (1853–1890)"));
        });
    }

}
