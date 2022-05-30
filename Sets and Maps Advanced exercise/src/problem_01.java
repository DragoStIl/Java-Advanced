import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class problem_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<String> names = new LinkedHashSet<>();

        int n = Integer.parseInt(scan.nextLine());

        while   (n-- > 0){
            names.add(scan.nextLine());
        }
        names.forEach(System.out::println);
    }
}
