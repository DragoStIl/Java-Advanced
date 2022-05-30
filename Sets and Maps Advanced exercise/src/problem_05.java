import javax.xml.namespace.QName;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class problem_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        Map<String, String> phoneBook = new HashMap<>();
        String[] tokens = scan.nextLine().split("-");

        while (!tokens[0].equals("search")){
            String name = tokens[0];
            String number = tokens[1];

            phoneBook.putIfAbsent(name, "");
            phoneBook.replace(name, number);

            tokens = scan.nextLine().split("-");
        }

        String command = scan.nextLine();
        while (!command.equals("stop")){
            if (phoneBook.containsKey(command)){
                System.out.println(command + " -> " + phoneBook.get(command));
            } else {
                System.out.printf("Contact %s does not exist.%n", command);
            }
            command = scan.nextLine();
        }
    }
}
