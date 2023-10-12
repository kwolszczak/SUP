package pl.kwolszczak.java2_2.second;

import pl.kwolszczak.java2_2.Dimension;
import pl.kwolszczak.java2_2.Market;
import pl.kwolszczak.java2_2.Segment;

import java.util.List;

public class Car {
    private boolean hasAutomaticGear;
    private Market market;
    private Segment segment;
    private Dimension dimension;

    public Car(boolean hasAutomaticGear, Market market, Segment segment, Dimension dimension) {
        this.hasAutomaticGear = hasAutomaticGear;
        this.market = market;
        this.segment = segment;
        this.dimension = dimension;
    }

    public boolean hasAutomaticGear() {
        return hasAutomaticGear;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public Segment getSegment() {
        return segment;
    }

    public Market getMarket() {
        return market;
    }

    @Override
    public String toString() {
        for (var country : market.getCountries()) {
            System.out.println(country.name() + " " + country.code());
        }
        return " ";
    }

}
