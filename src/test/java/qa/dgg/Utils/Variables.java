package qa.dgg.Utils;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class Variables {

   public static String firstName = "Mike",
   lastName = "Wasovskiy",
   userEmail = "monster@corporation.com",
   phoneNumber = "1234567890",
   address = "Monster town",
   bDay = "07 May,1988",
   url = "https://demoqa.com/automation-practice-form",
   month = "May",
   year = "1988",
   outputForm = ".table-responsive tbody tr";

   public static Integer day = 7;

   public static SelenideElement firstNameField = $("#firstName"),
   lastNameField = $("#lastName"),
   emailField = $("#userEmail"),
   telNumber = $("#userNumber"),
   subject = $("#subjectsInput"),
   maleGender = $("[for=gender-radio-1]"),
   upload = $("#uploadPicture"),
   addressField = $("#currentAddress"),
   state = $("#state"),
   city = $("#city"),
   submitBtn = $("#submit");

}
