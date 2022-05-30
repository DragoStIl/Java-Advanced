import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

public class problem_08 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int n = Integer.parseInt(scan.nextLine());

    Map<String, List<Double>> students = new TreeMap<>();

        while (n-- > 0){
            String name = scan.nextLine();
            students.putIfAbsent(name, new ArrayList<>());
            double[] grades = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble).toArray();

            List<Double> currentGrades = students.get(name);

            for (double grade : grades) {
                currentGrades.add(grade);
            }
        }


        students.entrySet()
                .forEach(s -> {
                    BigDecimal average1 = new BigDecimal(0);
                    double average = 0;
                    List<Double> current = s.getValue();
                    for (Double grade : current) {
                        average += grade;
                    }
                    DecimalFormat df = new DecimalFormat("####.###############");
//                    average1 = df.format(BigDecimal.valueOf(average).divide(BigDecimal.valueOf(current.size())));
                    System.out.printf("%s is graduated with %s%n", s.getKey(), average / current.size());
                });
    }
}
