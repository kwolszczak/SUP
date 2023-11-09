package pl.kwolszczak.selenium6_1.pages.basic;

import org.awaitility.Awaitility;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.kwolszczak.selenium6_1.BaseTest;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.kwolszczak.selenium6_1.util.SeleniumUtil.click;

class AlertsPageTest extends BaseTest {

    private final Logger log = LoggerFactory.getLogger(AlertsPage.class);
    private final String url = "http://www.seleniumui.moderntester.pl/alerts.php";

    //@Test
   @RepeatedTest(10)
    @DisplayName("Simple Alert Pop up")
    void alertsPage_SimpleAlertPopUp_whenAccept() {

        log.info("Start test: {}", testInfo.getDisplayName());
        driver.get(url);
        var expectedResult = "OK button pressed";
        var simpleAlertBtn = driver.findElement(By.cssSelector("#simple-alert"));
        var simpleAlertInfo = driver.findElement(By.cssSelector("#simple-alert-label"));

        click(simpleAlertBtn);
        driver.switchTo().alert().accept();

        var result = simpleAlertInfo.getText();
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    //@RepeatedTest(10)
    @DisplayName("Prompt")
    void alertsPage_PromptAlert_whenSendNewName() {

        log.info("Start test: {}", testInfo.getDisplayName());
        driver.get(url);
        var name = "Lord Vader";
        var expectedResult = "Hello " + name + "! How are you today?";
        var promptBtn = driver.findElement(By.cssSelector("#prompt-alert"));
        var promptInfo = driver.findElement(By.cssSelector("#prompt-label"));

        click(promptBtn);
        var alert = driver.switchTo().alert();
        alert.sendKeys(name);
        alert.accept();

        var result = promptInfo.getText();
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    // @RepeatedTest(10)
    @DisplayName("Confirm alert")
    void alertPage_ConfirmAlert_whenAccept() {

        log.info("Start test: {}", testInfo.getDisplayName());
        driver.get(url);
        var expectedResult = "You pressed OK!";
        var confirmBtn = driver.findElement(By.cssSelector("#confirm-alert"));
        var confirmInfo = driver.findElement(By.cssSelector("#confirm-label"));

        click(confirmBtn);
        driver.switchTo().alert().accept();

        var result = confirmInfo.getText();
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    //  @RepeatedTest(10)
    @DisplayName("Cancel alert")
    void alertPage_ConfirmAlert_whenCancel() {

        log.info("Start test: {}", testInfo.getDisplayName());
        driver.get(url);
        var expectedResult = "You pressed Cancel!";
        var confirmBtn = driver.findElement(By.cssSelector("#confirm-alert"));
        var confirmInfo = driver.findElement(By.cssSelector("#confirm-label"));

        click(confirmBtn);
        driver.switchTo().alert().dismiss();

        var result = confirmInfo.getText();
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    //  @RepeatedTest(10)
    @DisplayName("Disappearing alert")
    void alertPage_disappearing() {

        log.info("Start test: {}", testInfo.getDisplayName());
        driver.get(url);
        var expectedResult = "OK button pressed";
        var delayedAlert = driver.findElement(By.cssSelector("#delayed-alert"));
        var delayedAlertInfo = driver.findElement(By.cssSelector("#delayed-alert-label"));

  /*      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
*/
        click(delayedAlert);
        Awaitility.await()
                .atMost(Duration.ofSeconds(10))
                .until(() -> {
                    try {
                        driver.switchTo().alert();
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                });

        driver.switchTo().alert().accept();

        var result = delayedAlertInfo.getText();
        assertThat(result).isEqualTo(expectedResult);
    }

}