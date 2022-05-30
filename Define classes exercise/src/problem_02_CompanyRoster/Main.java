package problem_02_CompanyRoster;

import java.util.Comparator;
import java.util.HashMap;

import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentMap;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int n = Integer.parseInt(scan.nextLine());
        Map<String, Departments> departments = new HashMap<>();

        while (n-- > 0){
            String[] inputData = scan.nextLine().split("\\s+");
            //Peter 120.00 Dev Development peter@abv.bg 28
            String name = inputData[0];
            double salary = Double.parseDouble(inputData[1]);
            String position = inputData[2];
            String department = inputData[3];
            Employee currentEmployee = null;

            if (inputData.length == 4){
                currentEmployee = new Employee(name, salary, position, department);
            } else if (inputData.length == 6){
                String email = inputData[4];
                int age = Integer.parseInt(inputData[5]);
                currentEmployee = new Employee(name, salary, position, department, email, age);


            } else if (inputData.length == 5){
                try {
                    int age = Integer.parseInt(inputData[4]);
                    currentEmployee = new Employee(name, salary, position, department, age);

                } catch (NumberFormatException e){
                    String email = inputData[4];
                    currentEmployee = new Employee(name, salary, position, department, email);
                }
            }
            departments.putIfAbsent(department, new Departments(department));
            departments.get(department).getEmployees().add(currentEmployee);
        }

        Departments highestAverageSalary = departments.entrySet().stream()
                .max(Comparator.comparing(e -> e.getValue().calculateAverageSalary())).get().getValue();


        System.out.println("Highest Average Salary: " + highestAverageSalary.getName());
        highestAverageSalary.getEmployees()
                .stream().sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(System.out::println);

    }
}
