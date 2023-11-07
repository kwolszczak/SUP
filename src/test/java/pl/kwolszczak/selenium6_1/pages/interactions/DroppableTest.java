package pl.kwolszczak.selenium6_1.pages.interactions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pl.kwolszczak.selenium6_1.BaseTest;

public class DroppableTest extends BaseTest {

        private String url ="http://automation-practice.emilos.pl/droppable.php";

        @Test
        //@RepeatedTest(10)
        @DisplayName("Selectable")
        void droppablePageTest_simple() throws InterruptedException {
                driver.get(url);
                WebElement source = driver.findElement(By.cssSelector("#draggable"));
                WebElement target = driver.findElement(By.cssSelector("#droppable"));

                Actions actions = new Actions(driver);
                actions.dragAndDrop(source,target).build().perform();

                System.out.println(target.findElement(By.xpath("./p")).getText());
                Thread.sleep(5000);

        }
}

