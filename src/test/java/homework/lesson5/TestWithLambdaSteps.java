package homework.lesson5;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static homework.lesson5.testData.TestDataLesson5.REPOSITORY_NAME;
import static io.qameta.allure.Allure.step;


@Owner("ochubrik")
@Feature("Allure report")
@DisplayName("Allure steps")
public class TestWithLambdaSteps extends TestBase {

    @DisplayName("Issue presence - lambda steps")
    @Test
    public void checkRepositoryIsAvailableWithSteps() {
        step("Open base page", () -> {
            open("");
        });
        step("Enter " + REPOSITORY_NAME + " in search field", () -> {
            $("[name='q']").sendKeys(REPOSITORY_NAME);
        });
        step("Click Enter", () -> {
            $("[name='q']").pressEnter();
        });
        step("Click on Issues item", () -> {
            $("[data-search-type='Issues']").click();
        });
        step("Check that we switched to issues page", () -> {
            $$("h3").get(1).shouldHave(Condition.text("issues"));
        });

        step("Check that search results are visible", () -> {
            $("#issue_search_results").shouldBe(Condition.visible);
        });

    }
}

