package pl.kwolszczak.selenium7_2_3.configuration.properties;

public enum Browser {
    NAME("BROWSER.name"),
    HEADLESS("BROWSER.headless"),
    DOWNLOAD_DIR("BROWSER.downloadDir"),
    WEBELEMENT_TIMEOUT("BROWSER.webelementTimeout");

    private String key;
    private String value;

     Browser(String key){
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
