package pl.kwolszczak.selenium7_2_3.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.kwolszczak.selenium7_2_3.configuration.loader.YamlLoader;
import pl.kwolszczak.selenium7_2_3.configuration.model.Configuration;
import pl.kwolszczak.selenium7_2_3.configuration.model.Environment;

import java.util.Map;

public class AppConf {

    private static final AppConf INSTANCE = new AppConf();
    private static Configuration config;
    private static final Logger log = LoggerFactory.getLogger(AppConf.class);

    private AppConf() {
        loadYamlConfig();
        loadConfigurationToSystem();
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

    private void loadConfigurationToSystem() {
        var env = getActiveEnvironment().getProperties();
        var browser = config.getBrowser().getProperties();
        setSystemProperties(env, "ENV");
        setSystemProperties(browser, "BROWSER");
    }

    private void setSystemProperties(Map<String, Object> properties, String prefix) {
       var entrySet = properties.entrySet();
        for (var entry : entrySet) {
            System.setProperty(prefix+"."+entry.getKey(), entry.getValue().toString());
        }
    }

    private Environment getActiveEnvironment() {
        return config.getEnvironments().stream()
                .filter(env->env.getProperties().get("active").equals(true))
                .reduce((en1,en2)->en1).orElse(null);
    }
}
