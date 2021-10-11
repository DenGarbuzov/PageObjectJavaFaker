package qa.dgg.Utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;


import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Base extends Variables {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    public void setFullName(String firstName, String lastName ) {
        firstNameField.setValue(firstName);
        lastNameField.setValue(lastName);
    }


    public void setMathSubject() {
        subject.setValue("M").pressEnter();
    }

    public void setMaleGender() {
        maleGender.click();
    }

    public void setPicture(String name){
        upload.uploadFromClasspath(name);
    }
    public void setFirstHobby() {
        $("[for=hobbies-checkbox-1]").click();
    }
    public void setNCR() {
        state.click();
        $(byText("NCR")).click();
    }
    public void setDelhiCity() {
    city.click();
    $(byText("Delhi")).click();
    }
    public void submit(){
        submitBtn.scrollTo().click();
    }

    @Attachment(value = "Скриншот", type = "image/png")
    public byte[] takeScreenshot() {
        return Selenide.screenshot(OutputType.BYTES);
    }

    @BeforeAll
    static void setup() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
        Configuration.startMaximized = true;
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub/";
    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
