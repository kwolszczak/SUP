package pl.kwolszczak.java2_2.second;

import pl.kwolszczak.java2_2.Country;
import pl.kwolszczak.java2_2.Dimension;
import pl.kwolszczak.java2_2.Market;
import pl.kwolszczak.java2_2.Segment;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // -----------------COUNTRIES ---------------------
        Country poland = new Country("Poland", "P");
        Country germany = new Country("Germany", "G");
        Country china = new Country("China", "C");
        Country holland = new Country("Holland", "H");
        Country korea = new Country("North Korea", "K");


        // -----------------MARKET ---------------------
        Market business = new Market("Business");
        business.addCountry(holland)
                .addCountry(germany)
                .addCountry(poland);

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

        // -----------------COMPANY ---------------------
        Company audi = new Company("AUDI");
        audi.addModel(new Model("A5", CAR_TYPE.HATCHBBACK))
                .addModel(new Model("S7", CAR_TYPE.SPORTBACK))
                .addModel(new Model("RS8", CAR_TYPE.SPORTBACK));

        Company vw = new Company("VW");
        vw.addModel(new Model("Jetta", CAR_TYPE.SEDAN))
                .addModel(new Model("ARTEON", CAR_TYPE.SEDAN))
                .addModel(new Model("CADDY", CAR_TYPE.VAN));

        Company bmw = new Company("BMW");
        bmw.addModel(new Model("bmw550d", CAR_TYPE.SEDAN))
                .addModel(new Model("i30", CAR_TYPE.HATCHBBACK))
                .addModel(new Model("x6", CAR_TYPE.VAN));

        // -----------------CARS ---------------------
        Dimension dimensionA5 = new Dimension(136, 463, 55);
        Car a5 = new Car(true, business, Segment.PREMIUM, dimensionA5);
        Car a5Taxi = new Car(true, taxi, Segment.PREMIUM, dimensionA5);


        Dimension dimensionS7 = new Dimension(140, 520, 65);
        Car s7 = new Car(true, business, Segment.PREMIUM, dimensionS7);
        Car s7Taxi = new Car(true, taxi, Segment.PREMIUM, dimensionS7);

        Dimension dimensionRS8 = new Dimension(182, 320, 55);
        Car rs8 = new Car(true, taxi, Segment.PREMIUM, dimensionRS8);


        Dimension dimensionCaddy = new Dimension(180, 350, 90);
        Car caddy = new Car(false, cargo, Segment.MEDIUM, dimensionCaddy);
        Car caddyTaxi = new Car(true, taxi, Segment.PREMIUM, dimensionCaddy);
        Car caddyBus = new Car(true, bus, Segment.PREMIUM, dimensionCaddy);

        Dimension dimensionArteon = new Dimension(136, 463, 55);
        Car arteon = new Car(false, cargo, Segment.STANDARD, dimensionArteon);
        Car arteonTransport = new Car(true, transport, Segment.PREMIUM, dimensionArteon);
        Car arteonTaxi = new Car(true, taxi, Segment.PREMIUM, dimensionArteon);

        Dimension dimension550d = new Dimension(136, 463, 55);
        Dimension dimensionI30 = new Dimension(136, 463, 55);
        Dimension dimensionX6 = new Dimension(136, 463, 55);
        Car bmw550d = new Car(true, transport, Segment.STANDARD, dimension550d);
        Car bmw550dTaxi = new Car(true, taxi, Segment.PREMIUM, dimension550d);
        Car i30 = new Car(true, transport, Segment.STANDARD, dimensionI30);
        Car i30Taxi = new Car(true, taxi, Segment.PREMIUM, dimensionI30);
        Car x6 = new Car(true, transport, Segment.STANDARD, dimensionX6);
        Car x6Taxi = new Car(true, taxi, Segment.PREMIUM, dimensionX6);

        // --- add cars to models
        audi.getModel("A5").addCar(a5);
        audi.getModel("A5").addCar(a5Taxi);
        audi.getModel("S7").addCar(s7);
        audi.getModel("S7").addCar(s7Taxi);
        audi.getModel("RS8").addCar(rs8);
        vw.getModel("CADDY").addCar(caddy);
        vw.getModel("CADDY").addCar(caddyTaxi);
        vw.getModel("CADDY").addCar(caddyBus);
        vw.getModel("ARTEON").addCar(arteon);
        vw.getModel("ARTEON").addCar(arteonTransport);
        vw.getModel("ARTEON").addCar(arteonTaxi);
        bmw.getModel("bmw550d").addCar(bmw550d);
        bmw.getModel("bmw550d").addCar(bmw550dTaxi);
        bmw.getModel("i30").addCar(i30);
        bmw.getModel("i30").addCar(i30Taxi);
        bmw.getModel("x6").addCar(x6);
        bmw.getModel("x6").addCar(x6Taxi);

        ArrayList<Company> companies = new ArrayList<>();
        companies.add(audi);
        companies.add(vw);
        companies.add(bmw);

        Company.search(companies, "audi", true, 50);
    }
}
