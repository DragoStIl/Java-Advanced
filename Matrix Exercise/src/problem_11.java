import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class problem_11 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String dimensionsInput = scan.nextLine();
        int rows = Integer.parseInt(dimensionsInput.split("\\s+")[0]);
        int cols = Integer.parseInt(dimensionsInput.split("\\s+")[1]);

        int[][] mainMatrix = mainMatrixFiller(scan, rows);

        int[][] strangeMatrix = new int[rows + cols - 1][rows];
        strangeMatrix = strangeMatrixFiller(mainMatrix);


        System.out.println();

    }

    private static int[][] strangeMatrixFiller(int[][] matrix) {
        int borderIndex = 0;
        int[][] strangeMatrix = new int[(matrix.length + matrix[0].length) - 1][matrix.length];

        while (borderIndex < matrix.length) {
            ArrayDeque<Integer> rowStack = new ArrayDeque<>();
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][borderIndex] != 0) {
                    rowStack.push(matrix[i][borderIndex]);
                }
                matrix[i][borderIndex] = 0;
            }

            for (int j = borderIndex; j < matrix[0].length; j++) {
                if (matrix[matrix.length - (1 + borderIndex)][j] != 0) {
                    rowStack.push(matrix[matrix.length - (1 + borderIndex)][j]);
                }
                matrix[matrix.length - (1 + borderIndex)][j] = 0;
            }
            // TO DO -> EMPTY THE STACK AND LOAD ITS ELEMENTS IN THE MATRIX -> ROW BY ROW

            int lengthDiff = strangeMatrix.length - rowStack.size(); // empty cells -> zeros which won't be printed
            if (lengthDiff > 0) {
                for (int row = lengthDiff / 2; row < strangeMatrix.length - lengthDiff / 2; row++) {
                    strangeMatrix[row][borderIndex] = rowStack.pop();
                }
            } else {
                for (int row = 0; row < strangeMatrix.length; row++) {
                    strangeMatrix[row][borderIndex] = rowStack.pop();
                }

                borderIndex++;
            }
        }
        return strangeMatrix;
    }

        private static int[][] mainMatrixFiller (Scanner scan, int rows){
            int[][] mainMatrix = new int[rows][];
            for (int i = 0; i < mainMatrix.length; i++) {
                mainMatrix[i] = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            }
            return mainMatrix;
        }
    }
