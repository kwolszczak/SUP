package pl.kwolszczak.selenium6_1.pages.widgets;

import org.awaitility.Awaitility;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.kwolszczak.selenium6_1.BaseTest;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

class ProgressbarTest extends BaseTest {

    private final String url = "http://www.seleniumui.moderntester.pl/progressbar.php";
    private final String expectedResult = "Complete!";

    //@Test
    @RepeatedTest(10)
    @DisplayName("Progressbar text")
    void ProgressbarTest_simpleTest() {
        driver.get(url);
        WebElement progressbar = driver.findElement(By.cssSelector("#progressbar div[class='progress-label']"));

        Awaitility.waitAtMost(Duration.ofSeconds(15))
                .until(() -> progressbar.getText().equals("Complete!"));

        var result = progressbar.getText();
        assertThat(result).isEqualTo(expectedResult);
    }

    //@Test
    @RepeatedTest(10)
    @DisplayName("class attribute ")
    void ProgressbarTest_simpleTest2() {
        driver.get(url);
        WebElement progressbar = driver.findElement(By.cssSelector("#progressbar div[class='progress-label']"));

        Awaitility.waitAtMost(Duration.ofSeconds(15))
                .until(() -> {
                            var bar = driver.findElement(By.cssSelector("#progressbar > div:nth-child(2)"));
                            return bar.getAttribute("class").contains("ui-progressbar-complete");}
                );

        var result = progressbar.getText();
        assertThat(result).isEqualTo(expectedResult);
    }

    //@Test
    @RepeatedTest(10)
    @DisplayName("webdriver wait ")
    void ProgressbarTest_simpleTest3() {
        driver.get(url);
        var progressbar = driver.findElement(By.cssSelector("#progressbar div[class='progress-label']"));
        var bar = driver.findElement(By.cssSelector("#progressbar > div:nth-child(2)"));
        var wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(ExpectedConditions.attributeContains(bar, "class", "ui-progressbar-complete"));

        var result = progressbar.getText();
        assertThat(result).isEqualTo(expectedResult);
    }
}
