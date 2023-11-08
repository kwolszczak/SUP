package pl.kwolszczak.selenium6_1.pages.widgets;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pl.kwolszczak.selenium6_1.BaseTest;

import static org.assertj.core.api.Assertions.assertThat;

class SliderPageTest extends BaseTest {

    private String url = "http://www.seleniumui.moderntester.pl/slider.php";

    @Test
    //@RepeatedTest(10)
    @DisplayName("Slider")
    void sliderPageTest_simpleTest() {

        driver.get(url);
        var handle = driver.findElement(By.id("custom-handle"));
        var expectedResult = 0;

        moveSlider(50, driver);
        moveSlider(80, driver);
        moveSlider(80, driver);
        moveSlider(20, driver);
        moveSlider(expectedResult, driver);

        var result = Integer.parseInt(handle.getText());
        assertThat(result).isEqualTo(expectedResult);
    }

    private static void moveSlider(int position, WebDriver driver) {

        Actions actions = new Actions(driver);
        var handle = driver.findElement(By.id("custom-handle"));
        var handleValue = Integer.parseInt(handle.getText());
        int move = position - handleValue;

        if (move > 0) {
            for (int i = 0; i < move; i++) {
                actions.sendKeys(handle)
                        .sendKeys(Keys.ARROW_RIGHT)
                        .build().perform();
            }
        } else {
            for (int i = 0; i > move; i--) {
                actions.sendKeys(handle)
                        .sendKeys(Keys.ARROW_LEFT)
                        .build().perform();
            }
        }
    }
}
