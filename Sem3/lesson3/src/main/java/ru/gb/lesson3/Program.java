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
        System.out.println("\n////////////////////////////////////////////////////////////\n");



        Employee[] someEmployees = {Worker.getInstance(), Freelancer.getInstance(), Worker.getInstance(),
                Worker.getInstance(), Freelancer.getInstance(),Freelancer.getInstance(),
                Freelancer.getInstance(),Freelancer.getInstance(),Worker.getInstance(),
                Worker.getInstance(), Freelancer.getInstance(),Freelancer.getInstance(),
                Freelancer.getInstance(), Worker.getInstance(), Freelancer.getInstance()};

        EmployeesStorage employeesStorage = new EmployeesStorage(someEmployees);
        for (Employee e : employeesStorage) {
            System.out.println(e);
        }

        System.out.println("\n////////////////////////////////////////////////////////////\n");
        for (Employee e: someEmployees) {
            System.out.println(e);
        }


    }
}
