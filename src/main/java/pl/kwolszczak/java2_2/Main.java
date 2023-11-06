package pl.kwolszczak.java2_2;

import pl.kwolszczak.java2_2.model.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // -----------------COUNTRIES ---------------------
        Country poland = new Country("Poland", "P");
        Country germany = new Country("Germany", "G");
        Country china = new Country("China", "C");
        Country holland = new Country("Holland", "H");
        Country korea = new Country("North Korea", "K");


        // -----------------MARKET ---------------------
        List<Country> businessCountries = new ArrayList<>();
        businessCountries.add(holland);
        businessCountries.add(germany);
        businessCountries.add(poland);
        Market business = new Market("Business", businessCountries);

        Market cargo = new Market("Cargo");
        cargo.addCountry(china)
                .addCountry(korea)
                .addCountry(poland);

        Market transport = new Market("Transport");
        transport.addCountry(poland)
                .addCountry(germany)
                .addCountry(china);

        Market taxi = new Market("Taxi");
        taxi.addCountry(germany)
                .addCountry(holland)
                .addCountry(poland);

        Market bus = new Market("Bus");
        bus.addCountry(china)
                .addCountry(holland)
                .addCountry(korea);

        // -----------------CARS ---------------------
        Producent audiA5 = new Producent("AUDI", "A5");
        Dimension dimensionA5 = new Dimension(136, 463, 55);
        Car a5 = new Car(audiA5, true, business, Segment.PREMIUM, dimensionA5);
        Car a5Taxi = new Car(audiA5, true, taxi, Segment.PREMIUM, dimensionA5);

        Producent audiS7 = new Producent("AUDI", "S7");
        Dimension dimensionS7 = new Dimension(140, 520, 65);
        Car s7 = new Car(audiS7, true, business, Segment.PREMIUM, dimensionS7);
        Car s7Taxi = new Car(audiS7, true, taxi, Segment.PREMIUM, dimensionA5);

        Producent vwCaddy = new Producent("VW", "Caddy");
        Dimension dimensionCaddy = new Dimension(180, 350, 90);
        Car caddy = new Car(vwCaddy, false, cargo, Segment.MEDIUM, dimensionCaddy);
        Car caddyTaxi = new Car(vwCaddy, true, taxi, Segment.PREMIUM, dimensionA5);

        Producent fiatDoblo = new Producent("FIAT", "Doblo");
        Dimension dimensionDoblo = new Dimension(260, 463, 75);
        Car doblo = new Car(fiatDoblo, false, cargo, Segment.STANDARD, dimensionDoblo);
        Car dobloTransport = new Car(fiatDoblo, true, transport, Segment.PREMIUM, dimensionA5);

        Producent opelZafira = new Producent("OPEL", "zafira");
        Dimension dimensionZafira = new Dimension(220, 520, 55);
        Car zafira = new Car(opelZafira, true, transport, Segment.STANDARD, dimensionZafira);
        Car zafiraTaxi = new Car(opelZafira, true, taxi, Segment.PREMIUM, dimensionA5);

        Producent vwJetta = new Producent("VW", "Jetta");
        Dimension dimensionJetta = new Dimension(136, 380, 44);
        Car jetta = new Car(vwJetta, true, transport, Segment.PREMIUM, dimensionJetta);

        Producent fiatPanda = new Producent("FIAT", "Panda");
        Dimension dimensionPanda = new Dimension(210, 463, 120);
        Car panda = new Car(fiatPanda, false, taxi, Segment.PREMIUM, dimensionPanda);

        Producent audiRS8 = new Producent("AUDI", "RS8");
        Dimension dimensionRS8 = new Dimension(182, 320, 55);
        Car rs8 = new Car(audiRS8, true, taxi, Segment.PREMIUM, dimensionRS8);

        Producent opelInsignia = new Producent("OPEL", "Insignia");
        Dimension dimensionInsignia = new Dimension(177, 511, 67);
        Car insignia = new Car(opelInsignia, false, bus, Segment.STANDARD, dimensionInsignia);

        Producent vwCorrado = new Producent("VW", "Corrado");
        Dimension dimensionCorrado = new Dimension(136, 398, 72);
        Car corrado = new Car(vwCorrado, false, bus, Segment.MEDIUM, dimensionCorrado);

        //-----------------all cars list
        List<Car> cars = new ArrayList<>();
        cars.add(a5);
        cars.add(a5Taxi);
        cars.add(s7);
        cars.add(s7Taxi);
        cars.add(caddy);
        cars.add(caddyTaxi);
        cars.add(doblo);
        cars.add(dobloTransport);
        cars.add(zafira);
        cars.add(zafiraTaxi);
        cars.add(jetta);
        cars.add(panda);
        cars.add(rs8);
        cars.add(insignia);
        cars.add(corrado);

        Car.searchCountry(cars, "audi", true, 50);
    }
}
