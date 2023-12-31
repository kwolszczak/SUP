package pl.kwolszczak.selenium7_2_3.configuration;

import org.assertj.core.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.kwolszczak.selenium7_2_3.configuration.loader.YamlLoader;
import pl.kwolszczak.selenium7_2_3.configuration.model.Configuration;
import pl.kwolszczak.selenium7_2_3.configuration.model.Environment;

import java.util.Map;
import java.util.stream.Collectors;

public class AppConf {

    private static final AppConf INSTANCE = new AppConf();
    private static Configuration config;
    private static Logger log;

    private AppConf() {
        log = LoggerFactory.getLogger(AppConf.class);
        loadYamlConfig();
        loadConfigurationToSystemProperties();
    }

    public static AppConf getInstance() {
        return AppConf.INSTANCE;
    }

    private void loadYamlConfig() {
        if (config == null) {
            YamlLoader loader = new YamlLoader();
            loader.loadYaml();
            config = loader.getConfig();
        } else {
            log.debug("Config already loaded. No need to load configuration");
        }
    }

    private void loadConfigurationToSystemProperties() {

        var activeEnvironment = getActiveEnvironment();
        var otherSections = config.getProperties();

        log.info("#### Loading configuration to SystemProperty: ####");
        setSystemProperties(activeEnvironment);
        setSystemProperties(otherSections);
    }

    private void setSystemProperties(Map<String, Object> map) {

        var entrySet = map.entrySet();
        for (var entry : entrySet) {
            var key = entry.getKey();
            var value = entry.getValue();

            if (value == null) {
                log.error("{} = null. Value can't be null", key);
                throw new RuntimeException();
            } else if (value instanceof String valueStr) {
                setSystemPropertyForString(key, valueStr);
            } else if (value instanceof Boolean val) {
                setSystemPropertyForString(key, Boolean.toString(val));
            } else if (value instanceof Number val) {
                setSystemPropertyForString(key, val.toString());
            } else {
                Map<String, Object> innerMap = (Map<String, Object>) entry.getValue();
                setSystemPropertyForMap(innerMap, key);
            }
        }
    }

    private void setSystemPropertyForString(String key, String value) {
        System.setProperty(key, value);
        log.debug("{} = {}", key, value);
    }

    private void setSystemPropertyForMap(Map<String, Object> map, String parentKey) {
        for (var entry : map.entrySet()) {

            var keyProperty = parentKey + "." + entry.getKey();
            var valueProperty = entry.getValue();
            if (valueProperty == null) {
                log.error("{} = null. Value can't be null", keyProperty);
                throw new RuntimeException();
            } else {
                System.setProperty(keyProperty, valueProperty.toString());
                log.debug("{} = {}", keyProperty, valueProperty);
            }
        }
    }


    private Map<String, Object> getActiveEnvironment() {

        var numberOfActiveEnvironmtnts = config.getEnvironment().stream().filter(env -> env.getProperties().get("active").equals(true)).count();

        if (numberOfActiveEnvironmtnts != 1) {
            log.error("Wrong configuration of Environments. There should be only one active env, but there's {}", numberOfActiveEnvironmtnts);
            Assertions.assertThat(true).isFalse();
        }

        return config.getEnvironment().stream()
                .filter(env -> env.getProperties().get("active").equals(true))
                .collect(Collectors.toMap(env -> "environment", Environment::getProperties));
    }
}
