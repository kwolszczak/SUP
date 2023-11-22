package pl.kwolszczak.selenium7_2_3.configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class BrowserConf {

    private String browserName = "chrome";
    private boolean browserHeadless = false;
    private String browserDownloadDir = "\\src\\tmp_download";
    private int webElementTimeout = 10;
    private String url;

    private Logger log;
    private WebDriver driver;


    public BrowserConf() {
        log = LoggerFactory.getLogger(BrowserConf.class);
        initBrowserSettings();
    }

    private void initBrowserSettings() {
        this.browserName = System.getProperty("browser.name") == null ? this.browserName : System.getProperty("browser.name");
        this.browserHeadless = System.getProperty("browser.headless") == null ? this.browserHeadless : Boolean.parseBoolean(System.getProperty("browser.headless"));
        this.webElementTimeout = Integer.parseInt(System.getProperty("environment.webElementTimeout")) <= 0 ? this.webElementTimeout : Integer.parseInt(System.getProperty("environment.webElementTimeout"));
        this.browserDownloadDir = System.getProperty("browser.downloadDir") == null ? this.browserDownloadDir : System.getProperty("browser.downloadDir");
        this.url = System.getProperty("environment.url");
    }

    public WebDriver getDriver() {
        WebDriver driver;
        log.info("#### Setup {} browser", this.browserName);
        switch (this.browserName) {
            case "chrome" -> {

                String path = this.browserDownloadDir;
                File file = new File(path);

                ChromeOptions chromeOptions = new ChromeOptions();

                Map<String, Object> prefs = new HashMap<>();
                prefs.put("download.default_directory", file.getAbsolutePath());
                chromeOptions.setExperimentalOption("prefs", prefs);
                driver = new ChromeDriver(chromeOptions);
                driver.manage().window().maximize();

                log.info("Open app url from config {}", this.url);
                driver.get(this.url);
            }
            case "firefox" -> {
                driver = new FirefoxDriver();
                driver.get(this.url);
            }
            default -> {
                driver = new SafariDriver();
                driver.get(this.url);
            }
        }
        this.driver = driver;
        return driver;
    }


}
