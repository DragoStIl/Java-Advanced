import java.util.ArrayDeque;
import java.util.Scanner;

public class problem_07 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int operations = Integer.parseInt(scan.nextLine());

        StringBuilder text = new StringBuilder();
        ArrayDeque<String> previousVersions = new ArrayDeque<>();

        while (operations-- > 0){
            String[] tokens = scan.nextLine().split("\\s+");
            int command = Integer.parseInt(tokens[0]);


            switch (command){
                case 1:
                    previousVersions.push(text.toString());
                    text.append(tokens[1]);
                    break;
                case 2:
                    int toErase = Integer.parseInt(tokens[1]);
                    if (toErase <= text.length() && toErase > 0){
                        previousVersions.push(text.toString());
                        text.delete(text.length() - (toErase), text.length());

                    }
                    break;
                case 3:
                    int index = Integer.parseInt(tokens[1]) - 1;
                    if (index <= text.length() && index >= 0){
                        System.out.println(text.charAt(index));
                    }
                    break;
                case 4:

                    if  (!previousVersions.isEmpty()){
                        text = new StringBuilder(previousVersions.pop());

                    }
                    break;
            }
        }
    }
}
