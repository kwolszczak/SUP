package pl.kwolszczak.selenium7_2_3;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.kwolszczak.selenium7_2_3.configuration.AppConf;
import pl.kwolszczak.selenium7_2_3.configuration.BrowserConf;

public class BaseTest {

    protected WebDriver driver;
    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);
    protected AppConf appConf;

    @BeforeAll
    void setUp() {
        //log.info("app Url: {}", Env.URL.getValue());

        appConf = AppConf.getInstance();
        BrowserConf browserConf = new BrowserConf();
        driver = browserConf.getDriver();
        log.info(">>>> Finished setup data <<<<");
        log.info("Environment: {}", System.getProperty("environment.name"));
        log.info("app Url: {}", System.getProperty("environment.url"));
        log.info(">>>> Start tests <<<<");

    }

    @AfterAll
    void tearDown() {
        log.info(">>>> Quit driver... <<<<");
        driver.quit();
    }
}

