package pl.kwolszczak.selenium7_2_2.configuration;

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
    private boolean browserScreenshotAttach = false;
    private String browserDownloadDir = "\\src\\tmp_download";
    private int browserImplicitTimeout = 5;
    private int webElementTimeout = 10;

    private Logger log;
    private WebDriver driver;
    private AppConf appConf = AppConf.getInstance();

    public BrowserConf() {
        log = LoggerFactory.getLogger(BrowserConf.class);
        initBrowserSettings();
    }

    private void initBrowserSettings() {
        this.browserName = appConf.browser().getName() == null ? this.browserName : appConf.browser().getName();
        this.browserHeadless = appConf.browser().isHeadless();
        // this.browserScreenshotAttach =config.getBrowser(). PropertyStore.BROWSER_ATTACH_SCREENSHOT.isSpecified() ? PropertyStore.BROWSER_ATTACH_SCREENSHOT.getBooleanValue() : this.browserScreenshotAttach;
        this.webElementTimeout = appConf.browser().getWebelementTimeout() <= 0 ? this.webElementTimeout : appConf.browser().getWebelementTimeout();
        this.browserDownloadDir = appConf.browser().getDownloadDir() == null ? this.browserDownloadDir : appConf.browser().getDownloadDir();
        //  this.browserImplicitTimeout = config.getBrowser().getWebelementTimeout();
    }

    public WebDriver getDriver() {
        WebDriver driver;
        log.info("#### Setup {} browser", this.browserName);
        switch (this.browserName) {
            case "chrome" -> {

                String path = appConf.browser().getDownloadDir();
                File file = new File(path);

                log.debug("Chrome options loading from config file");
                ChromeOptions chromeOptions = new ChromeOptions();

                log.debug("Setup default download directory");
                Map<String, Object> prefs = new HashMap<>();
                prefs.put("download.default_directory", file.getAbsolutePath());
                chromeOptions.setExperimentalOption("prefs", prefs);
                driver = new ChromeDriver(chromeOptions);
                log.debug("Setup maximize window");
                driver.manage().window().maximize();
                log.info("Open app url from config");
                driver.get(appConf.env().getUrl());
            }
            case "firefox" -> {
                log.debug("Firefox options loaded from properties");
                driver = new FirefoxDriver();
                log.info("Open app url from config");
                driver.get(appConf.env().getUrl());
            }
            default -> {
                log.debug("Safari options loaded from properties");
                driver = new SafariDriver();
                log.info("Open app url from config");
                driver.get(appConf.env().getUrl());
            }
        }
        this.driver = driver;
        return driver;
    }


}
