import java.util.Arrays;
import java.util.Scanner;

public class problem_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] inputSize = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        String[][] matrix = new String[inputSize[0]][];

        matrix = matrixFiller(matrix, scan);

        String input = scan.nextLine();

        while (!input.equals("END")){
            boolean correctInput = inputCheck(input, matrix);
            if (correctInput){
                String[] splitCommand = input.split("\\s+");
                int row1 = Integer.parseInt(splitCommand[1]);
                int col1 = Integer.parseInt(splitCommand[2]);
                int row2 = Integer.parseInt(splitCommand[3]);
                int col2 = Integer.parseInt(splitCommand[4]);

                String firstValue = matrix[row1][col1];
                String secondValue = matrix[row2][col2];
                matrix[row1][col1] = secondValue;
                matrix[row2][col2] = firstValue;
                matrixPrinter(matrix);
            } else {
                System.out.println("Invalid input!");
            }


            input = scan.nextLine();
        }


    }

    private static void matrixPrinter(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static boolean inputCheck(String input, String[][] matrix) {
        String[] splitCommand = input.split("\\s+");

        if (splitCommand.length != 5) {
            return false;
        }
        if (!splitCommand[0].equals("swap")){
            return false;
        }
        int row1 = Integer.parseInt(splitCommand[1]);
        int col1 = Integer.parseInt(splitCommand[2]);
        int row2 = Integer.parseInt(splitCommand[3]);
        int col2 = Integer.parseInt(splitCommand[4]);
        if (row1 < 0 || row1 >= matrix.length || col1 < 0 || col1 >= matrix[row1].length
        || row2 < 0 || row2 >= matrix.length || col2 < 0 || col2 >= matrix[row2].length){
            return false;
        }
        return true;
    }

    private static String[][] matrixFiller(String[][] inputMatrix, Scanner scan) {
        String[][] matrix = new String[inputMatrix.length][];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scan.nextLine().split("\\s+");
        }
        return matrix;
    }
}
