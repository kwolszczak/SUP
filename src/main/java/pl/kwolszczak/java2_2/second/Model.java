package pl.kwolszczak.java2_2.second;

import java.util.ArrayList;

public record Model(String name, CAR_TYPE type, ArrayList<Car> cars) {
    public Model(String name, CAR_TYPE type) {
        this(name, type, new ArrayList<>());
    }

    public Model addCar(Car car) {
        if (!cars.contains(car)) {
            this.cars.add(car);
        }
        return this;
    }

    @Override
    public ArrayList<Car> cars() {
        return cars;
    }
}
