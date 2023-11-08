package pl.kwolszczak.selenium6_1.pages.widgets;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.kwolszczak.selenium6_1.BaseTest;

import java.time.Duration;

class AccordionTest extends BaseTest {

    private String url = "http://www.seleniumui.moderntester.pl/accordion.php";

    @Test
    //@RepeatedTest(10)
    @DisplayName("Accordion")
    void accordionPageTest_simpleTest() {

        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.findElement(By.cssSelector("#ui-id-5")).click();

     wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//h3[@id='ui-id-5']/following-sibling::div[1]/*"))));

        driver.findElements(By.xpath("//h3[@id='ui-id-5']/following-sibling::div[1]/*"))
                .stream()
                .map(WebElement::getText)
                .filter(s -> !s.isEmpty())
                .forEach(System.out::println);


        driver.findElement(By.cssSelector("#ui-id-7")).click();
      wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//h3[@id='ui-id-7']/following-sibling::div[1]/*"))));

        driver.findElements(By.xpath("//h3[@id='ui-id-7']/following-sibling::div[1]/*"))
                .stream()
                .map(WebElement::getText)
                .filter(s -> !s.isEmpty())
                .forEach(System.out::println);


    }
}
