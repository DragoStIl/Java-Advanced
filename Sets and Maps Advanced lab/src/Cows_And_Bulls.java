import java.util.*;
import java.util.function.Supplier;

public class Cows_And_Bulls {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);


        Supplier<Integer> genRandomNumber = () -> new Random().nextInt(9);
        Set<Integer> uniqueNumbers = new LinkedHashSet<>();

        while (uniqueNumbers.size() < 4){

            uniqueNumbers.add(genRandomNumber.get());
        }
        List<Integer> uniqueNumbersList = uniqueNumbers.stream().toList();



        StringBuilder equality = new StringBuilder();
        while  (!equality.toString().equals("BBBB")) {
            List<Integer> playerGuess= playerNumbersSplitter(scan);

            equality = new StringBuilder();
            for (int i = 0; i < uniqueNumbersList.size(); i++) {
                // ako go ima v lista
                if (uniqueNumbersList.contains(playerGuess.get(i))) {
                    //ako e na ednakvo mqsto
                    if (uniqueNumbersList.get(i).equals(playerGuess.get(i))) {
                        equality.append("B");
                    } else {
                        equality.append("C");
                    }
                    // ako ne e
                } else {
                    equality.append("X");
                }
            }
            System.out.println(equality);
        }

        if (equality.toString().equals("BBBB")){
            System.out.println("You win!");
        }

    }

    private static List<Integer> playerNumbersSplitter(Scanner scan) {
        String input = scan.nextLine();
        Set<Integer> playerGuess = new LinkedHashSet<>();

        while (playerGuess.size() < 4) {
            playerGuess = new LinkedHashSet<>();
            if (input.length() == 4) {
                for (int i = 0; i < input.length(); i++) {
                    int num = Integer.parseInt(input.substring(i, i + 1));
                    playerGuess.add(num);
                }
            } else {
                System.out.println("Wrong input, try again");
            }
            if (playerGuess.size() < 4) {
                input = scan.nextLine();
            }
        }
        return playerGuess.stream().toList();
    }
}
