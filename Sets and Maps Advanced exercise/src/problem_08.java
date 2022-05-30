import java.util.*;

public class problem_08 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        Map<String, Set<String>> players = new LinkedHashMap<>();

        String[] input = scan.nextLine().split(":\\s+");

        while (!input[0].equals("JOKER")){
            String name = input[0];
            players.putIfAbsent(name, new HashSet<>());
            String[] drawnCards = input[1].split(", ");
            Set<String> currentPlayer = players.get(name);
            currentPlayer.addAll(Arrays.asList(drawnCards));

            input = scan.nextLine().split(":\\s+");

        }

        players.forEach((key, value) -> {
            int points = value.stream().mapToInt(problem_08::cardPointsCalculator).sum();
            System.out.println(key + ": " + points);
        });

    }

    private static int cardPointsCalculator(String c) {
        int cardPoints = 0;
        String power;
        String type;
        if (c.length() == 2){
            power = String.valueOf(c.charAt(0));
            type  = String.valueOf(c.charAt(1));
        } else {
            power = c.substring(0, 2);
            type = String.valueOf(c.charAt(2));
        }
        // Where P (2, 3, 4, 5, 6, 7, 8, 9, 10, J(11), Q(12), K(13), A(14))
        switch (power){
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "10":
                cardPoints += Integer.parseInt(power);
                break;
            case "J":
                cardPoints += 11;
                break;
            case "Q":
                cardPoints += 12;
                break;
            case "K":
                cardPoints += 13;
                break;
            case "A":
                cardPoints += 14;
                break;


                // T (S(4), H(3), D(2), C(1))
        }
        switch (type){
            case "S":
                cardPoints *= 4;
                break;
            case "H":
                cardPoints *= 3;
                break;
            case "D":
                cardPoints *= 2;
                break;
            case "C":
                cardPoints *= 1;
                break;
        }
        return cardPoints;
    }
}
