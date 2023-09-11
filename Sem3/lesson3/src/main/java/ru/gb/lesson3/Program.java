package ru.gb.lesson3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Program {
    public static void main(String[] args) {
//        Employee employee1 = new Employee();
//        Employee employee2 = new Employee();
//        System.out.println(employee1);
//        System.out.println(employee2);

//        Employee emp1 = Worker.getInstance();
//        Employee emp2 = Worker.getInstance();
//        Employee emp3 = Freelancer.getInstance();
//        Employee emp4 = Freelancer.getInstance();
//        System.out.println(emp1);
//        System.out.println(emp2);
//        System.out.println(emp3);
//        System.out.println(emp4);
        List<Employee> employees = Worker.getEmployees(5);
        employees.add(Freelancer.getInstance());
        employees.add(Freelancer.getInstance());
        employees.add(Freelancer.getInstance());
        for (Employee e:employees) {
            System.out.println(e);
        }
        Collections.sort(employees, new EmployeePhoneNumberComparator());
        System.out.println();
        for (Employee e:employees) {
            System.out.println(e);
        }

    }
}
