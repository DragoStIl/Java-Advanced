package problem_03_SpeedRacing;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        Map<String, Car> garage = new LinkedHashMap<>();
        while (n-- > 0){
            String[] input = scan.nextLine().split("\\s+");
            String model = input[0];
            double fuel = Double.parseDouble(input[1]);
            double consummation = Double.parseDouble(input[2]);
            Car car = new Car(model, fuel, consummation);
            garage.putIfAbsent(model, car);

        }

        String[] input = scan.nextLine().split("\\s+");
        while (!input[0].equals("End")){
            int travel = Integer.parseInt(input[2]);
            String carModel = input[1];

            double leftFuel = garage.get(carModel).getFuel();
            double consummation = garage.get(carModel).getConsummation();
            if(travel * consummation <= leftFuel){
                garage.get(carModel).setTravelledDistance(garage.get(carModel).getTravelledDistance() + travel);
                garage.get(carModel).setFuel(garage.get(carModel).getFuel() - travel * consummation);
            } else {
                System.out.println("Insufficient fuel for the drive");
            }



            input = scan.nextLine().split("\\s+");
        }

        garage.entrySet().forEach(e -> System.out.println(e.getValue()));
    }
}
