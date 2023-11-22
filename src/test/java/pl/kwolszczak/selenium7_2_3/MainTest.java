package pl.kwolszczak.selenium7_2_3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MainTest extends BaseTest {

    private final Logger log = LoggerFactory.getLogger(MainTest.class);

    @Test
    @DisplayName("1. Selenium - smoke test")
    void verify_webSelenium_hasTitle() {

        String expectedTitle = System.getProperty("environment.eTitle");
        String title = driver.getTitle();

        Assertions.assertThat(title).isEqualTo(expectedTitle);
    }

    @Test
    @DisplayName("2. Selenium - smoke test")
    void verify_webSelenium_hasTitle2() {

        String expectedTitle = System.getProperty("environment.eTitle");
        String title = driver.getTitle();

        Assertions.assertThat(title).isEqualTo(expectedTitle);
    }
}
