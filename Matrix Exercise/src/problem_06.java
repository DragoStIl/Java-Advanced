import java.util.*;

public class problem_06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String rotate = scan.nextLine();
        //6
        int degrees = Integer.parseInt(rotate.substring(7, rotate.length() - 1));
        int rotationCounter = 0;
        if (degrees != 0){
            rotationCounter = degrees / 90;
        }
        String input = scan.nextLine();
        List<String> inputWords = new ArrayList<>();

        int longestWord = 0;
        while(!input.equals("END")){
            inputWords.add(input);
            for (String word : inputWords) {
                if (word.length() > longestWord){
                    longestWord = word.length();
                }
            }
            input = scan.nextLine();
        }
        char[][] matrix = new char[inputWords.size()][longestWord];
        matrix = fillMatrix(inputWords, matrix);
        while (rotationCounter > 0) {
            matrix = matrixRotator(matrix, rotationCounter);
            rotationCounter--;
        }
        matrixPrinter(matrix);
    }

    private static char[][] matrixRotator(char[][] matrix, int rotations) {
        char[][] rotatedMatrix = new char[matrix[0].length][matrix.length];




            for (int col = 0; col < matrix[0].length; col++) {
                ArrayDeque<Character> currentCol = new ArrayDeque();

                for (int row = matrix.length - 1; row >= 0; row--) {
                    currentCol.offer(matrix[row][col]);
                }
                for (int secondaryCol = 0; secondaryCol < rotatedMatrix[0].length; secondaryCol++) {
                    if (!currentCol.isEmpty()) {
                        rotatedMatrix[col][secondaryCol] = currentCol.poll();
                    }
                }
            }
        return rotatedMatrix;
    }

    private static void matrixPrinter(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    private static char[][] fillMatrix(List<String> inputWords, char[][] matrix) {

        for (int row = 0; row < inputWords.size(); row++) {
            String[] splitWord = inputWords.get(row).split("(?!^)");
            for (int col = 0; col < splitWord.length; col++) {
                matrix[row][col] = splitWord[col].charAt(0);
            }
            for (int afterWord = splitWord.length; afterWord < matrix[row].length; afterWord++) {
                matrix[row][afterWord] = ' ';
            }
        }
        return matrix;
    }
}
