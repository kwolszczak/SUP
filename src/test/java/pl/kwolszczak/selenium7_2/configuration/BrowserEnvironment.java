package pl.kwolszczak.selenium7_2.configuration;

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

public class BrowserEnvironment {

    private String browserName = "chrome";
    private boolean browserHeadless = false;
    private boolean browserScreenshotAttach = false;
    private String browserDownloadDir = "\\src\\tmp_download";
    private int browserImplicitTimeout = 5;
    private int webElementTimeout = 10;

    private Logger log;
    private WebDriver driver;

    public BrowserEnvironment() {
        log = LoggerFactory.getLogger(BrowserEnvironment.class);
        initBrowserSettings();
    }

    private void initBrowserSettings() {
        this.browserName = PropertyStore.BROWSER.isSpecified() ? PropertyStore.BROWSER.getValue() : this.browserName;
        this.browserHeadless = PropertyStore.BROWSER_HEADLESS.isSpecified() ? PropertyStore.BROWSER_HEADLESS.getBooleanValue() : this.browserHeadless;
        this.browserScreenshotAttach = PropertyStore.BROWSER_ATTACH_SCREENSHOT.isSpecified() ? PropertyStore.BROWSER_ATTACH_SCREENSHOT.getBooleanValue() : this.browserScreenshotAttach;
        this.browserImplicitTimeout=PropertyStore.BROWSER_IMPLICIT_TIMEOUT.isSpecified() ? PropertyStore.BROWSER_IMPLICIT_TIMEOUT.getIntValue() : this.browserImplicitTimeout;
        this.browserDownloadDir = PropertyStore.BROWSER_DOWNLOAD_DIR.isSpecified() ? PropertyStore.BROWSER_DOWNLOAD_DIR.getValue() : this.browserDownloadDir;
        this.webElementTimeout = PropertyStore.BROWSER_WEBELEMENT_TIMEOUT.isSpecified() ? PropertyStore.BROWSER_WEBELEMENT_TIMEOUT.getIntValue(): this.webElementTimeout;
    }

    public WebDriver getDriver(){
        WebDriver driver;
        switch (this.browserName) {
            case "chrome"-> {

                String path = PropertyStore.BROWSER_DOWNLOAD_DIR.getValue();
                File file = new File(path);

                log.debug("Chrome options loaded from properties");
                ChromeOptions chromeOptions = new ChromeOptions();

                log.debug("Setup default download directory");
                Map<String, Object> prefs = new HashMap<>();
                prefs.put("download.default_directory", file.getAbsolutePath());
                chromeOptions.setExperimentalOption("prefs", prefs);
                driver = new ChromeDriver(chromeOptions);
                driver.manage().window().maximize();
                driver.get(System.getProperty("appUrl"));
            }
            case "firefox" ->{
                log.debug("Firefox options loaded from properties");
                driver = new FirefoxDriver();
            }
            default -> {
                log.debug("Safari options loaded from properties");
                driver = new SafariDriver();
            }
        }
        this.driver = driver;
        return driver;
    }


}
