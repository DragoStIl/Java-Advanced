import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class problem_07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<String> players = new ArrayList<String>(Arrays.asList(scan.nextLine().split("\\s+")));
        int tosses = Integer.parseInt(scan.nextLine());
        ArrayDeque<String> switching = new ArrayDeque<>();

        for (String player : players) {
            switching.offer(player);
        }

        int x = 1;
        while (switching.size() > 1){

            for (int i = 1; i < tosses; i++) {
                switching.offer(switching.poll());
            }
            if (isPrime(x)) {
                System.out.println("Prime " + switching.peek());
            } else {
                System.out.println("Removed " + switching.poll());
            }
            x++;
        }
        System.out.println("Last is " + switching.peek());
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int y = 2; y <= Math.sqrt(number); y++) {
            if (number % y == 0) {
                return false;
            }
        }
        return true;
    }

}
