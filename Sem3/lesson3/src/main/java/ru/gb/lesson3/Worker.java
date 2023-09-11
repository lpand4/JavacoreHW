package ru.gb.lesson3;

import java.util.ArrayList;
import java.util.List;

public class Worker extends Employee {
    protected static StringBuilder sb = new StringBuilder();
    public Worker(String surName, String name, int salary) {
        super(surName, name, salary);
    }

    public Worker(String name, String surName, int salary, String phoneNumber ) {
        super(name, surName, salary, phoneNumber);
    }

    public static Employee getInstance() {
        sb.append(7).append(random.nextInt(900,999))
                .append(random.nextInt(100,999))
                .append(random.nextInt(1000,9999));
        String phoneNum = sb.toString();
        sb.setLength(0);
        return new Worker(
                names[random.nextInt(surNames.length)],
                surNames[random.nextInt(surNames.length)],
                random.nextInt(30000, 250000),
                phoneNum);

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
