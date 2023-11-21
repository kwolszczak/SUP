package pl.kwolszczak.selenium7_2_3.configuration.properties;

public enum Env {
    NAME("ENV.name"),
    ACTIVE("ENV.active"),
    URL("ENV.url"),
    ETITLE("ENV.eTitle");

    private String key;
    private String value;

    Env(String key){
        this.key = key;
        this.value = getValueFromSystemProperties(key);
    }

    private String getValueFromSystemProperties(String key) {
        return System.getProperty(key);
    }

    public String getValue(){
        return value;
    }
    public int getIntValue(){
        return Integer.parseInt(value);
    }

    public boolean getBooleanValue(){
        return Boolean.parseBoolean(value);
    }

}
