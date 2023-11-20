package pl.kwolszczak.selenium7_2.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.kwolszczak.selenium7_2.utils.AppEnvException;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.stream.Stream;

public class PropertyEnvironment {

    private final String APP_ENV;
    private static Logger log = LoggerFactory.getLogger(PropertyEnvironment.class);
    private static final PropertyEnvironment INSTANCE = new PropertyEnvironment();

    private PropertyEnvironment() {
        this.APP_ENV = initAppEnv();
        initEnv();
    }

    public static PropertyEnvironment getInstance() {
        return PropertyEnvironment.INSTANCE;
    }

    private String initAppEnv() {
        return PropertyStore.ENVIRONMENT.isSpecified() ? PropertyStore.ENVIRONMENT.getValue() : "";
    }

    private void initEnv() {
        if (!this.APP_ENV.isEmpty()) {
            log.debug(">>>>>>>>>> Environment name: {}", this.APP_ENV);
            loadEnvPropertiesToSystem(this.APP_ENV);
        } else {
            log.error("Please provide environment properties");
            throw new AppEnvException();
        }
    }

    private void loadEnvPropertiesToSystem(String environmentName) {
        setSystemPropertiesFromPathUrl(environmentName);
    }

    private void setSystemPropertiesFromPathUrl(String dirName) {

        URL url = getClass().getClassLoader().getResource(dirName);
        if (url != null) {
            Properties envProperties = new Properties();
            try (Stream<Path> files = Files.walk(Paths.get(url.toURI()))) {
                files.filter((x$0) -> Files.isRegularFile(x$0, new LinkOption[0]))
                        .toList()
                        .forEach(path -> {
                                    try {
                                        envProperties.load(new FileInputStream(path.toString()));
                                    } catch (IOException e) {
                                        log.error("Couldn't load property file in this directory");
                                    }
                                }
                        );
            } catch (IOException | URISyntaxException e) {
                log.error("couldn't get into directories with properties");
            }

            log.debug("##### Loading property from uri {}", url);
            envProperties.forEach((name, value) -> {
                if (System.getProperty(name.toString()) == null) {
                    System.setProperty(name.toString(), value.toString());
                    log.debug("***** Loading environment property {} = {}", name, value);
                }
            });
            log.debug("#### Properties laoded from {} = {}", dirName, envProperties.size());
        } else {
            log.warn("No such property directory '{}' present in the resources", dirName);
        }


    }
}
