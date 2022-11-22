import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest (){
        open ("/text-box");

        $ ("#userName").setValue("Alma");
        //$ ("[id=userName]");
        $ ("#userEmail").setValue("test@test.kz");
        $ ("#currentAddress").setValue("test address1");
        $ ("#permanentAddress").setValue("test address2");
        $ ("#submit").click();


        $ ("#output").shouldBe(Condition.visible);
        $ ("#output #name").shouldHave(text("Alma"));
        $ ("#output #email").shouldHave(text("test@test.kz"));

        // todo check adresses

    }
}
