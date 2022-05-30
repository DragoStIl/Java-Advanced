import java.util.ArrayDeque;
import java.util.Scanner;

public class problem_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");
        ArrayDeque<String> reverse = new ArrayDeque<>();

        for (String s : input) {
            reverse.push(s);

        }

        for (String s : reverse) {
            System.out.print(s + " ");
        }
    }
}
