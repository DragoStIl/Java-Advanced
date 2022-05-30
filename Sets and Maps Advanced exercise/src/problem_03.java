import java.util.*;

public class problem_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        Set<String> periodicTable = new TreeSet<>();
        while (n-- > 0){
            String[] input = scan.nextLine().split("\\s+");
            periodicTable.addAll(Arrays.asList(input));
        }
        periodicTable.forEach(e -> System.out.print(e + " "));
    }
}
