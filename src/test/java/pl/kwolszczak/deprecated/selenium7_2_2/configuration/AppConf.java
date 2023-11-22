package pl.kwolszczak.deprecated.selenium7_2_2.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.kwolszczak.deprecated.selenium7_2_2.configuration.loaders.YmlLoader;
import pl.kwolszczak.deprecated.selenium7_2_2.configuration.model.Browser;
import pl.kwolszczak.deprecated.selenium7_2_2.configuration.model.Configuration;
import pl.kwolszczak.deprecated.selenium7_2_2.configuration.model.Environment;

public class AppConf {

    private Configuration conf = null;
    private YmlLoader loader;
    private static final Logger log = LoggerFactory.getLogger(AppConf.class);
    private static final AppConf INSTANCE = new AppConf();

    private AppConf() {
        loadYaml();
        conf = loader.getConf();
    }

    public static AppConf getInstance() {
        return AppConf.INSTANCE;
    }

    private void loadYaml() {
        log.debug("#### Try to load config file. Singleton");
        if (conf == null) {
            loader = new YmlLoader();
            YmlLoader.loadConfigFromYaml();
            log.info("#### New Configuration loaded from Yaml");
        } else {
            log.debug("#### Config is already initialized, No need to load config from file");
        }
    }

    public Environment env() {
        return conf.getEnvironments().stream()
                .filter(Environment::isActive)
                .limit(1)
                .reduce((environment, environment2) -> environment).orElse(null);
    }

    public Browser browser() {
        return conf.getBrowser();
    }

    public String extraParams(String key) {
        return env().getExtraParams().get(key);
    }



}
