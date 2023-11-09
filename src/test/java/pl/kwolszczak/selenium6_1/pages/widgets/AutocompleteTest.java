package pl.kwolszczak.selenium6_1.pages.widgets;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.kwolszczak.selenium6_1.BaseTest;

import java.time.Duration;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class AutocompleteTest extends BaseTest {

    private final String url = "http://www.seleniumui.moderntester.pl/autocomplete.php";
    private final Random random = new Random();
    private final Duration waitDuration =Duration.ofSeconds(5);

    //@Test
    @RepeatedTest(10)
    @DisplayName("Autocomplete")
    void autocompleteTest_basicTest() {
        driver.get(url);

        var wait = new WebDriverWait(driver, waitDuration);
        var searchInp = driver.findElement(By.id("search"));

        searchInp.sendKeys("a");
        var elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By.cssSelector("#ui-id-1 li div"))));
        elements.forEach(webElement -> System.out.println(webElement.getText()));

        var index = random.nextInt(0, elements.size());
        var text = elements.get(index).getText();
        elements.get(index).click();

        var textFromInp = searchInp.getAttribute("value");
        assertThat(textFromInp).isEqualTo(text);
    }
}
