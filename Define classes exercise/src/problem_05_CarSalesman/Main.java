package problem_05_CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Car> cars = new ArrayList<>();
        Map<String, Engine> engineCatalogue = new HashMap<>();

        int n = Integer.parseInt(scan.nextLine());
        while (n-- > 0){
            String[] engineData = scan.nextLine().split("\\s+");
            //{Model} {Power} {Displacement} {Efficiency}
            String model = engineData[0];
            int power = Integer.parseInt(engineData[1]);
            Engine engine = null;
            if (engineData.length == 4){
                int displacement = Integer.parseInt(engineData[2]);
                String efficiency = engineData[3];
                engine = new Engine(model, power, displacement, efficiency);

            } else if (engineData.length == 3){
                try {
                    int displacement = Integer.parseInt(engineData[2]);
                    engine = new Engine(model, power, displacement);

                } catch (NumberFormatException e){
                    String efficiency = engineData[2];
                    engine = new Engine(model, power, efficiency);

                }
            } else if (engineData.length == 2){
                engine = new Engine(model, power);
            }
            engineCatalogue.putIfAbsent(model, engine);
        }

        System.out.println();
        int m = Integer.parseInt(scan.nextLine());
        while (m-- > 0){
            String[] carData = scan.nextLine().split("\\s+");
            // FordFocus V4-33 1300 Silver
            String model = carData[0];
            String engine = carData[1]; //(get it from the catalogue)
            Car car = null;

            if (carData.length == 4){
                int weight = Integer.parseInt(carData[2]);
                String color = carData[3];
                car = new Car(model, engineCatalogue.get(engine), weight, color);
            } else if (carData.length == 3){
                try {
                    int weight = Integer.parseInt(carData[2]);
                    car = new Car(model, engineCatalogue.get(engine), weight);


                } catch (NumberFormatException e){
                    String color = carData[2];
                    car = new Car(model, engineCatalogue.get(engine), color);
                }
            } else if (carData.length == 2){
                car = new Car(model, engineCatalogue.get(engine));

            }
            cars.add(car);
        }


        cars.forEach(System.out::println);


        //{CarModel}:
        //{EngineModel}:
        //Power: {EnginePower}
        //Displacement: {EngineDisplacement}
        //Efficiency: {EngineEfficiency}
        //Weight: {CarWeight}
        //Color: {CarColor}

    }
}
