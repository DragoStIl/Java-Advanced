import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class problem_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int toPush = scan.nextInt();
        int toPop = scan.nextInt();
        int toCheck = scan.nextInt();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < toPush; i++) {
            stack.offer(scan.nextInt());
        }
        if (toPop <= stack.size()){
            for (int i = 0; i < toPop; i++) {
                    stack.poll();
            }
        }
        if (!stack.isEmpty()){
            if (stack.contains(toCheck)){
                System.out.println("true");
            } else {
                System.out.println(Collections.min(stack));
            }
        } else {
            System.out.println(0);
        }
    }
}
