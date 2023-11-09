package pl.kwolszczak.selenium6_1.pages.widgets.datepicker;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.kwolszczak.selenium6_1.BaseTest;

import java.time.Duration;
import java.time.Month;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.kwolszczak.selenium6_1.pages.widgets.datepicker.CalendarUtil.selectDate;

class DatepickerTest extends BaseTest {
    private final String url = "http://www.seleniumui.moderntester.pl/datepicker.php";
    private Random random = new Random();

    //@Test
    @RepeatedTest(10)
    @DisplayName("date picker")
    void datepickerPage_simpleTest() {

        CalendarUtil.init(driver);
        var randDay = random.nextInt(1, 30);

        // MM/DD/YYYY format
        String today = "11/09/2023"; // today
        String nextMonth = "12/01/2023"; // 1 day next month
        String mydate2 = "01/31/2024"; // 31 Jan next year
        String mydate3 = "01/31/2024"; // prev date
        String mydate4 = String.format("10/%02d/2023", randDay); // random day prev month
        String mydate5 = String.format("05/%02d/2022", randDay); // random day from last year

        var listDate = List.of(today, nextMonth, mydate2, mydate3, mydate4, mydate5);

        driver.get(url);
        var wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        var datePicker = driver.findElement(By.id("datepicker"));


        for (var date : listDate) {
            datePicker.click();
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("ui-datepicker-title"))));
            selectDate(date);

            var result = datePicker.getAttribute("value");
            assertThat(result).isEqualTo(date);
        }

    }


}
