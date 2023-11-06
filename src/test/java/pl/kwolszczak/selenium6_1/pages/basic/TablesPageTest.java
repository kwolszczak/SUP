package pl.kwolszczak.selenium6_1.pages.basic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pl.kwolszczak.selenium6_1.BaseTest;

import java.util.Arrays;
import java.util.List;

public class TablesPageTest extends BaseTest {

    @Test
    //@RepeatedTest(10)
    @DisplayName("Iframe")
    void tablesPageTest_simple(){
        String url ="http://www.seleniumui.moderntester.pl/table.php";
        driver.get(url);

        List<WebElement> rows = driver.findElements(By.cssSelector("table tbody tr"));
        System.out.println(rows.size());
       var listM= rows.stream()
                .filter(w->Integer.parseInt(w.findElement(By.xpath("./td[4]")).getText() )> 4000)
                .filter(w -> Arrays.stream(w.findElement(By.xpath("./td[3]")).getText().split(",")).toList().contains("Switzerland"))
                .toList();
                //.forEach(s-> System.out.println(s.findElement(By.xpath("./td[3]")).getText()));
        listM.stream()
                .map(s->s.getText().split("\\s+"))
                .forEach(s-> System.out.println(s[0]+" "+s[1]+" "+s[2]));
    }
}
