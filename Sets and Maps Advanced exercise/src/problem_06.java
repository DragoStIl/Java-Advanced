import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class problem_06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Integer> resources = new LinkedHashMap<>();

        String resource = scan.nextLine();
        while (!resource.equals("stop")){
            int quantity = Integer.parseInt(scan.nextLine());
            resources.putIfAbsent(resource, 0);
            resources.put(resource, resources.get(resource) + quantity);

            resource = scan.nextLine();
        }
        resources.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
