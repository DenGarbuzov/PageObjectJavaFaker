package qa.dgg.Utils;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Base extends Data{
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

    public void setPicture(String path){
        upload.uploadFile(new File(path));
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
}
