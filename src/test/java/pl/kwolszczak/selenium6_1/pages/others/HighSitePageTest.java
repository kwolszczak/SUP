package pl.kwolszczak.selenium6_1.pages.others;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import pl.kwolszczak.selenium6_1.BaseTest;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class HighSitePageTest extends BaseTest {

    @Test
    //@RepeatedTest(10)
    @DisplayName("High Test Scroll")
    void highPageTest_scroll_whenUseScrollOption() throws IOException {
        driver.get("http://automation-practice.emilos.pl/high-site.php");
        boolean isVisible = false;
        Actions actions = new Actions(driver);
        WebElement visibleBtn;




        while (!isVisible) {
            actions.scrollByAmount(0, 100).build().perform();
            try {
                visibleBtn = driver.findElement(By.cssSelector("input#scroll-button"));
                isVisible = visibleBtn.isDisplayed();
                System.out.println("founded");
            } catch (Exception e) {
                System.out.println("not visible yet");
            }
        }

        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String path = "target/screenshot.png";
        FileUtils.copyFile(screenshot, new File(path));

    }
    @Test
    //@RepeatedTest(10)
    @DisplayName("High Test JSExecutor")
    void highPageTest_scroll_whenUseJSExecutor() throws IOException {
        driver.get("http://automation-practice.emilos.pl/high-site.php");
        boolean isVisible = false;

        WebElement visibleBtn;
        JavascriptExecutor jsExec = (JavascriptExecutor)driver ;



        while (!isVisible) {
            jsExec.executeScript("window.scrollBy(0,100)");
            try {
                visibleBtn = driver.findElement(By.cssSelector("input#scroll-button"));
                isVisible = visibleBtn.isDisplayed();
                System.out.println("founded");
            } catch (Exception e) {
                System.out.println("not visible yet");
            }
        }


        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String path = "target/screenshot.png";
        FileUtils.copyFile(screenshot, new File(path));

    }
}
