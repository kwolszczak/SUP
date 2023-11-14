package pl.kwolszczak.selenium7_2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.kwolszczak.selenium6_1.util.DataUtil;
import pl.kwolszczak.selenium6_1.util.SeleniumUtil;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BaseTest {

    public TestInfo testInfo;
    protected static WebDriver driver;
    protected WebDriverWait wait;
    private static Properties properties;
    private static Logger log = LoggerFactory.getLogger(BaseTest.class);

    @BeforeEach
    void setUp(TestInfo testInfo) throws IOException {

        log.info("Setup Data...");
        this.testInfo = testInfo;
        properties = DataUtil.getProperties("env.properties");


        log.info("Setup {} Browser...",properties.getProperty("browser"));
        setBrowser();
        wait =new WebDriverWait(driver, Duration.ofSeconds(10));
        SeleniumUtil.init(driver);
    }

    @AfterEach
    void tearDown() {

        log.info("Quit driver...");
        driver.quit();
    }

    private static void setBrowser() {

        String browser =properties.getProperty("browser");
        String version =properties.getProperty("browserVersion");
        log.debug("init browser: {} version: {}",browser, version);

        switch (browser) {
            case "chrome"-> {

                String path = "src\\main\\resources\\";
                File file = new File(path);

                log.debug("Chrome options loaded from properties");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setBrowserVersion(version);

                log.debug("Setup default download directory");
                Map<String, Object> prefs = new HashMap<>();
                prefs.put("download.default_directory", file.getAbsolutePath());
                chromeOptions.setExperimentalOption("prefs", prefs);
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

