import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class problem_07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // us", "uk" or “com

        Map<String, String> contacts = new LinkedHashMap<>();

        String name = scan.nextLine();
        while (!name.equals("stop")){
            String email = scan.nextLine();

            String[] badDomain = email.split("\\.");
            if (!badDomain[badDomain.length - 1].equals("us")
                    && !badDomain[badDomain.length - 1].equals("com")
                    && !badDomain[badDomain.length - 1].equals("uk")){
                contacts.putIfAbsent(name, "");
                contacts.replace(name, email);
            }

            name = scan.nextLine();
        }
        contacts.forEach((key, value) -> System.out.printf("%s -> %s%n", key, value));

    }
}
