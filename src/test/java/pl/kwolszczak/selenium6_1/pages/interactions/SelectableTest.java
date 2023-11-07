package pl.kwolszczak.selenium6_1.pages.interactions;

import dev.failsafe.internal.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pl.kwolszczak.selenium6_1.BaseTest;

import java.util.Arrays;
import java.util.List;

public class SelectableTest extends BaseTest {

    private String url ="http://automation-practice.emilos.pl/selectable.php";

    @Test
    //@RepeatedTest(10)
    @DisplayName("Selectable")
    void windowsPageTest_simple() throws InterruptedException {
        String[] options = {"1","3","4"};
        driver.get(url);
        List<WebElement> we = driver.findElements(By.cssSelector("#selectable li"));
        Actions actions = new Actions(driver);

      var li=we.stream()
              .peek(webElement -> System.out.println(webElement.getText()))
              .filter(webElement -> Arrays.stream(options).toList().contains((webElement.getText().split("\\s+"))[1])
                      )
              .toList();
             // .forEach(webElement -> System.out.println(webElement.getText()));
        actions.keyDown(Keys.LEFT_CONTROL).build().perform();
        li.forEach(w-> {
           w.click();

        });
        System.out.println(driver.findElement(By.cssSelector("#select-result")).getText());

        Thread.sleep(5000);
        }

}
