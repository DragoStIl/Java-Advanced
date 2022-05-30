import java.util.ArrayDeque;
import java.util.Scanner;

public class problem_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (String s : input) {
            stack.add(s);
        }
        int sum = 0;
        while(!(stack.size() == 1)){
            int first = Integer.parseInt(stack.pop());
            String operation = stack.pop();
            int second = Integer.parseInt(stack.pop());
            if (operation.equals("-")){
                int result = first - second;
                String value = String.valueOf(result);
                stack.push(value);
            } else {
                int result = first + second;
                String value = String.valueOf(result);
                stack.push(value);
            }

        }
        System.out.println(stack.peek());
    }
}
