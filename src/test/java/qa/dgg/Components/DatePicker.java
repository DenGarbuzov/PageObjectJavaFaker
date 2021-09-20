package qa.dgg.Components;

import qa.dgg.Utils.Data;

import static com.codeborne.selenide.Selenide.$;

public class DatePicker extends Data {

    public static void fillDataPicker(int day, String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption(year);
        String selector = ".react-datepicker__day--00%d:not(.react-datepicker__day--outside-month)";
        String formatedSelector = String.format(selector, day);
        $(formatedSelector).click();
    }
}
