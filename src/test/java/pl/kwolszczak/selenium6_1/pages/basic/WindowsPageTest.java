package pl.kwolszczak.selenium6_1.pages.basic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import pl.kwolszczak.selenium6_1.BaseTest;

import java.util.*;

public class WindowsPageTest extends BaseTest {
    private String url ="http://www.seleniumui.moderntester.pl/windows-tabs.php";

    @Test
    //@RepeatedTest(10)
    @DisplayName("Iframe")
    void windowsPageTest_simple() throws InterruptedException {
     driver.get(url);

     driver.findElement(By.cssSelector("#newBrowserWindow")).click();
        Set<String> windowHandles = driver.getWindowHandles();


        Iterator<String> iterator = windowHandles.iterator();
        String firstWindowHandle = iterator.next(); // Get the first handle
        String secondWindowHandle = iterator.next(); // Get the second handle

        driver.switchTo().window(secondWindowHandle);
        Actions actions = new Actions(driver);
        actions.scrollByAmount(100,800).build().perform();

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

        driver.close();
        driver.switchTo().window(firstWindowHandle);

        driver.findElement(By.cssSelector("#newMessageWindow")).click();

        windowHandles = driver.getWindowHandles();

       iterator = windowHandles.iterator();
         firstWindowHandle = iterator.next(); // Get the first handle
        String thirddWindowHandle = iterator.next();
        driver.switchTo().window(thirddWindowHandle);
        System.out.println(driver.findElement(By.cssSelector("body")).getText());
        driver.close();
        driver.switchTo().window(firstWindowHandle);
        driver.findElement(By.cssSelector("#newBrowserTab")).click();

        windowHandles = driver.getWindowHandles();
        iterator = windowHandles.iterator();
        firstWindowHandle = iterator.next(); // Get the first handle
        String fourthdWindowHandle = iterator.next();
        driver.switchTo().window(fourthdWindowHandle);

        Actions actions2 = new Actions(driver);
        actions.scrollByAmount(100,800).build().perform();

        List<WebElement> rows2 = driver.findElements(By.cssSelector("table tbody tr"));
        System.out.println(rows.size());
        var listM2= rows2.stream()
                .filter(w->Integer.parseInt(w.findElement(By.xpath("./td[4]")).getText() )<4000)
                .filter(w -> Arrays.stream(w.findElement(By.xpath("./td[3]")).getText().split(",")).toList().contains("Spain"))
                .toList();
        //.forEach(s-> System.out.println(s.findElement(By.xpath("./td[3]")).getText()));
        listM2.stream()
                .map(s->s.getText().split("\\s+"))
                .forEach(s-> System.out.println(s[0]+" "+s[1]+" "+s[2]));
        Thread.sleep(5000);
    }
}
