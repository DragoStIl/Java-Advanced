import java.util.ArrayDeque;
import java.util.Scanner;

public class problem_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int input = Integer.parseInt(scan.nextLine());
        ArrayDeque<Integer> binary = new ArrayDeque<>();

        if (input == 0){
            System.out.println(input);
        }
        while(input != 0){
            binary.push(input % 2);
            input /= 2;
        }

        while (!binary.isEmpty()){
            int current = binary.pop();
            System.out.print(current);
        }

    }
}
