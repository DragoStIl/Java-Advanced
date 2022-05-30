import java.util.ArrayDeque;
import java.util.Scanner;

public class problem_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        ArrayDeque<Character> open = new ArrayDeque<>(); //stack
        ArrayDeque<Character> close = new ArrayDeque<>(); //queue

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);

            if (current == '(' || current == '{' || current == '['){
                open.push(current);
            } else if (current == ')' || current == '}' || current == ']'){
                close.offer(current);
            }
        }
        boolean balanced = true;
        if (!open.isEmpty() && !close.isEmpty() && open.size() == close.size()){
            while (!open.isEmpty() && !close.isEmpty()) {
                if (open.peek() == '(' && close.peek() == ')'){
                    open.pop();
                    close.poll();
                } else if (open.peek() == '{' && close.peek() == '}'){
                    open.pop();
                    close.poll();
                } else if (open.peek() == '[' && close.peek() == ']'){
                    open.pop();
                    close.poll();
                } else {
                    balanced = false;
                    break;
                }
            }
        } else {
            balanced = false;
        }
        if (balanced && open.isEmpty() && close.isEmpty()){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
