import java.util.ArrayDeque;
import java.util.Scanner;

public class problem_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        String input = scan.nextLine();
        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> forwards = new ArrayDeque<>();
        while (!input.equals("Home")){

            if (input.equals("back")){
                if (stack.size() < 2){
                    System.out.println("no previous URLs");
                } else {
                    forwards.push(stack.pop());
                    System.out.println(stack.peek());
                }
            } else if (input.equals("forward")){
                if  (forwards.isEmpty()){
                    System.out.println("no next URLs");
                } else {
                    stack.push(forwards.pop());
                    System.out.println(stack.peek());
                }

            } else {
                stack.push(input);
                forwards = new ArrayDeque<>();
                System.out.println(stack.peek());
            }


            input = scan.nextLine();
        }
    }
}
