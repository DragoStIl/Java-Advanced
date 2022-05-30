package problem_01_CarInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int cars = Integer.parseInt(scan.nextLine());
        List<Car> garage = new ArrayList<>();
        while (cars-- > 0){
            String[] carData = scan.nextLine().split("\\s+");
            if (carData.length == 3){
                Car car = new Car(carData[0], carData[1], Integer.parseInt(carData[2]));
                garage.add(car);

            } else if (carData.length == 1){
                Car car = new Car(carData[0]);
                garage.add(car);
            } else if (carData.length == 2){
                try {
                    int hp = Integer.parseInt(carData[1]);
                    Car car = new Car(carData[0], hp);
                    garage.add(car);
                } catch (NumberFormatException e){
                    String model = carData[1];
                    Car car = new Car(carData[0], model);
                    garage.add(car);
                }

            }
        }
        garage.forEach(System.out::println);
    }
}
