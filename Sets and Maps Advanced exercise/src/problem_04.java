import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class problem_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        String input = scan.nextLine();
        Map<Character, Integer> charCounter = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            charCounter.putIfAbsent(current, 0);
            charCounter.put(current, charCounter.get(current) + 1);

        }
        charCounter.entrySet().forEach(e -> System.out.println(e.getKey() + ": " + e.getValue() + " time/s"));
    }
}
