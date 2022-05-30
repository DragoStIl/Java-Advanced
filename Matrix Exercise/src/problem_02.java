import java.util.Scanner;

public class problem_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // char 'a' == 97

        String input = scan.nextLine();
        int rows = Integer.parseInt(input.split("\\s+")[0]);
        int cols = Integer.parseInt(input.split("\\s+")[1]);

        String[][] matrix = new String[rows][cols];

        matrix = matrixFiller(matrix);
        matrixPrinter(matrix);
    }

    private static String[][] matrixFiller(String[][] matrix) {
        char letter = 'a';
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                StringBuilder charSequence = new StringBuilder();
                charSequence.append(letter);
                charSequence.append((char)(letter + col));
                charSequence.append(letter);

                matrix[row][col] = charSequence.toString();
            }
            letter++;
        }
        return matrix;
    }

    private static void matrixPrinter(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
