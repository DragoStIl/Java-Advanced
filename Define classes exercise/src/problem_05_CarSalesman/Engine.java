package problem_05_CarSalesman;

public class Engine {
    ////{Model} {Power} {Displacement} {Efficiency}
    private String model;
    private int power;
    private int displacement = 0;
    private String efficiency = "n/a";


    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
    }

    public Engine(String model, int power, int displacement, String efficiency){
        this(model, power);
        this.displacement = displacement;
        this.efficiency = efficiency;

    }

    public Engine(String model, int power, int displacement) {
        this(model, power);
        this.displacement = displacement;
    }

    public Engine(String model, int power, String efficiency) {
        this(model, power);
        this.efficiency = efficiency;
    }

    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    public int getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    @Override
    public String toString() {
        String displace = "n/a";
        if (displacement > 0){
            displace = String.valueOf(displacement);
        }
        return String.format("%s:%nPower: %d%nDisplacement: %s%nEfficiency: %s",model, power, displace, efficiency);
    }
}
