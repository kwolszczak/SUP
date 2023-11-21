package pl.kwolszczak.selenium7_2_3.configuration.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Browser {

    private Map<String, Object> properties = new LinkedHashMap<>();

    @JsonAnyGetter
    public Map<String, Object> getProperties() {
        return properties;
    }

    @JsonAnySetter
    public void setProperties(String key, Object value) {
        this.properties.put(key,value);
    }
}

