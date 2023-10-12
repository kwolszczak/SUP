package pl.kwolszczak.java2_2;

import java.util.List;

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

        boolean currentCarAutomationGear;
        int currentCarTrankCapacity;
        String currentCarModel;

        for (var car : cars) {

            currentCarAutomationGear = car.hasAutomaticGear;
            currentCarTrankCapacity = car.dimension.getTrunkCapacityInLiters();
            currentCarModel = car.producent.model();
            if (currentCarAutomationGear == hasAutomaticGear && currentCarTrankCapacity > trankCapacity && currentCarModel.equalsIgnoreCase(model)) {

                System.out.println(car.producent.model() + " " + car.producent.type());
                for (var country : car.market.getCountries()) {
                    System.out.println(country.code() + "  " + country.name());
                }
            }

        }
    }

}
