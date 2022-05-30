import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class problem_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(", ");

        Set<String> cars = new LinkedHashSet<>();
        while (!input[0].equals("END")){
            String carNumber = input[1];
            boolean motion = input[0].equals("IN")
                    ? cars.add(input[1])
                    : cars.remove(input[1]);


            input = scan.nextLine().split(", ");
        }
        if (cars.isEmpty()){
            System.out.println("Parking Lot is Empty");
        } else {
            for (String car : cars) {
                System.out.println(car);
            }
        }
    }
}
