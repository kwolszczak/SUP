package pl.kwolszczak.selenium6_1.pages.basic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.kwolszczak.selenium6_1.BaseTest;
import pl.kwolszczak.selenium7_2.pages.AlertsPage;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.kwolszczak.selenium6_1.util.SeleniumUtil.*;

class AlertsPageTest extends BaseTest {

    private final Logger log = LoggerFactory.getLogger(AlertsPage.class);
    private final String url = "http://www.seleniumui.moderntester.pl/alerts.php";

    //@Test
   @RepeatedTest(1)
    @DisplayName("Simple Alert Pop up")
    void alertsPage_SimpleAlertPopUp_whenAccept() {

        log.info("Start test: {}", testInfo.getDisplayName());
        driver.get(url);
        var expectedResult = "OK button pressed";
        var simpleAlertBtn = driver.findElement(By.id("simple-alert"));
        var simpleAlertInfo = driver.findElement(By.id("simple-alert-label"));

        click(simpleAlertBtn);
        acceptAlert();

        var result = simpleAlertInfo.getText();
        assertThat(result).isEqualTo(expectedResult);
    }

    //@Test
    @RepeatedTest(1)
    @DisplayName("Prompt")
    void alertsPage_PromptAlert_whenSendNewName() {

        log.info("Start test: {}", testInfo.getDisplayName());
        driver.get(url);
        var name = "Lord Vader";
        var expectedResult = "Hello " + name + "! How are you today?";
        var promptBtn = driver.findElement(By.id("prompt-alert"));
        var promptInfo = driver.findElement(By.id("prompt-label"));

        click(promptBtn);
        acceptAlert(name);

        var result = promptInfo.getText();
        assertThat(result).isEqualTo(expectedResult);
    }

    //@Test
    @RepeatedTest(1)
    @DisplayName("Confirm alert")
    void alertPage_ConfirmAlert_whenAccept() {

        log.info("Start test: {}", testInfo.getDisplayName());
        driver.get(url);
        var expectedResult = "You pressed OK!";
        var confirmBtn = driver.findElement(By.id("confirm-alert"));
        var confirmInfo = driver.findElement(By.id("confirm-label"));

        click(confirmBtn);
        acceptAlert();

        var result = confirmInfo.getText();
        assertThat(result).isEqualTo(expectedResult);
    }

    //@Test
    @RepeatedTest(1)
    @DisplayName("Cancel alert")
    void alertPage_ConfirmAlert_whenCancel() {

        log.info("Start test: {}", testInfo.getDisplayName());
        driver.get(url);
        var expectedResult = "You pressed Cancel!";
        var confirmBtn = driver.findElement(By.id("confirm-alert"));
        var confirmInfo = driver.findElement(By.id("confirm-label"));

        click(confirmBtn);
        dismissAlert();

        var result = confirmInfo.getText();
        assertThat(result).isEqualTo(expectedResult);
    }

   // @Test
 @RepeatedTest(1)
    @DisplayName("Disappearing alert")
    void alertPage_disappearing() {

        log.info("Start test: {}", testInfo.getDisplayName());
        driver.get(url);
        var expectedResult = "OK button pressed";
        var delayedAlert = driver.findElement(By.cssSelector("#delayed-alert"));
        var delayedAlertInfo = driver.findElement(By.cssSelector("#delayed-alert-label"));

        click(delayedAlert);
        acceptAlert();

        var result = delayedAlertInfo.getText();
        assertThat(result).isEqualTo(expectedResult);
    }

}