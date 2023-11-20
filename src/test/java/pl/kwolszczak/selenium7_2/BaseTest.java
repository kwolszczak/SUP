package pl.kwolszczak.selenium7_2;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.kwolszczak.selenium7_2.configuration.BrowserEnvironment;
import pl.kwolszczak.selenium7_2.configuration.PropertyEnvironment;

public class BaseTest {

    protected WebDriver driver;
    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);
    private static PropertyEnvironment propertyEnv;
    private static BrowserEnvironment browserEnv;

    @BeforeAll
    void setUp() {
        log.info("Setup Data...");
        propertyEnv = PropertyEnvironment.getInstance();
        browserEnv = new BrowserEnvironment();
        driver = browserEnv.getDriver();
        log.debug("Finished setup data");
    }

    @AfterAll
    void tearDown() {
        log.info("Quit driver...");
        driver.quit();
    }
}

