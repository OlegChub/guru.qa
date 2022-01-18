package tests;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BrowserstackTests extends TestBase {

    @Test
    void checkSearchVariantsArePresent() {
        $(MobileBy.AccessibilityId("Search Wikipedia")).click();
        $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack");
        $$(byClassName("android.widget.TextView")).shouldHave(sizeGreaterThan(0));
    }


    @Test
    void checkPageIsPresent() {
        $(MobileBy.AccessibilityId("Search Wikipedia")).click();
        $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("van Gogh");
        $(MobileBy.id("org.wikipedia.alpha:id/page_list_item_title")).click();
        $(MobileBy.id("org.wikipedia.alpha:id/view_page_subtitle_text")).shouldHave(text("Dutch painter (1853–1890)"));
    }
}