package problem_04_RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        List<Car> cars = new ArrayList<>();

        while (n-- > 0){
            String[] carData = scan.nextLine().split("\\s+");
            String model = carData[0];

            // engine data
            int speed = Integer.parseInt(carData[1]);
            int power = Integer.parseInt(carData[2]);
            Engine engine = new Engine(speed, power);

            // cargo data
            int weight = Integer.parseInt(carData[3]);
            String type = carData[4];


            //tire data
            List<Tires> currentCarTires = new ArrayList<>();
            for (int i = 5; i < carData.length - 1; i += 2) {
                double pressure = Double.parseDouble(carData[i]);
                int year = Integer.parseInt(carData[i + 1]);
                Tires tire = new Tires(pressure, year);
                currentCarTires.add(tire);
            }

            Car car = new Car(model, engine, weight, type, currentCarTires);
            cars.add(car);

            // ChevroletAstro(the car)[0]
            // 200(engine speed)[1] 180(engine power)[2
            // 1000(cargo weight)[3] fragile(cargo type)[4]
            // 1.3(pressure)[5] 1(year old)[6] / (first tire data)
            // 1.5(pressure)[7] 2(year old)[8] /(second tire data)
            // 1.4(pressure)[9] 2(year old)[10] / (third tire data)
            // 1.7(pressure)[11] 4(year old)[12] / (forth tire data)

        }

        String delivery = scan.nextLine();
        if (delivery.equals("fragile")){
            // Cargo Type is "fragile" with a tire whose pressure is  < 1
            cars.stream().filter(car -> car.getCargoType().equals(delivery))
                    .filter(c -> !c.tirePressureCheck()).forEach(c -> System.out.println(c.getModel()));

        } else {
            // Cargo Type is "flamable" and have Engine Power > 250
            cars.stream().filter(car -> car.getCargoType().equals(delivery))
                    .filter(car -> car.getEngine().getPower() > 250)
                    .forEach(car -> System.out.println(car.getModel()));
        }





    }
}
