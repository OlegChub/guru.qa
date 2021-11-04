import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Lesson4 {


    @BeforeAll
    public static void config(){
        Configuration.browserSize="1366x768";
    }

    @Test
    public void checkSoftAssertionsHasJUnit5example(){
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $$("a").shouldHave(CollectionCondition.itemWithText("Soft assertions"));
        $(byText("Soft assertions")).click();
        $("#wiki-wrapper").$("h1").shouldHave(text("SoftAssertions"));
        $("ol[start='3']").$("li").shouldHave(text("Using JUnit5"));
    }

    @Test
    public void checkDragAndDrop(){
        open("https://the-internet.herokuapp.com/drag_and_drop");

        //checking the order of the elements before drag-n-drop
        $$(".column").first().shouldHave(text("A"));
        $$(".column").last().shouldHave(text("B"));

        $("#column-a").dragAndDropTo("#column-b");
        $$(".column").last().shouldHave(text("A"));

    }
}
