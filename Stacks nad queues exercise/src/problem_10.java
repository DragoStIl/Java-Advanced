import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class problem_10 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //ROB-15;SS2-10;NX8000-3
        //8:00:00
        //detail
        //glass
        //wood
        //apple
        //End
//        String[] inputWorkers = scan.nextLine().split(";");
//        Map<String, Integer> robots = new LinkedHashMap<>();
//
//        for (String worker : inputWorkers) {
//            String robotName = worker.split("-")[0];
//            int workingTime = Integer.parseInt(worker.split("-")[1]);
//            robots.put(robotName, workingTime);
//        }
//
//        String[] startingTime = scan.nextLine().split(":");
//        int timeInSeconds =
//                (Integer.parseInt(startingTime[0]) * 360)
//                + (Integer.parseInt(startingTime[1]) * 60)
//                + Integer.parseInt(startingTime[2]);


        int time = 28860;
        int min = time / 60;
        int hrs = time / 3600;
        min %= hrs;








        System.out.println();
    }
}
