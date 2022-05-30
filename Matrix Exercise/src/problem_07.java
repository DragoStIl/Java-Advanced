import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class problem_07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String inputSize = scan.nextLine();
        int rows = Integer.parseInt(inputSize.split("\\s+")[0]);
        int cols = Integer.parseInt(inputSize.split("\\s+")[1]);
        int filler = 1;
        int[][] matrix =  fillerOfMatrix(filler, rows, cols);


        String explosions = scan.nextLine();
        while (!explosions.equals("Nuke it from orbit")){
            int exRow = Integer.parseInt(explosions.split("\\s+")[0]);
            int exCol = Integer.parseInt(explosions.split("\\s+")[1]);
            int exRange = Integer.parseInt(explosions.split("\\s+")[2]);
            boolean validCoordinates = false;
            if (exRow >= 0 && exRow < matrix.length && exCol >= 0 && exCol < matrix[exRow].length){
                validCoordinates = true;
            }
            if (validCoordinates){
                matrix = bomb(matrix, exRow, exCol, exRange);
            }
            explosions = scan.nextLine();
        }

        printerOfMatrix(matrix);
    }

    private static int[][] bomb(int[][] matrix, int exRow, int exCol, int exRange) {

        matrix[exRow][exCol] = 0;
        for (int i = 1; i <= exRange; i++) {
            if (exRow + i < matrix.length && exCol < matrix[exRow + i].length){ // row -> down
                matrix[exRow + i][exCol] = 0;
            }
            if (exRow - i >= 0 && exCol < matrix[exRow - i].length){ // row -> up
                matrix[exRow - i][exCol] = 0;
            }
            if (exCol + i < matrix[exRow].length){ // col -> right
                matrix[exRow][exCol + i] = 0;
            }
            if (exCol - i >= 0){ // col -> left
                matrix[exRow][exCol - i] = 0;
            }
        }
        return clearTheZeros(matrix);
    }

    private static int[][] clearTheZeros(int[][] matrix) {
        int[][] clearMatrix = new int[matrix.length][];

        for (int row = 0; row < matrix.length; row++) {
            ArrayDeque<Integer> currentRow = new ArrayDeque<>();
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] != 0){
                    currentRow.offer(matrix[row][col]);
                }
            }
            String current = String.join(" ", currentRow.toString());
            current = current.replace("[", "");
            current = current.replace("]", "");
            current = current.replaceAll(",", "");




            if (!current.equals("")) {
                clearMatrix[row] = Arrays.stream(current.split(" ")).mapToInt(Integer::parseInt).toArray();
            }
        }

        return clearMatrix;
    }

    private static int[][] fillerOfMatrix(int filler, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = filler;
                filler++;
            }
        }
        return matrix;
    }

    private static void printerOfMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row] != null) {
                for (int col = 0; col < matrix[row].length; col++) {
                    System.out.print(matrix[row][col] + " ");
                }
                System.out.println();
            }
        }
    }
}
