import java.util.*;

public class problem_11 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Set<String>> usersHistory = new TreeMap<>();
        Map<String, Integer> userTimeSpend = new HashMap<>();

        int n = Integer.parseInt(scan.nextLine());

        while (n-- > 0){
            // 192.168.0.11 peter 33
            String[] inputTokens = scan.nextLine().split("\\s+");


            usersHistory.putIfAbsent(inputTokens[1], new TreeSet<>());
            Set<String> currentUser = usersHistory.get(inputTokens[1]);
            currentUser.add(inputTokens[0]);

            userTimeSpend.putIfAbsent(inputTokens[1], 0);
            userTimeSpend.put(inputTokens[1], userTimeSpend.get(inputTokens[1]) + Integer.parseInt(inputTokens[2]));

        }

        for (Map.Entry<String, Set<String>> u : usersHistory.entrySet()) {
            System.out.println(u.getKey() + ": " + userTimeSpend.get(u.getKey())
                    + " [" + String.join(", ", u.getValue()) + "]");
        }
    }
}
