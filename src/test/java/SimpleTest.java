import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.*;

public class SimpleTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
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
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(byValue("11")).click();
        $(".react-datepicker__year-select").click();
        $(byValue("1985")).click();
        $(".react-datepicker__day--003").click();
        $("#subjectsInput").setValue(subj);
        $(byText("English")).click();
        $("label[for='hobbies-checkbox-1']").click();
        $("label[for='hobbies-checkbox-2']").click();
        $("label[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFromClasspath("test.png");
        $("#currentAddress").setValue(currentAddress);
        $(byText("Select State")).click();
        $(byText(state)).click();
        $(byText("Select City")).click();
        $(byText(city)).click();
        $("#submit").click();

        //проверяем правильность заполнения формы
        $(byText(firstName+" "+lastName)).shouldBe(visible);
        $(byText(userEmail)).shouldBe(visible);
        $(byText("Male")).shouldBe(visible);
        $(byText(userNumber)).shouldBe(visible);
        $(byText("03 December,1985")).shouldBe(visible);
        $(byText("English")).shouldBe(visible);
        $(byText("Sports, Reading, Music")).shouldBe(visible);
        $(byText("test.png")).shouldBe(visible);
        $(byText("currentAddress")).shouldBe(visible);
        $(byText(state+" "+city)).shouldBe(visible);

    }
}
