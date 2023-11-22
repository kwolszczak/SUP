package pl.kwolszczak.deprecated.selenium7_2_2.configuration.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Environment {
    private String name;
    private String url;
    private String eTitle;
    private boolean active;
    private Map<String, String> extraParams =new HashMap<>();

    public boolean isActive() {
        return active;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String geteTitle() {
        return eTitle;
    }

    @JsonAnyGetter
    public Map<String,String> getExtraParams() {
        return extraParams;
    }

    @JsonAnySetter
    private void setExtraParams(Map<String, String> extraParams) {
        this.extraParams = extraParams;
    }
}
