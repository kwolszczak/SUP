package pl.kwolszczak.selenium6_1.pages.basic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import pl.kwolszczak.selenium6_1.BaseTest;

public class IframePageTest extends BaseTest {

    @Test
    //@RepeatedTest(10)
    @DisplayName("Iframe")
    void iframePageTest_first() throws InterruptedException {
        String url = "http://automation-practice.emilos.pl/iframes.php";
        driver.get(url);

        driver.switchTo().frame("iframe1");
        driver.findElement(By.cssSelector("#inputFirstName3")).sendKeys("name");
        driver.findElement(By.cssSelector("#inputSurname3")).sendKeys("lastname");

        driver.findElement(By.cssSelector("button[type='submit']")).click();
        driver.switchTo().defaultContent();


        driver.switchTo().frame("iframe2");
        driver.findElement(By.cssSelector("#inputLogin")).sendKeys("name");
        driver.findElement(By.cssSelector("#inputPassword")).sendKeys("pass");
        Select select = new Select(driver.findElement(By.cssSelector("#inlineFormCustomSelectPref")));
        select.selectByValue("africa");

        driver.findElement(By.cssSelector("#gridRadios3")).click();

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        driver.switchTo().defaultContent();

    }
}
