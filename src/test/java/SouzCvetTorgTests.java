import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import project_config.ProjectConfiguration;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class SouzCvetTorgTests extends TestBase {
    ProjectConfiguration config = ConfigFactory.create(ProjectConfiguration.class, System.getProperties());

    String vacanciesPageURL = "https://www.souzcvettorg.ru/about/job/";
    String contactsPageURL = "https://www.souzcvettorg.ru/about/contacts/";
    String deliveryPageURL = "https://www.souzcvettorg.ru/about/dostavka-i-oplata/";
    String shopsPageURL = "https://www.souzcvettorg.ru/about/shop/";

    @Test
    @DisplayName("Check page title")
    void checkPageTitle() {
        step("Open Vacancies page", () -> open(vacanciesPageURL));
        String expectedTitle = "Вакансии Компании СоюзЦветТорг Предложение Работы в Москве | СоюзЦветТорг";
        step("Get actual title and check it", () -> {
            String actualTitle = title();
            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @DisplayName("Check vacancy is present")
    void checkVacancyIsPresent() {
        step("Open Vacancies page", () -> open(vacanciesPageURL));
        String vacancyName = "КОНСУЛЬТАНТ ТОРГОВОГО ЗАЛА";
        step("Check vacancy is on the page", () -> {
            $(".nm").shouldHave(Condition.text(vacancyName));
        });
    }

    @Test
    @DisplayName("Check header of the page")
    void checkHeaderOfThePage() {
        step("Open Vacancies page", () -> open(vacanciesPageURL));
        step("Check header of the page", () -> {
            String headerText = "Вакансии Компании СоюзЦветТорг";
            $("#pagetitle").shouldHave(Condition.text(headerText));
        });
    }

    @Test
    @DisplayName("Check phone number on Contacts page")
    void checkPhoneNumberInContacts() {
        step("Open Contacts page", () -> open(contactsPageURL));
        step("Check phone number on the page", () -> {
            String headerText = "8-800-550-19-00";
            $(".text_red").shouldHave(Condition.text(headerText));
        });
    }

    @Test
    @DisplayName("Check delivery intervals quantity")
    void checkDeliveryIntervals() {
        step("Open Delivery terms page", () -> open(deliveryPageURL));
        step("Check delivery intervals quantity", () -> {
            $(".tables-responsive").$$("tr").shouldHave(CollectionCondition.size(13));
        });
    }

    @Test
    @DisplayName("Check shops quantity")
    void checkShopsQuantity() {
        step("Open shops page", () -> open(shopsPageURL));
        step("Check shops quantity", () -> {
            $(".items").$$(".item").shouldHave(CollectionCondition.size(55));
        });
    }
}
