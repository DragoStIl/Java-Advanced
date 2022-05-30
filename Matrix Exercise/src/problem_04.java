import java.util.Arrays;
import java.util.Scanner;

public class problem_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = Integer.parseInt(scan.nextLine().split("\\s+")[0]);

        int[][] matrix = new int[rows][];
        matrix = matrixFiller(matrix, scan);

        maxSubMatrix(matrix);
    }

    private static void maxSubMatrix(int[][] matrix) {
        int[][] subMatrix = new int[3][3];
        int sum = Integer.MIN_VALUE;
        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int current = 0;

                // LEFT
                int upLeft = matrix[row][col];       // 00
                int midLeft = matrix[row + 1][col];  // 10
                int botLeft = matrix[row + 2][col]; // 20

                // MID
                int upMid = matrix[row][col + 1];     // 01
                int mid = matrix[row + 1][col + 1];       // 11
                int botMid = matrix[row + 2][col + 1];    // 21

                // RIGHT
                int upRight = matrix[row][col + 2];    //02
                int midRight = matrix[row + 1][col + 2];   //12
                int botRight = matrix[row + 2][col + 2];   //22

                current = upLeft + midLeft + botLeft + upMid + mid + botMid + upRight + midRight + botRight;


                if (current > sum){
                    sum = current;
                    subMatrix[0][0] = upLeft;
                    subMatrix[1][0]= midLeft;
                    subMatrix[2][0] = botLeft;

                    subMatrix[0][1] = upMid;
                    subMatrix[1][1]= mid;
                    subMatrix[2][1] = botMid;

                    subMatrix[0][2] = upRight;
                    subMatrix[1][2]= midRight;
                    subMatrix[2][2] = botRight;
                }

            }
        }
        System.out.println("Sum = " + sum);
        matrixPrinter(subMatrix);
    }

    private static void matrixPrinter(int[][] subMatrix) {
        for (int row = 0; row < subMatrix.length; row++) {
            for (int col = 0; col < subMatrix[row].length; col++) {
                System.out.print(subMatrix[row][col] + " ");
            }

            System.out.println();
        }
    }

    private static int[][] matrixFiller(int[][] matrix, Scanner scan) {

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
