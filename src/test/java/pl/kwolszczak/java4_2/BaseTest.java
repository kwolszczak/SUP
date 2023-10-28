package pl.kwolszczak.java4_2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import pl.kwolszczak.java4_2.util.DataUtil;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    protected static WebDriver driver;
    private static Properties properties;

    @BeforeEach
    void setUp() throws IOException {
        properties = DataUtil.getProperties("env.properties");
        setBrowser();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    private static void setBrowser() {

        switch (properties.getProperty("browser")) {
            case "chrome"-> {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setBrowserVersion(properties.getProperty("browserVersion"));
                driver = new ChromeDriver(chromeOptions);
            }
            case "firefox" -> driver = new FirefoxDriver();
            case "safari" -> driver = new SafariDriver();
            default -> driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
}

