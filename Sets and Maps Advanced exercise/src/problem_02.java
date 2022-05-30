import java.util.*;

public class problem_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int[] setSizes = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int n = setSizes[0];
        Set<Integer> first = new LinkedHashSet<>();
        first = setFiller(first, n, scan);

        int m = setSizes[1];
        Set<Integer> second = new LinkedHashSet<>();
        second = setFiller(second, m, scan);

        Set<Integer> repeatable = new LinkedHashSet<>();
        for (Integer integer : first) {
            if (second.contains(integer)){
                repeatable.add(integer);
            }
        }

        repeatable.forEach(i -> System.out.print(i + " "));


    }

    private static Set<Integer> setFiller(Set<Integer> numbers, int range, Scanner scan) {
        while (range-- > 0){
            numbers.add(Integer.parseInt((scan.nextLine())));
        }
        return numbers;
    }
}
