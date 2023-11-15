package pl.kwolszczak.selenium7_2.configuration;

import org.junit.platform.commons.util.StringUtils;

import java.io.*;
import java.util.Objects;
import java.util.Properties;

public enum PropertyStore {


    BROWSER("browser"),
    BROWSER_WEBELEMENT_TIMEOUT("browser.webelement.timeout"),
    BROWSER_HEADLESS("browser.headless"),
    BROWSER_ATTACH_SCREENSHOT("browser.attachscreenshot"),
    BROWSER_VERSION("browser.version"),
    BROWSER_DOWNLOAD_DIR("browser.download.default_directory"),
    ENVIRONMENT("environment");

    private String key;
    private String value;
    private static final String CONFIG_PROPERTIES = "config.properties";
    private static Properties properties = null;

    PropertyStore(String key) {
        this.key = key;
        this.value = getPropertyValue(key);
    }

    private String getPropertyValue(String key) {
        if (properties == null) {
            properties = loadConfigFile();
        }
        return properties.getProperty(key);
    }

    private static Properties loadConfigFile() {
        var properties = new Properties();

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        try (InputStream resourceAsStream = classLoader.getResourceAsStream(CONFIG_PROPERTIES)) {
            if (resourceAsStream == null) {
                throw new FileNotFoundException(" File not found: " + CONFIG_PROPERTIES);
            }

            try (var reader = new BufferedReader(new InputStreamReader(resourceAsStream))) {
                properties.load(reader);
                return properties;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getValue(){
        return getPropertyValue(this.key);
    }

    public int getIntValue(){
        return Integer.parseInt(getPropertyValue(this.key));
    }

    public boolean getBooleanValue(){
        return Boolean.parseBoolean(getPropertyValue(this.key));
    }

/*    // --------to do
    public boolean isSpecified() {
        return StringUtils.isNotEmpty(this.value);
    }*/

}
