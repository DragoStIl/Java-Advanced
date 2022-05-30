import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class problem_09 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int plants = Integer.parseInt(scan.nextLine());
        List<Long> seeds = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Long::parseLong).collect(Collectors.toList());
        int clearingCounter = 0; // counting the days until all GMO seeds are gone; e1 > e2 > e3.....

        while (true){

//            6
//            7 8 8 8 9 7

            for (int i = 0; i < seeds.size() - 1; i++) {
                long first = seeds.get(i);
                long second = seeds.get(i + 1);
                if (first < second){
                    seeds = badSeedRemoval(seeds);
                    clearingCounter++;
                    i--;

                }
            }
            if (clearingCounter > 0){
                System.out.println(clearingCounter);

            } else  {
                System.out.println("1");
                System.out.println(String.join(" ", seeds.toString()));
            }
                return;
        }
    }

    private static List<Long> badSeedRemoval(List<Long> seeds) {
        ArrayDeque<Long> goodSeeds = new ArrayDeque<>();
        goodSeeds.offer(seeds.get(0));
        for (int i = 0; i < seeds.size() - 1; i++) {
            if (seeds.get(i + 1) <= seeds.get(i)){
                goodSeeds.offer(seeds.get(i + 1));
            }
        }
        seeds = new ArrayList<>(goodSeeds);
        return seeds;
    }
}