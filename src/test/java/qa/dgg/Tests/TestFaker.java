package qa.dgg.Tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import qa.dgg.Components.DatePicker;
import qa.dgg.Utils.Base;
import qa.dgg.Utils.Data;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestFaker extends Base{

    Faker faker = new Faker();

    @Test
    void fillPracticeFormTest() {

        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        userEmail = faker.internet().emailAddress();
        phoneNumber = faker.phoneNumber().subscriberNumber(10);
        address = faker.address().fullAddress();

        open(url);
        setFullName(firstName, lastName);
        Data.emailField.setValue(userEmail);
        Data.telNumber.setValue(phoneNumber);
        DatePicker.fillDataPicker(day, month, year);
        setMathSubject();
        setMaleGender();
        setPicture(filePath);
        setFirstHobby();
        addressField.setValue(address);
        setNCR();
        setDelhiCity();
        submit();
        // checking results
        $(outputForm,0).shouldHave(text(firstName + " " + lastName), text("Student Name"));
        $(outputForm,1).shouldHave(text(userEmail), text("Student Email"));
        $(outputForm,2).shouldHave(text("Male"), text("Gender"));
        $(outputForm,3).shouldHave(text(phoneNumber), text("Mobile"));
        $(outputForm,4).shouldHave(text(bDay), text("Date of Birth"));
        $(outputForm,5).shouldHave(text("Maths"), text("Subjects"));
        $(outputForm,6).shouldHave(text("Sports"), text("Hobbies"));
        $(outputForm,7).shouldHave(text("photo.jpg"), text("Picture"));
        $(outputForm,8).shouldHave(text(address), text("Address"));
        $(outputForm,9).shouldHave(text("NCR Delhi "), text("State and City"));
    }
}
