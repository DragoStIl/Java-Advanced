import java.util.ArrayDeque;
import java.util.Scanner;

public class problem_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        ArrayDeque<String> printQueue = new ArrayDeque<>();

        while(!input.equals("print")){
            switch (input){
                case "cancel":
                    if (!printQueue.isEmpty()){
                        String removing = printQueue.poll();
                        System.out.println("Canceled " + removing);
                    } else {
                        System.out.println("Printer is on standby");
                    }
                    break;
                default:
                    printQueue.offer(input);
                    break;
            }

            input = scan.nextLine();
        }

        while (!printQueue.isEmpty()){
            String current = printQueue.poll();
            System.out.println(current);
        }
    }
}
