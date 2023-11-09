package pl.kwolszczak.selenium6_1.pages.interactions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import pl.kwolszczak.selenium6_1.BaseTest;

import static org.assertj.core.api.Assertions.assertThat;

class DroppableTest extends BaseTest {

    //@Test
    @RepeatedTest(10)
    @DisplayName("Selectable")
    void droppablePageTest_simple() throws InterruptedException {

        String url = "http://automation-practice.emilos.pl/droppable.php";
        driver.get(url);
        var source = driver.findElement(By.cssSelector("#draggable"));
        var target = driver.findElement(By.cssSelector("#droppable"));
        var expectedResult = "Dropped!";

        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).build().perform();

        var result = target.findElement(By.xpath("./p")).getText();
        assertThat(result).isEqualTo(expectedResult);
    }
}

