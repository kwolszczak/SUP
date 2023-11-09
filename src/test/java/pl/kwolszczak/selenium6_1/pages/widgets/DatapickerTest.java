package pl.kwolszczak.selenium6_1.pages.widgets;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pl.kwolszczak.selenium6_1.BaseTest;

import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;

class Calendar{
    private int year;
    private int month;
    private String day;

    public Calendar(int year, int month) {
        this(year,month,"");
    }

    public Calendar(int year, int month, String day) {
        this.year = year;
        this.month = month;
        this.day =day;
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

class DatapickerTest extends BaseTest {
    private final String url = "http://www.seleniumui.moderntester.pl/datepicker.php";

    @Test
    //@RepeatedTest(10)
    @DisplayName("Data picker")
    void datapickerPage_simpleTest() {

        driver.get(url);
        driver.findElement(By.id("datepicker")).click();
        //  LocalDate.now(); 2023-11-09
        // selectData(LocalDate.now().toString(), driver);
        String myData = "05/02/2024";
        selectData(myData);

        var selectedData = driver.findElement(By.id("datepicker")).getAttribute("value");
        assertThat(selectedData).isEqualTo(myData);
  /*    driver.findElement(By.id("datepicker")).sendKeys(Keys.DELETE);
        driver.findElement(By.id("datepicker")).click();

        String myData2 = "05/02/2022";
        selectData(myData2);

        var selectedData2 = driver.findElement(By.id("datepicker")).getAttribute("value");
        assertThat(selectedData2).isEqualTo(myData2);*/
    }

    private static void selectData(String data) {

//check year , month
        var calYear = getYearFromCalendar();
        var calMonth = getMonthFromCalendar();
        Calendar searchData = parseData(data);
        Calendar calendar = new Calendar(calYear, calMonth);


        while (calendar.getYear() > searchData.getYear() || calendar.getMonth() > searchData.getMonth()) {
            changeMonth("Prev");
            updateCalendar(calendar);
        }
        while (calendar.getYear()< searchData.getYear() || calendar.getMonth()< searchData.getMonth()) {
            changeMonth("Next");
            updateCalendar(calendar);
        }

        //check day
        changeDay(searchData.getDay());
    }

    private static Calendar parseData(String data){
        var myData = data.split("/");
        var year = Integer.parseInt(myData[2]);
        var month = Integer.parseInt(myData[0].replaceAll("^0", ""));
        var day = myData[1].replaceAll("^0", "");
        return new Calendar(year,month,day);
    }

    private static void updateCalendar(Calendar calendar){
            calendar.setMonth(getMonthFromCalendar());
            calendar.setYear(getYearFromCalendar());
    }

    private static void changeDay(String searchDay) {
        var dataTable = driver.findElements(By.xpath("//tbody //td"));
        for (var we : dataTable) {
            if (!we.getAttribute("class").equals(" ui-datepicker-other-month ")) {
                if (we.findElement(By.xpath("./a")).getText().equals(searchDay)) {
                    we.findElement(By.xpath("./a")).click();
                    break;
                }
            }
        }
    }

    private static void changeMonth(String prevOrNext){
        //Prev Next
        driver.findElement(By.xpath("//a[@title='"+prevOrNext+"']")).click();
        new Actions(driver).moveByOffset(10, 10).perform();
    }

    private static int getYearFromCalendar(){
        return Integer.parseInt(driver.findElement(By.cssSelector("span.ui-datepicker-year")).getText());
    }

    private static int getMonthFromCalendar(){
        var monthName = driver.findElement(By.cssSelector("span.ui-datepicker-month")).getText();
        var calMonth = Month.valueOf(monthName.toUpperCase());
        return calMonth.getValue();
    }
}
