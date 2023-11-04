package pl.kwolszczak.selenium5_2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.kwolszczak.selenium5_2.util.DataUtil;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import java.util.Properties;

public class BaseTest {

    protected TestInfo testInfo;
    private static Properties properties;
    protected static WebDriver driver;
    protected Map<String,String> linksData;
    private static Logger log = LoggerFactory.getLogger(BaseTest.class);

    @BeforeEach
    void setUp(TestInfo testInfo) throws IOException {

        log.warn("Try to load test info variable {}", testInfo.getDisplayName());
        this.testInfo=testInfo;

        log.info("Setup Data...");
        properties = DataUtil.getProperties("env.properties");
        linksData = DataUtil.readCSVToMap("links.csv");

        log.info("Setup {} Browser...",properties.getProperty("browser"));
        log.error("Couldn't setUp browser--- test log  test log test log");
        setBrowser();
    }

    @AfterEach
    void tearDown() {
        log.info("Quit driver...");
        log.error("Couldn't quit driver--- test log  test log test log");
        driver.quit();
    }

    private static void setBrowser() {

        String browser =properties.getProperty("browser");
        String version =properties.getProperty("browserVersion");
        log.debug("init browser: {} version: {}",browser, version);
        log.warn("Options will be loaded from properties file");

        switch (browser) {
            case "chrome"-> {

                log.debug("Chrome options loaded from properties");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setBrowserVersion(version);
                driver = new ChromeDriver(chromeOptions);
            }
            case "firefox" -> {

                log.debug("Firefox options loaded from properties");
                driver = new FirefoxDriver();
            }
            case "safari" -> {

                log.debug("Safari options loaded from properties");
                driver = new SafariDriver();
            }
            default -> {

                log.error("can't load browser config from properties");
                driver = new ChromeDriver();
            }
        }

        log.debug("Setting up windows maximum size");
        driver.manage().window().maximize();
        log.warn("Setting up implicitly wait timeout - 5s");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
}

