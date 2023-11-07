package pl.kwolszczak.selenium6_1.pages.others;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pl.kwolszczak.selenium6_1.BaseTest;

import java.util.List;

public class DemoQAPageTest extends BaseTest {

    @Test
    //@RepeatedTest(10)
    @DisplayName("DemoQa")
    void DemoQAPageTest_simpleTest() throws InterruptedException {
        driver.get("https://demoqa.com/automation-practice-form");

        List<String> expectedResults = List.of("Maths", "Arts");
        WebElement subject = driver.findElement(By.xpath("//input[@id=\"subjectsInput\"]"));

        subject.sendKeys("m");
        subject.sendKeys(Keys.ENTER);

        subject.sendKeys("a");
        subject.sendKeys(Keys.ARROW_DOWN);
        subject.sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        List<WebElement> subjectValues = driver.findElements(By.cssSelector("div#subjectsContainer  div[class*='label']"));
        List<String> result = subjectValues.stream().map(WebElement::getText).toList();

        Assertions.assertThat(result).isEqualTo(expectedResults);

    }
}
