package pl.kwolszczak.selenium7_2_2.configuration.loaders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.kwolszczak.selenium7_2_2.configuration.model.Configuration;

import java.io.File;
import java.io.IOException;

public class YmlLoader {

    private static Configuration conf;
    private static final String CONFIG_FILE = "config.yaml";
    private static Logger log = LoggerFactory.getLogger(YmlLoader.class);

    public static void loadConfigFromYaml() {

        log.debug("Try to map config file '{}'", CONFIG_FILE);
        var mapper = new ObjectMapper(new YAMLFactory());
        File file = new File(ClassLoader.getSystemResource(CONFIG_FILE).getFile());

        try {
            conf = mapper.readValue(file, Configuration.class);
            log.debug("Mapping '{}' file succeed ", CONFIG_FILE);
        } catch (IOException e) {
            log.error("Couldn't map yaml configuration file.");
        }
    }

    public Configuration getConf() {
        return conf;
    }
}
