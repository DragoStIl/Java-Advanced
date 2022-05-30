import java.util.*;

public class problem_06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");
        ArrayDeque<String> players = new ArrayDeque<>();
        Collections.addAll(players, input);

        int tosses = Integer.parseInt(scan.nextLine());
        if (tosses > 1 && !players.isEmpty()) {
            while (players.size() > 1) {
                for (int i = 0; i < tosses - 1; i++) {
                    String name = players.poll();
                    players.offer(name);
                }
                System.out.println("Removed " + players.poll());
            }
        } else {
            while (players.size() > 1){
                System.out.println("Removed " + players.poll());
            }
        }
        if (!players.isEmpty()) {
            System.out.println("Last is " + players.pollLast());
        }
    }
}
