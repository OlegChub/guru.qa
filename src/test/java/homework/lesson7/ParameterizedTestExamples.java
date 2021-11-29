package homework.lesson7;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import homework.TestBaseWithListener;
import homework.lesson7.pages.LoginPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@DisplayName("Parameterized test examples")
@Tag("ParameterizedTests")
public class ParameterizedTestExamples extends TestBaseWithListener {
    LoginPage loginPage = new LoginPage();

    //https://www.baeldung.com/parameterized-tests-junit-5
    @ParameterizedTest(name = "Menu item {0} checking")
    @EnumSource(value = MenuItems.class)
    @DisplayName("With Enum Source annotation")
    public void testWithEnumSource(MenuItems item) {
        loginPage
                .openLoginPage()
                .enterLoginCredentials();
        $(".title").shouldHave(Condition.text("Products"));
        $("#react-burger-menu-btn").click();
        $(byText(item.getName())).click();
    }


    @ParameterizedTest(name = "Book's name {0} should have {1} ISBN number")
    @CsvFileSource(resources = "/dataForLesson7.csv", numLinesToSkip = 1)
    @DisplayName("With Csv File Source annotation")
    public void testWithCsvFileSource(String bookName, String ISBNnumber) {
        open("https://demoqa.com/books");
        $(byText(bookName)).click();
        $("#userName-value").shouldHave(Condition.text(ISBNnumber));
    }


    @ParameterizedTest(name = "Item with {1} in the name has {2} product card(s)")
    @DisplayName("With Arguments Source annotation")
    @ArgumentsSource(ArgumentsSourceProvider.class)
    public void testWithArgumentsSourceProvider(List<String> credentials, String itemName, int itemCount) {
        open("https://www.saucedemo.com");
        $("#user-name").sendKeys(credentials.get(0));
        $("#password").sendKeys(credentials.get(1));
        $("#login-button").click();
        $(".title").shouldHave(Condition.text("Products"));

        $$(".inventory_item_name")
                .filterBy(Condition.text(itemName))
                .shouldHave(CollectionCondition.size(itemCount));
    }


    @ParameterizedTest(name = "Login with login {0} and password {1}")
    @MethodSource("methodDataProvider")
    @DisplayName("With Method Source annotation")
    public void testWithMethodDataProvider(String login, String password) {
        loginPage
                .openLoginPage()
                .enterLoginCredentials();
        $(".title").shouldHave(Condition.text("Products"));
    }

    static Stream<Arguments> methodDataProvider() {
        return Stream.of(
                Arguments.arguments("standard_user", "secret_sauce"),
                Arguments.arguments("performance_glitch_user", "secret_sauce"),
                Arguments.arguments("problem_user", "secret_sauce")
        );
    }

}
