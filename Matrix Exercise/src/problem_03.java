import java.util.Arrays;
import java.util.Scanner;

public class problem_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());

        int[][] matrix = new int[size][];
        matrix = matrixFiller(matrix, scan);

        int diagonalsDiff = diagonalsFiner(matrix);
        System.out.println(diagonalsDiff);
    }

    private static int diagonalsFiner(int[][] matrix) {
        int sum = 0;
        int sum2 = 0;

        // primary diagonal;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }

        //secondary diagonal
        int col = 0;
        for (int i = matrix.length - 1; i >= 0; i--) {
            sum2 += matrix[i][col];
            col++;
        }


        return Math.abs(sum - sum2);
    }

    private static int[][] matrixFiller(int[][] matrix, Scanner scan) {

        for (int row = 0; row < matrix.length; row++) {
                matrix[row] = Arrays.stream(scan.nextLine().split("\\s+"))
                        .mapToInt(Integer::parseInt).toArray();
        }

        return matrix;
    }
}
