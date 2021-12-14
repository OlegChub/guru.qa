package homework.lesson13;

import com.codeborne.selenide.Condition;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class VacancyTests extends TestBase {
    ProjectConfiguration config = ConfigFactory.create(ProjectConfiguration.class, System.getProperties());

    @BeforeEach
    void loadVacancyPage() {
        step("Open vacancies page", () -> open("https://www.souzcvettorg.ru/about/job/"));
    }

    @Test
    @DisplayName("Check page title")
    void checkPageTitle() {
        String expectedTitle = "Вакансии Компании СоюзЦветТорг Предложение Работы в Москве | СоюзЦветТорг";
        step("Get actual title and check it", () -> {
            String actualTitle = title();
            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @DisplayName("Check vacancy is present")
    void checkVacancyIsPresent() {
        //    step("Open vacancies page",()->open("https://www.souzcvettorg.ru/about/job/"));
        String vacancyName = "КОНСУЛЬТАНТ ТОРГОВОГО ЗАЛА";
        step("Check vacancy is on the page", () -> {
            $(".nm").shouldHave(Condition.text(vacancyName));
        });
    }

    @Test
    @DisplayName("Check header of the page")
    void checkHeaderOfThePage() {
        step("Check header of the page", () -> {
            String headerText = "Вакансии Компании СоюзЦветТорг";
            $("#pagetitle").shouldHave(Condition.text(headerText));
        });
    }

    @Test
    void test() {
        System.out.println(config.browser());
    }
}
