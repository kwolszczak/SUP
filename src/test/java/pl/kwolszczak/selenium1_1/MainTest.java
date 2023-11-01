package pl.kwolszczak.selenium1_1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

class MainTest extends BaseTest {

    @Test
    @DisplayName("Single value")
    void verify_disappearingList_singleValue() {

        String expectedResult = "Commerce";
        WebElement subjectInput = driver.findElement(By.xpath("//input[@id=\"subjectsInput\"]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(subjectInput)
                .click()
                .sendKeys("com")
                .sendKeys(subjectInput, Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER)
                .build().perform();

        WebElement subjectValue = driver.findElement(By.cssSelector("div#subjectsContainer  div[class*='label']"));
        var result = subjectValue.getText();

        Assertions.assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Multi values")
    void verify_disappearingList_multiValues() {

        List<String> expectedResults = List.of("Commerce", "Computer Science");
        WebElement subject = driver.findElement(By.xpath("//input[@id=\"subjectsInput\"]"));

        subject.sendKeys("com");
        subject.sendKeys(Keys.ARROW_DOWN);
        subject.sendKeys(Keys.ENTER);

        subject.sendKeys("com");
        subject.sendKeys(Keys.ARROW_DOWN);
        subject.sendKeys(Keys.ENTER);

        List<WebElement> subjectValues = driver.findElements(By.cssSelector("div#subjectsContainer  div[class*='label']"));
        List<String> result = subjectValues.stream().map(WebElement::getText).toList();

        Assertions.assertThat(result).isEqualTo(expectedResults);
    }

}