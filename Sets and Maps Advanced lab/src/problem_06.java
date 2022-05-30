import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class problem_06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Map<String, Map<String, Double>> shopsData = new TreeMap<>();

        while (!input.equals("Revision")){
            String[] tokens = input.split(", ");
            String shop = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            shopsData.putIfAbsent(shop, new LinkedHashMap<>());
            Map<String, Double> current = shopsData.get(shop);
            current.putIfAbsent(product, price);


            input = scan.nextLine();
        }

        shopsData.entrySet().stream().forEach(e -> {
            System.out.println(e.getKey() + "->");
            e.getValue().entrySet().stream().forEach(x -> {
                System.out.printf("Product: %s, Price: %.1f%n", x.getKey(), x.getValue());
            });
        });
    }
}
