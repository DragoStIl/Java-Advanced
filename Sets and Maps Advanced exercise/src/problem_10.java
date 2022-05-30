import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class problem_10 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        Map<String, Map<String, Long>> worldPopulation = new LinkedHashMap<>();
        Map<String, Long> countryPopulation = new LinkedHashMap<>();

        while (!input.equals("report")){
            String[] tokens = input.split("\\|");

            String country = tokens[1];
            String city = tokens[0];
            long population = Integer.parseInt(tokens[2]);
            worldPopulation.putIfAbsent(country, new LinkedHashMap<>());

            countryPopulation.putIfAbsent(country, 0L);
            countryPopulation.put(country, countryPopulation.get(country) + population);




            Map<String, Long> currentCity = worldPopulation.get(country);
            currentCity.putIfAbsent(city, 0L);
            currentCity.put(city, currentCity.get(city) + population);


            input = scan.nextLine();
        }
        countryPopulation.entrySet().stream()
                .sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue()))
                .forEach(co -> {
                    System.out.printf("%s (total population: %d)%n", co.getKey(), co.getValue());
                    String currentKey = co.getKey();
                    worldPopulation.get(currentKey).entrySet().stream()
                            .sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue()))
                            .forEach(ci -> System.out.printf("=>%s: %d%n", ci.getKey(), ci.getValue()));
                });
    }
}
