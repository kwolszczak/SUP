package pl.kwolszczak.java4_2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import pl.kwolszczak.java4_2.data.DataArgumentProvider;
import pl.kwolszczak.java4_2.util.RegressionTest;

class MainTest extends BaseTest {

    private String title;

    @DisplayName("All Regression")
    @RegressionTest
    @CsvFileSource(resources = "/testData.csv", numLinesToSkip = 1)
    void verify_allWebSites_haveTitle(String url, String expectedResult) {

        driver.get(url);
        title = driver.getTitle();

        Assertions.assertThat(title).isEqualTo(expectedResult);
    }

    @Tag("Onet")
    @DisplayName("Onet - smoke test")
    @RegressionTest
    @MethodSource({"pl.kwolszczak.java4_2.data.TestData#dataProvider"})
    void verify_webOnet_hasTitle(String expectedResult) {

        driver.get(linksData.get("onet"));
        title = driver.getTitle();

        Assertions.assertThat(title).isEqualTo(expectedResult);
    }

    @Tag("Sii")
    @DisplayName("Sii - smoke test")
    @RegressionTest
    @ArgumentsSource(DataArgumentProvider.class)
    void verify_webSII_hasTitle(String expectedResult) {

        driver.get(linksData.get("sii"));
        title = driver.getTitle();

        Assertions.assertThat(title).isEqualTo(expectedResult);
    }

    @Tag("Filmweb")
    @DisplayName("Filmweb - smoke test")
    @RegressionTest
    @ValueSource(strings = {"Filmweb - filmy takie jak Ty!"})
    void verify_webFilmweb_hasTitle(String expectedResult) {

        driver.get(linksData.get("filmweb"));
        title = driver.getTitle();

        Assertions.assertThat(title).isEqualTo(expectedResult);
    }

    @Tag("Kotuszkowo")
    @DisplayName("Kotuszkowo - smoke test")
    @RegressionTest
    @ValueSource(strings = {"Kotuszkowo- blog o kotach"})
    void verify_webKotuszkowo_hasTitle(String expectedResult) {

        driver.get(linksData.get("kotuszkowo"));
        title = driver.getTitle();

        Assertions.assertThat(title).isEqualTo(expectedResult);
    }

    @Tag("Selenium")
    @DisplayName("Selenium - smoke test")
    @RegressionTest
    @ValueSource(strings = {"WebDriver | Selenium"})
    void verify_webSelenium_hasTitle(String expectedResult) {

        driver.get(linksData.get("selenium"));
        title = driver.getTitle();

        Assertions.assertThat(title).isEqualTo(expectedResult);
    }
}