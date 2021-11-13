package homework.lesson5;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Owner("ochubrik")
@Feature("Allure report")
@DisplayName("Step annotation")
public class TestWithStepAnnotation extends TestBase {
    Steps steps = new Steps();

    @DisplayName("Issue presence - step annotation style")
    @Test
    public void checkRepositoryIsAvailableWithStepsAnnotation() {
        steps.openBasePage();
        steps.enterRepNameInSearchField();
        steps.clickEnterBtn();
        steps.clickOnIssueItem();
        steps.checkWeAreOnIssuesPage();
        steps.checkSearchResultAreDisplayed();

    }
}
