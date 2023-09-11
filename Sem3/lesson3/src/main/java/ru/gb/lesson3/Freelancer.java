package ru.gb.lesson3;

import java.util.ArrayList;
import java.util.List;

public class Freelancer extends Employee {

    private double salaryPerHour;

    public Freelancer(String name, String surName, int salaryPerHour) {
        super(name, surName);
        this.salaryPerHour = salaryPerHour;
        setSalary(calculateSalary(salaryPerHour));
    }

    @Override
    public double calculateSalary(int salaryPerHour) {
        return Math.round((20.8 * 8 * salaryPerHour) * 100.0) / 100.0;
    }

    public static Employee getInstance() {
        return new Freelancer(
                names[random.nextInt(surNames.length)],
                surNames[random.nextInt(surNames.length)],
                random.nextInt(190, 1400));
    }

    public static List<Employee> getEmployees(int count) {
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < count; i++)
            employees.add(getInstance());
        return employees;
    }
}
