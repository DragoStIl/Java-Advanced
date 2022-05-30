import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class problem_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // 1 + (2 - (2 + 3) * 4 / (3 + 1)) * 5

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        String input = scan.nextLine();


        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (current == '('){
                stack.push(i);
            } else if(current == ')'){
                int startIndex = stack.pop();
                System.out.println(input.substring(startIndex, i + 1));
            }
        }
    }
}
