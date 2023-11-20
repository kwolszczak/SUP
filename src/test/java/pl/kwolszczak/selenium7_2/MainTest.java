package pl.kwolszczak.selenium7_2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MainTest extends BaseTest {

    private final Logger log = LoggerFactory.getLogger(MainTest.class);

    @Test
    @Tag("Selenium")
    @DisplayName("Selenium - smoke test")
    void verify_webSelenium_hasTitle() {
        log.info(">>>>>> Start test >>>>>>");
        String expectedTitle = System.getProperty("eTitle");
        String title = driver.getTitle();

        log.info("app Url: {}", System.getProperty("appUrl"));
        log.info("actual title: {}", title);
        log.info("Expected title: {}", expectedTitle);

        Assertions.assertThat(title).isEqualTo(expectedTitle);
        log.info(">>>>>> Finished test >>>>>>");
    }

    @Test
    @Tag("Selenium")
    @DisplayName("Selenium - smoke test2")
    void verify_webSelenium_hasTitle2() {
        log.info(">>>>>> Start test >>>>>>");
        String expectedTitle = System.getProperty("eTitle");
        String title = driver.getTitle();

        log.info("app Url: {}", System.getProperty("appUrl"));
        log.info("actual title: {}", title);
        log.info("Expected title: {}", expectedTitle);

        Assertions.assertThat(title).isEqualTo(expectedTitle);
        log.info(">>>>>> Finished test >>>>>>");
    }
}