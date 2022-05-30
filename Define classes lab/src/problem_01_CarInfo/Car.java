package problem_01_CarInfo;

public class Car {
    private String brand;
    private String model;
    private int horsePower;

    public Car(String brand){
        this.brand = brand;
        this.model = "unknown";
        this.horsePower = -1;
    }

    public Car(String brand, String model, int horsePower) {
        this(brand);
        this.model = model;
        this.horsePower = horsePower;
    }

    public Car(String brand, int horsepower) {
        this(brand);
        this.horsePower = horsepower;
    }

    public Car(String brand, String model){
        this(brand);
        this.model = model;
    }


    public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }

    public int getHorsePower() {
        return this.horsePower;
    }


    @Override
    public String toString() {
        return ("The car is: " + this.brand + " " + this.model + " - " + this.horsePower + " HP.");
    }
}
