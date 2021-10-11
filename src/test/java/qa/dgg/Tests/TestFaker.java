package qa.dgg.Tests;

import com.github.javafaker.Faker;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import qa.dgg.Components.DatePicker;
import qa.dgg.Utils.Base;
import qa.dgg.Utils.Variables;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class TestFaker extends Base{

    Faker faker = new Faker();

    @Test
    void fillPracticeFormTest() {

        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        userEmail = faker.internet().emailAddress();
        phoneNumber = faker.phoneNumber().subscriberNumber(10);
        address = faker.address().fullAddress();

        step("Открываем сайт с формой", () -> open(url));
        takeScreenshot();
        step("Вводим имя и фамилию", () -> setFullName(firstName, lastName));
        step("Вводим email", () -> Variables.emailField.setValue(userEmail));
        step("Вводим телефонный номер", () -> Variables.telNumber.setValue(phoneNumber));
        step("Вводим дату рождения", () -> DatePicker.fillDataPicker(day, month, year));
        step("Вводим любимый предмет", () -> setMathSubject());
        step("Вводим пол", () ->setMaleGender());
        step("Прикрепляем картинку", () ->setPicture("photo.jpg"));
        step("Вводим хобби", () -> setFirstHobby());
        step("Вводим адрес", () -> addressField.setValue(address));
        step("Вводим адрес страну", () -> setNCR());
        step("Вводим адрес город", () -> setDelhiCity());
        step("Подтверждаем заполненную форму", () -> submit());
        takeScreenshot();
        step("Проверка введенных данных заполненной форме", () -> {
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
    });
}}
