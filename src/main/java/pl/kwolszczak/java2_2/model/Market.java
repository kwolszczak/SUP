package pl.kwolszczak.java2_2.model;

import java.util.ArrayList;
import java.util.List;

public class Market {
    private String name;
    private List<Country> countries;

    public Market(String name) {
        this(name, new ArrayList<>());
    }

    public Market(String name, List<Country> countries) {
        this.name = name;
        this.countries = countries;
    }

    public Market addCountry(Country country) {
        if (!countries.contains(country)) {
            this.countries.add(country);
        }
        return this;
    }

    public Market removeCountry(Country country) {
        if (countries.contains(country)) {
            this.countries.remove(country);
        }
        return this;
    }

    public List<Country> getCountries() {
        return countries;
    }

    @Override
    public String toString() {
        return "Market{" +
                "name='" + name + '\'' +
                ", countries=" + countries +
                '}';
    }
}
