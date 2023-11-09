package pl.kwolszczak.selenium6_1.pages.widgets;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pl.kwolszczak.selenium6_1.BaseTest;

import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;


public class DatapickerTest extends BaseTest {
    private final String url = "http://www.seleniumui.moderntester.pl/datepicker.php";

    @Test
    //@RepeatedTest(10)
    @DisplayName("Data picker")
    void datapickerPage_simpleTest() throws InterruptedException {

        driver.get(url);
driver.findElement(By.id("datepicker")).click();
      //  LocalDate.now(); 2023-11-09
       // selectData(LocalDate.now().toString(), driver);
        String myData="05/02/2022";
        selectData(myData, driver);

       var selectedData= driver.findElement(By.id("datepicker")).getAttribute("value");
        assertThat(selectedData).isEqualTo(myData);
     //   selectData("2024-05-02", driver);


        Thread.sleep(5000);
    }

    private static void selectData(String data, WebDriver driver) {
     var myData = data.split("/");
     var year = myData[2];
     var month = myData[0].replaceAll("^0","");
     var day = myData[1].replaceAll("^0","");
     System.out.println("year :"+year+ " month: "+month+" day: "+day);
//check year , month
     var calYear = Integer.parseInt(driver.findElement(By.cssSelector("span.ui-datepicker-year")).getText());
     var monthName = driver.findElement(By.cssSelector("span.ui-datepicker-month")).getText();
        Month calMonth = Month.valueOf(monthName.toUpperCase());
        int calMonthValue = calMonth.getValue();

     while (calYear >Integer.parseInt(year)) {
         driver.findElement(By.xpath("//a[@title='Prev']")).click();
         calYear = Integer.parseInt(driver.findElement(By.cssSelector("span.ui-datepicker-year")).getText());
         new Actions(driver).moveByOffset(10,10).perform();

         monthName = driver.findElement(By.cssSelector("span.ui-datepicker-month")).getText();
         calMonth = Month.valueOf(monthName.toUpperCase());
         calMonthValue = calMonth.getValue();

     }
        while (calYear <Integer.parseInt(year)) {
            driver.findElement(By.xpath("//a[@title='Next']")).click();
            calYear = Integer.parseInt(driver.findElement(By.cssSelector("span.ui-datepicker-year")).getText());
            new Actions(driver).moveByOffset(10,10).perform();

            monthName = driver.findElement(By.cssSelector("span.ui-datepicker-month")).getText();
            calMonth = Month.valueOf(monthName.toUpperCase());
            calMonthValue = calMonth.getValue();

        }

        while (calMonthValue > Integer.parseInt(month)) {
            driver.findElement(By.xpath("//a[@title='Prev']")).click();
            monthName = driver.findElement(By.cssSelector("span.ui-datepicker-month")).getText();
             calMonth = Month.valueOf(monthName.toUpperCase());
             calMonthValue = calMonth.getValue();
          new Actions(driver).moveByOffset(10,10).perform();
        }


        while (calMonthValue < Integer.parseInt(month)) {
            driver.findElement(By.xpath("//a[@title='Next']")).click();
            monthName = driver.findElement(By.cssSelector("span.ui-datepicker-month")).getText();
            calMonth = Month.valueOf(monthName.toUpperCase());
            calMonthValue = calMonth.getValue();
            new Actions(driver).moveByOffset(10,10).perform();
        }


     //check day
        var dataTable = driver.findElements(By.xpath("//tbody //td"));
        for (var we : dataTable) {
            if(!we.getAttribute("class").equals(" ui-datepicker-other-month ")){
                if(we.findElement(By.xpath("./a")).getText().equals(day)){
                    System.out.println("founded day");
                    we.findElement(By.xpath("./a")).click();
                    break;

                }
            }

        }

    }
}
