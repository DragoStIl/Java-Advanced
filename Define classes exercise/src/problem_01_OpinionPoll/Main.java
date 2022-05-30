package problem_01_OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        List<Person> people = new ArrayList<>();

        while (n-- > 0){
            String[] personData = scan.nextLine().split("\\s+");
            String name = personData[0];
            int age = Integer.parseInt(personData[1]);
            Person human = new Person(name, age);
            people.add(human);

        }

        people.stream()
                .filter(person -> person.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);
    }
}
