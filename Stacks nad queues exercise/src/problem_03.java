import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class problem_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int commands = Integer.parseInt(scan.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < commands; i++) {
            List<Integer> newCommand = Arrays.stream(scan.nextLine().split("\\s+"))
                    .map(Integer::parseInt).collect(Collectors.toList());

            if (newCommand.get(0) == 1){
                stack.push(newCommand.get(1));
            } else if (newCommand.get(0) == 2){
                if (!stack.isEmpty()){
                    stack.pop();
                }
            } else if (newCommand.get(0) == 3){
                if (!stack.isEmpty()){
                    System.out.println(Collections.max(stack));
                }
            }
        }
    }
}
