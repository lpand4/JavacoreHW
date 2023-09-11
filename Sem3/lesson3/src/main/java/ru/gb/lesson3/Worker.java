package ru.gb.lesson3;

import java.util.ArrayList;
import java.util.List;

public class Worker extends Employee {
    public Worker(String surName, String name, int salary) {
        super(surName, name, salary);
    }
    public static Employee getInstance() {
        return new Worker(
                names[random.nextInt(surNames.length)],
                surNames[random.nextInt(surNames.length)],
                random.nextInt(30000, 250000));
    }

    public static List<Employee> getEmployees(int count){
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < count; i++)
            employees.add(getInstance());
        return employees;
    }
    @Override
    public double calculateSalary(int salaryPerHour) {
        return salary;
    }
}
