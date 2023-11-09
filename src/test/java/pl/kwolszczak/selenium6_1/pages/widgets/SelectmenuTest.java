package pl.kwolszczak.selenium6_1.pages.widgets;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.kwolszczak.selenium6_1.BaseTest;

import java.time.Duration;
import java.util.List;
import java.util.Random;

class SelectmenuTest extends BaseTest {

    private final String url = "http://www.seleniumui.moderntester.pl/selectmenu.php";
    private final Random random = new Random();


    @Test
    //@RepeatedTest(10)
    @DisplayName("select menu")
    void selectMenuTest_simpleTest() {

        driver.get(url);
        var speedM = driver.findElement(By.cssSelector("span#speed-button"));
        int speedRand = random.nextInt( 0,5);
        speedM.click();
        List<WebElement> speed = driver.findElements(By.cssSelector("ul#speed-menu li"));
        speed.get(speedRand).click();

        var fileM = driver.findElement(By.cssSelector("span#files-button"));
        var text = "Some unknown file";
        fileM.click();
        List<WebElement> file = driver.findElements(By.cssSelector("ul#files-menu li div"));
        file.stream()
               .filter(we->we.getText().equals(text))
               .forEach(WebElement::click);

    }
}
