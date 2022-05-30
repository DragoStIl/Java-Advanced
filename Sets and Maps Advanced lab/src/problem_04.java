
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class problem_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double[] input = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble).toArray();

        Map<Double, Integer> occurrences = new LinkedHashMap<>();


        for (double number : input) {
            occurrences.putIfAbsent(number, 0);
            occurrences.put(number, occurrences.get(number) + 1);
        }

        occurrences.entrySet().stream().forEach(e -> System.out.printf("%.1f -> %d%n", e.getKey(), e.getValue()));
    }
}
