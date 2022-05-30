import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        String input = scan.nextLine();

        String[] splitWord = input.split("(?!^)");
        char[][] matrix = new char[1][6];
        for (int i = 0; i < splitWord.length; i++) {
            matrix[0][i] = splitWord[i].charAt(0);
        }
        for (int index = splitWord.length; index < matrix[0].length; index++) {
            matrix[0][index] = ' ';
        }
        for (char[] chars : matrix) {
            for (char current : chars) {
                System.out.print(current + " ");
            }
        }
    }
}
