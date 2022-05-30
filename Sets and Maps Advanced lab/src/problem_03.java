import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class problem_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<Integer> firstPlayer = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));

        Set<Integer> secondPlayer = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));


        int rounds = 50;

        while (rounds-- > 0 && !firstPlayer.isEmpty() && !secondPlayer.isEmpty()){
            int firstCard = firstPlayer.iterator().next();
            firstPlayer.remove(firstCard);
            int secondCard = secondPlayer.iterator().next();
            secondPlayer.remove(secondCard);

            if (firstCard > secondCard){
                firstPlayer.add(firstCard);
                firstPlayer.add(secondCard);
            } else if (firstCard < secondCard){
                secondPlayer.add(firstCard);
                secondPlayer.add(secondCard);
            }
        }
        if (rounds == 0){
            System.out.println("Draw");
        } else if (firstPlayer.size() < secondPlayer.size()){
            System.out.println("Second player win!");
        } else if (firstPlayer.size() > secondPlayer.size()){
            System.out.println("First player win!");
        }
    }

    private static Set<Integer> deckFiller(int[] input, Set<Integer> player) {
        for (int card : input) {
            player.add(card);
        }
        return player;
    }
}
