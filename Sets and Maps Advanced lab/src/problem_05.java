import java.util.*;

public class problem_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int inputCounter = Integer.parseInt(scan.nextLine());
        Map<String, List<Double>> students = new TreeMap<>();

        for (int i = 0; i < inputCounter; i++) {
            String[] newGrade = scan.nextLine().split("\\s+");
            String currentStudent = newGrade[0];
            double grade = Double.parseDouble(newGrade[1]);

            students.putIfAbsent(currentStudent, new ArrayList<>());
            List<Double> current = students.get(currentStudent);
            current.add(grade);




        }
        students.entrySet().stream().forEach(e -> {
            System.out.print(e.getKey() + " -> ");
            double averageGrade = 0;
            List<Double> grades = e.getValue();
            for (Double currentGrade : grades) {
                averageGrade += currentGrade;
                System.out.printf("%.2f ",currentGrade);
            }
            System.out.printf("(avg: %.2f)%n", averageGrade / grades.size());
        });
    }
}
