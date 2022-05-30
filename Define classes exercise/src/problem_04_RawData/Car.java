package problem_04_RawData;

import java.util.List;
import java.util.stream.Collectors;

public class Car {
    private String model;
    private Engine engine;
    private int cargoWeight;
    private String cargoType;
    private List<Tires> tires;

    public Car(String model, Engine engine, int cargoWeight, String cargoType, List<Tires> tires) {
        this.model = model;
        this.engine = engine;
        this.cargoWeight = cargoWeight;
        this.cargoType = cargoType;
        this.tires = tires;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public int getCargoWeight() {
        return cargoWeight;
    }

    public String getCargoType() {
        return cargoType;
    }

    public List<Tires> getTires() {
        return tires;
    }

    public boolean tirePressureCheck(){
        tires.removeIf(tire -> tire.getPressure() < 1);
        if (tires.size() == 4){
            return true;
        }
        return false;
    }
}
