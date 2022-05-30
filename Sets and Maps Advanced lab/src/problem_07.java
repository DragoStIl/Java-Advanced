import java.util.*;

public class problem_07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int inputCounter = Integer.parseInt(scan.nextLine());

        Map<String, Map<String, List<String>>> world = new LinkedHashMap<>();

        for (int i = 0; i < inputCounter; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];

            world.putIfAbsent(continent, new LinkedHashMap<>());

            Map<String, List<String>> currentCountry = world.get(continent);
            currentCountry.putIfAbsent(country, new ArrayList<>());

            List<String> cities = currentCountry.get(country);
            cities.add(city);
        }
        world.entrySet()
                .stream()
                .forEach(c -> {
            System.out.println(c.getKey() + ":");
            c.getValue().entrySet()
                    .stream()
                    .forEach(co -> {
                System.out.println("  " + co.getKey() + " -> " + String.join(", ", co.getValue()));

            });
        });
    }
}
