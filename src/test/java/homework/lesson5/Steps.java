package homework.lesson5;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;
import static homework.TestData.*;


public class Steps {

    @Step("Open github main page")
    public void openBasePage() {
        open("");
    }

    @Step("Enter " + REPOSITORY_NAME + " in search field")
    public void enterRepNameInSearchField() {
        $("[name='q']").sendKeys(REPOSITORY_NAME);
    }

    @Step("Click Enter")
    public void clickEnterBtn() {
        $("[name='q']").pressEnter();
    }

    @Step("Click on Issues item")
    public void clickOnIssueItem() {
        $("[data-search-type='Issues']").click();
    }

    @Step("Check that we switched to issues page")
    public void checkWeAreOnIssuesPage() {
        $$("h3").get(1).shouldHave(Condition.text("issues"));
    }

    @Step("Check that search results are visible")
    public void checkSearchResultAreDisplayed() {
        $("#issue_search_results").shouldBe(Condition.visible);
    }

}

