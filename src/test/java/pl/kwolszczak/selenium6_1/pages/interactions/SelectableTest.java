package pl.kwolszczak.selenium6_1.pages.interactions;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pl.kwolszczak.selenium6_1.BaseTest;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class SelectableTest extends BaseTest {

    private String url = "http://automation-practice.emilos.pl/selectable.php";

    @Test
    //@RepeatedTest(10)
    @DisplayName("Selectable")
    void windowsPageTest_simple() {

        driver.get(url);
        var expectedResult = "#1 #3 #4";
        var options = new String[]{"1", "3", "4"};
        var allBtn = driver.findElements(By.cssSelector("#selectable li"));
        var actions = new Actions(driver);

        var listBtn = allBtn.stream()
                .peek(WebElement::getText)
                .filter(webElement -> Arrays.stream(options)
                        .toList()
                        .contains((webElement.getText().split("\\s+"))[1]))
                .toList();

        actions.keyDown(Keys.LEFT_CONTROL).build().perform();
        listBtn.forEach(WebElement::click);

        var result = driver.findElement(By.cssSelector("#select-result")).getText();
        assertThat(result).isEqualTo(expectedResult);
    }

}
