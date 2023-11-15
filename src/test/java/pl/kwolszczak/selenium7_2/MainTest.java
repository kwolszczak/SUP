package pl.kwolszczak.selenium7_2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import pl.kwolszczak.selenium5_2.BaseTest;
import pl.kwolszczak.selenium5_2.data.DataArgumentProvider;
import pl.kwolszczak.selenium5_2.util.RegressionTest;
import pl.kwolszczak.selenium7_2.configuration.PropertyStore;


class MainTest extends BaseTest {

    private String title;
    private Logger log = LoggerFactory.getLogger(MainTest.class);
    private static final Marker FATAL_MARKER = MarkerFactory.getMarker("FATAL");



    @Tag("Onet")
    @DisplayName("Onet - smoke test")
    @Test
    void verify_webOnet_hasTitle( ) {
        String expectedTitle ="Logback Home";
        log.info(FATAL_MARKER,"Fatally error, test log Market{}",testInfo.getDisplayName());
        log.info("Setup test {}",testInfo.getTestMethod().get().getName());
        driver.get("https://logback.qos.ch/");
        title = driver.getTitle();

        Assertions.assertThat(title).isEqualTo(expectedTitle);
        log.info("Test {} finished",testInfo.getDisplayName());
    }

    @Test
    @Tag("Selenium")
    @DisplayName("Selenium - smoke test")
    void verify_webSelenium_hasTitle() {
        String expectedTitle ="Logback Home";
        int x=PropertyStore.BROWSER_WEBELEMENT_TIMEOUT.getIntValue() + 1;
        System.out.println(x);
     System.out.println( PropertyStore.BROWSER.getValue());
        System.out.println(System.getProperty("browser"));

        log.info("Setup test {}",testInfo.getTestMethod().get().getName());
        driver.get("https://logback.qos.ch/");
        title = driver.getTitle();

        Assertions.assertThat(title).isEqualTo(expectedTitle);
        log.info("Test {} finished",testInfo.getDisplayName());
    }
}