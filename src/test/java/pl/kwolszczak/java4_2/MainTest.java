package pl.kwolszczak.java4_2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class MainTest extends BaseTest {

    @Tag("Regression")
    @DisplayName("All Regression")
    @ParameterizedTest
    @CsvFileSource(resources = "/testData.csv", numLinesToSkip = 1)
    void verify_allWebSites_haveTitle(String url, String expectedResult) {

        driver.get(url);
        String title = driver.getTitle();

        Assertions.assertThat(title).isEqualTo(expectedResult);
    }

    @Tag("Onet")
    @Tag("Regression")
    @DisplayName("Onet - smoke test")
    @ParameterizedTest
    @MethodSource({"pl.kwolszczak.java4_2.data.TestData#dataProvider"})
    void verify_webOnet_hasTitle(String expectedResult) {

        driver.get("https://onet.pl");
        String title = driver.getTitle();

        Assertions.assertThat(title).isEqualTo(expectedResult);
    }

    @Tag("Sii")
    @Tag("Regression")
    @DisplayName("Sii - smoke test")
    @ParameterizedTest
    @ValueSource(strings = {"Rozwiązania i usługi IT, inżynierii i BPO - Sii Polska"})
    void verify_webSII_hasTitle(String expectedResult) {

        driver.get("https://www.sii.pl");
        String title = driver.getTitle();

        Assertions.assertThat(title).isEqualTo(expectedResult);
    }

    @Tag("Filmweb")
    @Tag("Regression")
    @DisplayName("Filmweb - smoke test")
    @ParameterizedTest
    @ValueSource(strings = {"Filmweb - filmy takie jak Ty!"})
    void verify_webFilmweb_hasTitle(String expectedResult) {

        driver.get("https://www.filmweb.pl/");
        String title = driver.getTitle();

        Assertions.assertThat(title).isEqualTo(expectedResult);
    }

    @Tag("Kotuszkowo")
    @Tag("Regression")
    @DisplayName("Kotuszkowo - smoke test")
    @ParameterizedTest
    @ValueSource(strings = {"Kotuszkowo- blog o kotach"})
    void verify_webKotuszkowo_hasTitle(String expectedResult) {

        driver.get("http://kotuszkowo.pl/");
        String title = driver.getTitle();

        Assertions.assertThat(title).isEqualTo(expectedResult);
    }

    @Tag("Selenium")
    @Tag("Regression")
    @DisplayName("Selenium - smoke test")
    @ParameterizedTest
    @ValueSource(strings = {"WebDriver | Selenium"})
    void verify_webSelenium_hasTitle(String expectedResult) {

        driver.get("https://www.selenium.dev/documentation/en/webdriver/");
        String title = driver.getTitle();

        Assertions.assertThat(title).isEqualTo(expectedResult);
    }


}