package problem_03_SpeedRacing;

public class Car {
    private String model;
    private double fuel;
    private double consummation;
    private int travelledDistance;

    // SETTERS

    public void setModel(String model) {
        this.model = model;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public void setConsummation(double consummation) {
        this.consummation = consummation;
    }

    public void setTravelledDistance(int travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    //GETTERS

    public String getModel() {
        return model;
    }

    public double getFuel() {
        return fuel;
    }

    public double getConsummation() {
        return consummation;
    }

    public int getTravelledDistance() {
        return travelledDistance;
    }

    public Car(String model, double fuel, double consummation) {
        this.model = model;
        this.fuel = fuel;
        this.consummation = consummation;
        this.travelledDistance = 0;
    }
    @Override
    public String toString(){
        return String.format("%s %.2f %d", this.model, this.fuel, this.travelledDistance);
    }
}

