package pl.kwolszczak.selenium6_1.pages.others;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pl.kwolszczak.selenium6_1.BaseTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DemoQAPageTest extends BaseTest {

    //@Test
    @RepeatedTest(10)
    @DisplayName("DemoQa")
    void DemoQAPageTest_simpleTest() throws InterruptedException {

        driver.get("https://demoqa.com/automation-practice-form");
        var expectedResults = List.of("Maths", "Arts");
        var subject = driver.findElement(By.xpath("//input[@id=\"subjectsInput\"]"));

        subject.sendKeys("m");
        subject.sendKeys(Keys.ENTER);
        subject.sendKeys("a");
        subject.sendKeys(Keys.ARROW_DOWN);
        subject.sendKeys(Keys.ENTER);

        var subjectValues = driver.findElements(By.cssSelector("div#subjectsContainer  div[class*='label']"));
        var result = subjectValues.stream().map(WebElement::getText).toList();

        assertThat(result).isEqualTo(expectedResults);
    }
}
