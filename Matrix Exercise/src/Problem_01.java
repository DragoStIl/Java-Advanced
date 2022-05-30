import java.util.Scanner;

public class Problem_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        int size = Integer.parseInt(input.split(", ")[0]);
        String model = input.split(", ")[1];

        int[][] matrix = new int[size][size];

        if (model.equals("A")){
            matrix = matrixFillerA(matrix);
        } else if (model.equals("B")){
            matrix = matrixFillerB(matrix);
        }

        matrixPrinter(matrix);

        //A:
        //1 4 7
        //2 5 8
        //3 6 9

        //B:
        //1 6 7
        //2 5 8
        //3 4 9
    }

    private static int[][] matrixFillerA(int[][] matrix) {
        int number = 1;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = number;
                number++;
            }
        }
        return matrix;
    }

    private static int[][] matrixFillerB(int[][] matrix) {
        int number = 1;
        for (int col = 0; col < matrix.length; col++) {
            if (col % 2 != 0){ // четна колона
                for (int row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][col] = number;
                    number++;
                }
            } else { // нечетна колона
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = number;
                    number++;
                }
            }
        }
        return matrix;
    }

    private static void matrixPrinter(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
