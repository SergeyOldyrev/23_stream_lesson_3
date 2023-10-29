import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void successfulSearchTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("firstName");
        $("#lastName").setValue("lastName");
        $("#userEmail").setValue("userEmail@mail.com");
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue("2222222222");
        $("#subjectsInput").setValue("subjectsInput");
        $("label[for='hobbies-checkbox-1']").click();
        $("label[for='hobbies-checkbox-2']").click();
        $("label[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFromClasspath("test.png");
        $("#currentAddress").setValue("currentAddress");
        $("#subjectsInput").setValue("subjectsInput");
        $(".css-tlfecz-indicatorContainer").click();
        $(byText("NCR")).click();
        $(byText("Select City")).click();
        $(byText("Gurgaon")).click();
    }
}
