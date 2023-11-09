package pl.kwolszczak.selenium6_1.pages.basic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pl.kwolszczak.selenium6_1.BaseTest;

import static pl.kwolszczak.selenium6_1.util.SeleniumUtil.*;

class IframePageTest extends BaseTest {

    //@Test
    @RepeatedTest(10)
    @DisplayName("Iframe")
    void iframePageTest_basicTest() {

        String url = "http://automation-practice.emilos.pl/iframes.php";
        driver.get(url);

        driver.switchTo().frame("iframe1");
        var name = driver.findElement(By.cssSelector("#inputFirstName3"));
        var lastName = driver.findElement(By.cssSelector("#inputSurname3"));
        var submit = driver.findElement(By.cssSelector("button[type='submit']"));

        fill(name, "Bobby");
        fill(lastName, "Burger");
        click(submit);

        driver.switchTo().defaultContent();
        driver.switchTo().frame("iframe2");
        var name2 = driver.findElement(By.cssSelector("#inputLogin"));
        var password = driver.findElement(By.cssSelector("#inputPassword"));
        var countrySelect = driver.findElement(By.cssSelector("#inlineFormCustomSelectPref"));
        var radioBtn = driver.findElement(By.cssSelector("#gridRadios3"));
        var submit2 = driver.findElement(By.cssSelector("button[type='submit']"));

        fill(name2, "Mickey");
        fill(password, "mouseMini@");
        selectByValues(countrySelect, "africa");
        click(radioBtn);
        click(submit2);

        driver.switchTo().defaultContent();
        click(driver.findElement(By.cssSelector("div.container li:first-child")));
        click(driver.findElement(By.cssSelector("#alerts-item")));
        Assertions.assertThat(driver.getCurrentUrl()).isEqualTo("http://automation-practice.emilos.pl/alerts.php");
    }
}
