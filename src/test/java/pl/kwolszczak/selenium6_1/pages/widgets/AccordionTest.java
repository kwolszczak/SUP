package pl.kwolszczak.selenium6_1.pages.widgets;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.kwolszczak.selenium6_1.BaseTest;

import java.time.Duration;

class AccordionTest extends BaseTest {

    private String url = "http://www.seleniumui.moderntester.pl/accordion.php";

   // @Test
    @RepeatedTest(10)
    @DisplayName("Accordion")
    void accordionPageTest_simpleTest() {

        driver.get(url);
        var wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        for (int i = 1; i <= 7; i += 2) {
            var selector = "#ui-id-" + i;
            var childSelector = "//h3[@id='ui-id-" + i + "']/following-sibling::div[1]/*";

            driver.findElement(By.cssSelector(selector)).click();
            wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(childSelector))));
            printData(childSelector, driver);
        }

    }

    private static void printData(String selector, WebDriver driver) {
        driver.findElements(By.xpath(selector))
                .stream()
                .map(WebElement::getText)
                .filter(s -> !s.isEmpty())
                .forEach(System.out::println);
    }
}
