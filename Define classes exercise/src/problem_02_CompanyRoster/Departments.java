package problem_02_CompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class Departments {
   private List<Employee> employees;
   private String name;

    public List<Employee> getEmployees() {
        return employees;
    }

    public Departments(String name) {
        this.name = name;
        employees = new ArrayList<>();

    }

    public String getName() {
        return name;
    }

    public double calculateAverageSalary (){
        return this.employees.stream().mapToDouble(Employee::getSalary).average().orElse(0.0);
    }
}
