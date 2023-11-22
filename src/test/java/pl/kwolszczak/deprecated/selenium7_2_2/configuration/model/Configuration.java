package pl.kwolszczak.deprecated.selenium7_2_2.configuration.model;

import java.util.List;

public class Configuration {
    private List<Environment> environments;
    private Browser browser;

    public List<Environment> getEnvironments() {
        return environments;
    }

    public Browser getBrowser() {
        return browser;
    }
  }
