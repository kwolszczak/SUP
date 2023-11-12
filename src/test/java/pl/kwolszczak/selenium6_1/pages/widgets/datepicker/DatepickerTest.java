package pl.kwolszczak.selenium6_1.pages.widgets.datepicker;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.kwolszczak.selenium6_1.BaseTest;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.kwolszczak.selenium6_1.pages.widgets.datepicker.CalendarUtil.selectDate;

class DatepickerTest extends BaseTest {
    private final String url = "http://www.seleniumui.moderntester.pl/datepicker.php";

    //@Test
    @RepeatedTest(1)
    @DisplayName("date picker")
    void datepickerPage_simpleTest() {

        CalendarUtil.init(driver);
        LocalDate now = LocalDate.now();

        var formatter = DateTimeFormatter.ofPattern("MM/dd/yyy");
        String today = now.format(formatter);
        String nextMonth1Day = now.plusMonths(1).withDayOfMonth(1).format(formatter);
        String nextYear31January = now.plusYears(1).withMonth(1).withDayOfMonth(31).format(formatter);
        String randomDayOfPrevMonth = randomDate("2023-10-01", "2023-10-31");
        String randomDayOfPrevYear = randomDate("2022-01-01", "2022-12-31");
        var listDate = List.of(today, nextMonth1Day, nextYear31January, nextYear31January, randomDayOfPrevMonth, randomDayOfPrevYear);


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

    private static String randomDate(String start, String end) {
        Random random = new Random();

        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);

        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        var randomDays = random.nextLong() % daysBetween;
        LocalDate randomDate = startDate.plusDays(randomDays);

        return String.format("%02d/%02d/%02d", randomDate.getMonthValue(), randomDate.getDayOfMonth(), randomDate.getYear());
    }


}
