package pl.kwolszczak.selenium5_2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MarkerFactory;
import org.slf4j.Marker;
import pl.kwolszczak.selenium5_2.data.DataArgumentProvider;
import pl.kwolszczak.selenium5_2.util.RegressionTest;


class MainTest extends BaseTest {

    private String title;
    private Logger log = LoggerFactory.getLogger(MainTest.class);
    private static final Marker FATAL_MARKER = MarkerFactory.getMarker("FATAL");

    @DisplayName("All Regression")
    @RegressionTest
    @CsvFileSource(resources = "/testData.csv", numLinesToSkip = 1)
    void verify_allWebSites_haveTitle(String url, String expectedResult) {

        log.info(FATAL_MARKER,"Fatally error, test log Market{}",testInfo.getDisplayName());
        log.info("Setup test {}",testInfo.getTestMethod().get().getName());
        driver.get(url);
        title = driver.getTitle();
        Assertions.assertThat(title).isEqualTo(expectedResult);
        log.info(FATAL_MARKER,"Test {} finished",testInfo.getDisplayName());
    }

    @Tag("Onet")
    @DisplayName("Onet - smoke test")
    @RegressionTest
    @MethodSource({"pl.kwolszczak.selenium5_2.data.TestData#dataProvider"})
    void verify_webOnet_hasTitle(String expectedResult) {

        log.info(FATAL_MARKER,"Fatally error, test log Market{}",testInfo.getDisplayName());
        log.info("Setup test {}",testInfo.getTestMethod().get().getName());
        driver.get(linksData.get("onet"));
        title = driver.getTitle();

        Assertions.assertThat(title).isEqualTo(expectedResult);
        log.info("Test {} finished",testInfo.getDisplayName());
    }

    @Tag("Sii")
    @Tag("Onet")
    @DisplayName("Sii, ONet")
    @RegressionTest
    @ArgumentsSource(DataArgumentProvider.class)
    void verify_webSII_hasTitle(String url,String expectedResult) {

        log.info("Setup test {}",testInfo.getTestMethod().get().getName());
        driver.get(url);
        title = driver.getTitle();

        Assertions.assertThat(title).isEqualTo(expectedResult);
        log.info("Test {} finished",testInfo.getDisplayName());
    }

    @Tag("Filmweb")
    @DisplayName("Filmweb - smoke test")
    @RegressionTest
    @ValueSource(strings = {"Filmweb - filmy takie jak Ty!"})
    void verify_webFilmweb_hasTitle(String expectedResult) {

        log.info("Setup test {}",testInfo.getTestMethod().get().getName());
        driver.get(linksData.get("filmweb"));
        title = driver.getTitle();

        Assertions.assertThat(title).isEqualTo(expectedResult);
        log.info("Test {} finished",testInfo.getDisplayName());
    }

    @Tag("Kotuszkowo")
    @DisplayName("Kotuszkowo - smoke test")
    @RegressionTest
    @ValueSource(strings = {"Kotuszkowo- blog o kotach"})
    void verify_webKotuszkowo_hasTitle(String expectedResult) {

        log.info("Setup test {}",testInfo.getTestMethod().get().getName());
        driver.get(linksData.get("kotuszkowo"));
        title = driver.getTitle();

        Assertions.assertThat(title).isEqualTo(expectedResult);
        log.info("Test {} finished",testInfo.getDisplayName());
    }

    @Tag("Selenium")
    @DisplayName("Selenium - smoke test")
    @RegressionTest
    @ValueSource(strings = {"WebDriver | Selenium"})
    void verify_webSelenium_hasTitle(String expectedResult) {

        log.info("Setup test {}",testInfo.getTestMethod().get().getName());
        driver.get(linksData.get("selenium"));
        title = driver.getTitle();

        Assertions.assertThat(title).isEqualTo(expectedResult);
        log.info("Test {} finished",testInfo.getDisplayName());
    }
}