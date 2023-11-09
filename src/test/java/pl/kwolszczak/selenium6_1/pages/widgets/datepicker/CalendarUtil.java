package pl.kwolszczak.selenium6_1.pages.widgets.datepicker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Month;

public class CalendarUtil {

    private static WebDriver driver;

    static void init(WebDriver webdriver) {
        driver = webdriver;
    }

    static void selectDate(String date) {

        var calYear = getYearFromCalendar();
        var calMonth = getMonthFromCalendar();
        Calendar searchDate = parseDate(date);
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

    private static Calendar parseDate(String date) {
        var parsedDate = date.split("/");
        var year = Integer.parseInt(parsedDate[2]);
        var month = Integer.parseInt(parsedDate[0].replaceFirst("^0", ""));
        var day = parsedDate[1].replaceFirst("^0", "");
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
