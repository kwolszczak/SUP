package pl.kwolszczak.java2_2.model;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Car {
    private Producent producent;
    private boolean hasAutomaticGear;
    private Market market;
    private Segment segment;
    private Dimension dimension;

    public Car(Producent producent, boolean hasAutomaticGear, Market market, Segment segment, Dimension dimension) {
        this.producent = producent;
        this.hasAutomaticGear = hasAutomaticGear;
        this.market = market;
        this.segment = segment;
        this.dimension = dimension;
    }

    public static void searchCountry(List<Car> cars, String model, boolean hasAutomaticGear, int trankCapacity) {

        String notFoundObjInfo = "Sorry, I couldn't find an object. Check your criteria and try again";
        boolean isObjectFounded = false;
        boolean currentCarAutomationGear;
        int currentCarTrankCapacity;
        String currentCarModel;

        for (var car : cars) {

            currentCarAutomationGear = car.hasAutomaticGear;
            currentCarTrankCapacity = car.dimension.getTrunkCapacityInLiters();
            currentCarModel = car.producent.model();
            if (currentCarAutomationGear == hasAutomaticGear && currentCarTrankCapacity > trankCapacity && currentCarModel.equalsIgnoreCase(model)) {

                isObjectFounded = true;
                System.out.println(car.producent.model() + " " + car.producent.type());
                for (var country : car.market.getCountries()) {
                    System.out.println(country.code() + "  " + country.name());
                }
            }
        }
/*        var market=cars.stream()
                .filter(car->car.hasAutomaticGear==hasAutomaticGear)
                .filter(car->car.dimension.getTrunkCapacityInLiters()>trankCapacity)
              //  .filter(car->car.producent.model().equalsIgnoreCase(model))
                .collect(Collectors.groupingBy(
                        car->car.producent.model(),
                        Collectors.flatMapping(car->car.market.getCountries().stream().map(Country::name), Collectors.toSet())));
        var market2=cars.stream()
                .filter(car->car.hasAutomaticGear==hasAutomaticGear)
                .filter(car->car.dimension.getTrunkCapacityInLiters()>trankCapacity)
                //  .filter(car->car.producent.model().equalsIgnoreCase(model))
                .collect(Collectors.groupingBy(
                        car->car.producent.model(),
                        Collectors.groupingBy(car->car.market.getCountries())
                ));
        market2.entrySet().forEach(System.out::println);

        market.entrySet().forEach(System.out::println);*/

        if (!isObjectFounded){
            System.out.println(notFoundObjInfo);
        }
    }

}
