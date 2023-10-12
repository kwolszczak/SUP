package pl.kwolszczak.java2_2.second;

import java.util.ArrayList;

public record Company(String name, ArrayList<Model> models) {
    public Company(String name) {
        this(name, new ArrayList<>());
    }

    public Company addModel(Model model) {
        if (!models.contains(model)) {
            this.models.add(model);
        }
        return this;
    }

    public Company removeModel(Model model) {
        if (models.contains(model)) {
            this.models.remove(model);
        }
        return this;
    }

    public Model getModel(String model) {
        return models.stream()
                .filter(m -> m.name().equalsIgnoreCase(model))
                .findFirst()
                .orElse(null);

    }

    public static void search(ArrayList<Company> companies, String company, boolean hasAutomaticGear, int trankCapacity){
        for (var c : companies) {
            if (c.name().equalsIgnoreCase(company)) {
                for (var m : c.models) {
                    for (var car : m.cars()) {
                        if (car.hasAutomaticGear() == hasAutomaticGear && car.getDimension().getTrunkCapacityInLiters() > trankCapacity) {
                            System.out.println(m.name());
                            System.out.println();
                            System.out.println(car);
                          //  System.out.println(car.getMarket().getCountries() + "  " + country.name());
                        }
                    }
                }
            }
        }

    }
}
