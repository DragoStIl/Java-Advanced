package problem_05_CarSalesman;

public class Car {
    // {Model} {Engine} {Weight} {Color}
    private String model;
    private Engine engine;
    private int weight = 0;
    private String color = "n/a";


    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    public Car(String model, Engine engine, int weight, String color) {
        this(model, engine);
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine);
        this.weight = weight;
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine);
        this.color = color;
    }

    @Override
    public String toString() {
        String weightString = "n/a";
        if (weight > 0) {
            weightString = String.valueOf(weight);
        }


        return String.format("%s:%n%s%nWeight: %s%nColor: %s", model, engine, weightString, color);
    }
}
