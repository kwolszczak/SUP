package pl.kwolszczak.selenium6_1.pages.widgets;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pl.kwolszczak.selenium6_1.BaseTest;

class MenuTest extends BaseTest {

    private String url = "http://www.seleniumui.moderntester.pl/menu-item.php";

    //@Test
    @RepeatedTest(10)
    @DisplayName("Menu")
    void menuTest_simpleTest()  {

        driver.get(url);
        driver.findElement(By.id("ui-id-9")).click();
        driver.findElement(By.id("ui-id-13")).click();
        driver.findElement(By.id("ui-id-16")).click();
    }

}
