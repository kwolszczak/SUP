package pl.kwolszczak.selenium7_2_2;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.kwolszczak.selenium7_2_2.configuration.AppConf;
import pl.kwolszczak.selenium7_2_2.configuration.BrowserConf;

public class BaseTest {

    protected WebDriver driver;
    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);
    protected AppConf appConf;

    @BeforeAll
    void setUp() {
        log.info(">>>> Start Setup Data... <<<<");
        appConf = AppConf.getInstance();
        BrowserConf browserConf = new BrowserConf();
        driver = browserConf.getDriver();

        log.debug(">>>> Finished setup data <<<<");
    }

    @AfterAll
    void tearDown() {
        log.info(">>>> Quit driver... <<<<");
        driver.quit();
    }
}

