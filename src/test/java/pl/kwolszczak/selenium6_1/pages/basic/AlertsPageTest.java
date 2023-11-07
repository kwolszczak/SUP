package pl.kwolszczak.selenium6_1.pages.basic;

import org.awaitility.Awaitility;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.kwolszczak.selenium6_1.BaseTest;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

class AlertsPageTest extends BaseTest {
    private Logger log = LoggerFactory.getLogger(AlertsPage.class);
    private String url = "http://www.seleniumui.moderntester.pl/alerts.php";

    @Test
    @RepeatedTest(10)
    @DisplayName("Simple Alert")
    void alertsPage_SimpleAlertPopUp_whenAccept() {

        String expectedResult = "OK button pressed";

        log.info("Start test: {}", testInfo.getDisplayName());
        driver.get(url);
        String result = new AlertsPage(driver)
                .acceptSimpleAlert()
                .getSimpleAlertInfo();


        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    @RepeatedTest(10)
    @DisplayName("Prompt")
    void alertsPage_PromptAlert_whenSendNewName() {

        String name = "TestName";
        String expectedResult = "Hello " + name + "! How are you today?";

        log.info("Start test: {}", testInfo.getDisplayName());
        driver.get(url);
        String result = new AlertsPage(driver)
                .fillPromptAlertByName(name)
                .getPromptAlertInfo();

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    @RepeatedTest(10)
    @DisplayName("Confirm alert")
    void alertPage_ConfirmAlert_whenAccept() {

        String expectedResult = "You pressed OK!";

        log.info("Start test: {}", testInfo.getDisplayName());
        driver.get(url);

        String result = new AlertsPage(driver)
                .confirmAlertBox()
                .getConfirmAlertBoxInfo();

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    @RepeatedTest(10)
    @DisplayName("Cancel alert")
    void alertPage_ConfirmAlert_whenCancel() {

        String expectedResult = "You pressed Cancel!";

        log.info("Start test: {}", testInfo.getDisplayName());
        driver.get(url);

        String result = new AlertsPage(driver)
                .cancelAlertBox()
                .getConfirmAlertBoxInfo();

        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    //  @RepeatedTest(10)
    @DisplayName("Disappearing alert")
    void alertPage_disappearing() throws InterruptedException {

        String expectedResult = "You pressed Cancel!";

        log.info("Start test: {}", testInfo.getDisplayName());
        driver.get(url);
        driver.findElement(By.cssSelector("#delayed-alert")).click();

  /*      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Set a maximum wait time of 10 seconds
        wait.until(ExpectedConditions.alertIsPresent());
*/

        Awaitility.await()
                .atMost(Duration.ofSeconds(10))
                .until(() -> {
                    try {
                        Alert alert = driver.switchTo().alert();
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                });

        // Handle the alert (accept, dismiss, etc.)
        Alert alert = driver.switchTo().alert();
        alert.accept();



    }

}