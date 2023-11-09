package pl.kwolszczak.selenium6_1.pages.widgets;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
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

class Calendar {
    private int year;
    private int month;
    private String day;

    public Calendar(int year, int month) {
        this(year, month, "");
    }

    public Calendar(int year, int month, String day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }
}

class DatepickerTest extends BaseTest {
    private final String url = "http://www.seleniumui.moderntester.pl/datepicker.php";
    private Random random = new Random();

    //@Test
    @RepeatedTest(10)
    @DisplayName("date picker")
    void datepickerPage_simpleTest() {

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

    private static void selectDate(String date) {

//check year , month
        var calYear = getYearFromCalendar();
        var calMonth = getMonthFromCalendar();
        Calendar searchDate = parsedate(date);
        Calendar calendar = new Calendar(calYear, calMonth);

        while (calendar.getYear() != searchDate.getYear() || calendar.getMonth() != searchDate.getMonth()) {
            if (calendar.getYear() > searchDate.getYear() || (calendar.getYear() == searchDate.getYear() && calendar.getMonth() > searchDate.getMonth())) {
                changeMonth("Prev");
            } else {
                changeMonth("Next");
            }
            updateCalendar(calendar);
        }

        changeDay(searchDate.getDay());
    }

    private static Calendar parsedate(String date) {
        var parsedDate = date.split("/");
        var year = Integer.parseInt(parsedDate[2]);
        var month = Integer.parseInt(parsedDate[0].replaceFirst("^0", ""));
        var day = parsedDate[1].replaceAll("^0", "");
        return new Calendar(year, month, day);
    }

    private static void updateCalendar(Calendar calendar) {
        calendar.setMonth(getMonthFromCalendar());
        calendar.setYear(getYearFromCalendar());
    }

    private static void changeDay(String searchDay) {
        var dateTable = driver.findElements(By.xpath("//tbody //td[not(contains(@class,'ui-datepicker-other-month'))]"));

        for (var dayElement : dateTable) {
            var dayLink = dayElement.findElement(By.xpath("./a"));
            if (searchDay.equals(dayLink.getText())) {
                dayLink.click();
                break;
            }
        }
    }

    private static void changeMonth(String prevOrNext) {
        //Prev Next
        driver.findElement(By.xpath("//a[@title='" + prevOrNext + "']")).click();
        new Actions(driver).moveByOffset(10, 10).perform();
    }

    private static int getYearFromCalendar() {
        var year = driver.findElement(By.cssSelector("span.ui-datepicker-year")).getText();
        return Integer.parseInt(year);
    }

    private static int getMonthFromCalendar() {
        var monthName = driver.findElement(By.cssSelector("span.ui-datepicker-month")).getText();
        return Month.valueOf(monthName.toUpperCase()).getValue();
    }
}
