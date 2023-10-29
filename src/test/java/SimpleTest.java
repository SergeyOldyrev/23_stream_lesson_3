import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen =  true;
    }

    @Test
    void successfulSearchTest() {
        String firstName = "firstName";
        String lastName = "lastName";
        String userEmail = "userEmail@mail.com";
        String userNumber = "2222222222";
        String subj = "english";
        String currentAddress = "currentAddress";
        String state = "NCR";
        String city = "Gurgaon";

        open("/automation-practice-form");
        $("#firstName").setValue(firstName).shouldHave(value(firstName));
        $("#lastName").setValue(lastName).shouldHave(value(lastName));
        $("#userEmail").setValue(userEmail).shouldHave(value(userEmail));
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(byValue("11")).click();
        $(".react-datepicker__year-select").click();
        $(byValue("1985")).click();
        $(".react-datepicker__day--003").click();
        $("#dateOfBirthInput").shouldHave(value("03 Dec 1985"));
        $("#subjectsInput").setValue(subj);
        $(byText("English")).click();
        $(".css-12jo7m5.subjects-auto-complete__multi-value__label").shouldHave(text("English"));
        $("label[for='hobbies-checkbox-1']").click();
        $("label[for='hobbies-checkbox-2']").click();
        $("label[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFromClasspath("test.png");
        $("#currentAddress").setValue(currentAddress).shouldHave(value(currentAddress));
        $(byText("Select State")).click();
        $(byText(state)).click();
        $(byText(state)).shouldHave(text(state));
        $(byText("Select City")).click();
        $(byText(city)).click();
        $(byText(city)).shouldHave(text(city));
    }
}
