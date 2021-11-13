package homework.lesson5;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static homework.lesson5.testData.TestDataLesson5.*;



@Owner("ochubrik")
@Feature("Allure report")
@DisplayName("Allure listener")
public class ClearSelenideTestWithAllureListener extends TestBase {

    @DisplayName("Issue presence - allure listener")
    @Test
    public void checkRepositoryIsAvailable() {
        SelenideLogger.addListener("Allure", new AllureSelenide());

        open("");
        $("[name='q']").sendKeys(REPOSITORY_NAME);
        $("[name='q']").pressEnter();
        $("[data-search-type='Issues']").click();
        $$("h3").get(1).shouldHave(Condition.text("issues"));
        $("#issue_search_results").shouldBe(Condition.visible);

    }
}
