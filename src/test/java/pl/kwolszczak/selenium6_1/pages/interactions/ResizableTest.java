package pl.kwolszczak.selenium6_1.pages.interactions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import pl.kwolszczak.selenium6_1.BaseTest;

import static org.assertj.core.api.Assertions.assertThat;

class ResizableTest extends BaseTest {

    private String url = "http://www.seleniumui.moderntester.pl/resizable.php";

    //@Test
    @RepeatedTest(10)
    @DisplayName("Resizable Test")
    void resizablePageTest_simpleTest() {

        int xOffset = 100;
        int unexpectedOffset = -36; //after every single resize -18 px; 2 actions(resize X, resize xy -18px-18px on x), (resize y, resize xy-18px-18px)
        int yOffset = 100;
        int xyOffset = 100;

        driver.get(url);
        var rightDownBtn = driver.findElement(By.cssSelector("div#resizable div[class*='ui-resizable-se']"));
        var rightBtn = driver.findElement(By.cssSelector("div#resizable div[class*='ui-resizable-e']"));
        var downBtn = driver.findElement(By.cssSelector("div#resizable div[class*='ui-resizable-s']"));
        var widget = driver.findElement(By.cssSelector("div#resizable"));
        var expectedWidth = widget.getSize().width + xOffset + xyOffset + unexpectedOffset;
        var expectedHeight = widget.getSize().height + yOffset + xyOffset + unexpectedOffset;

        Actions actions = new Actions(driver);
        actions.dragAndDropBy(rightBtn, xOffset, 0).build().perform();
        actions.dragAndDropBy(downBtn, 0, yOffset).build().perform();
        actions.dragAndDropBy(rightDownBtn, xyOffset, xyOffset).build().perform();

        var actualHeight = widget.getSize().height;
        var actualWidth = widget.getSize().width;
        assertThat(actualHeight).isEqualTo(expectedHeight);
        assertThat(actualWidth).isEqualTo(expectedWidth);
    }
}
