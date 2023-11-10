package pl.kwolszczak.java4_1.extended.config;


import java.io.FileInputStream;
import java.io.IOException;

import java.util.Properties;

public class AppConfig {

    private final Properties properties = new Properties();
    private static final AppConfig instance = new AppConfig();

    private AppConfig(){

        try(var file = new FileInputStream("src/main/resources/config.properties")){
            properties.load(file);
        }catch (IOException e) {
            throw new RuntimeException("Failed to load configruation file", e);
        }
    }

   public static AppConfig getInstance(){
        return instance;
   }

    public String getJsonPath(){
        return getValue("jsonPath");
    }
    private String getValue(String key) {
        return properties.getProperty(key);
    }

}
