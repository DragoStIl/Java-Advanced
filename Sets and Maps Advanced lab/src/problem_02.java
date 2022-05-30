import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class problem_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        Set<String> partyMembers = new TreeSet<>();
        while (!input.equals("PARTY")){
            partyMembers.add(input);
            input = scan.nextLine();
        }
        input = scan.nextLine();
        while (!input.equals("END")){
            partyMembers.remove(input);
            input = scan.nextLine();
        }
        System.out.println(partyMembers.size());
        for (String member : partyMembers) {
            System.out.println(member);
        }


    }
}
