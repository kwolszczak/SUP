package pl.kwolszczak.selenium7_2_3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.kwolszczak.selenium7_2_3.configuration.properties.Env;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MainTest extends BaseTest {

    private final Logger log = LoggerFactory.getLogger(MainTest.class);

    @Test
    @DisplayName("1. Selenium - smoke test")
    void verify_webSelenium_hasTitle() {
        log.info(">>>>>> Start test >>>>>>");

        String expectedTitle = Env.ETITLE.getValue();
        String title = driver.getTitle();

        log.info("app Url: {}", Env.URL.getValue());
        log.info("actual title: {}", title);
        log.info("Expected title: {}", expectedTitle);

        Assertions.assertThat(title).isEqualTo(expectedTitle);
        log.info(">>>>>> Finished test >>>>>>");
    }

    @Test
    @DisplayName("2. Selenium - smoke test")
    void verify_webSelenium_hasTitle2() {
        log.info(">>>>>> Start test >>>>>>");

        String expectedTitle = Env.ETITLE.getValue();
        String title = driver.getTitle();

        log.info("app Url: {}", Env.URL.getValue());
        log.info("actual title: {}", title);
        log.info("Expected title: {}", expectedTitle);

        Assertions.assertThat(title).isEqualTo(expectedTitle);
        log.info(">>>>>> Finished test >>>>>>");
    }




}