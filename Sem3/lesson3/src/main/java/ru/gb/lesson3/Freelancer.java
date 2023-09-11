package ru.gb.lesson3;

import java.util.ArrayList;
import java.util.List;

public class Freelancer extends Employee {

    private double salaryPerHour;
    protected static StringBuilder sb = new StringBuilder();

    public Freelancer(String name, String surName, int salaryPerHour) {
        super(name, surName);
        this.salaryPerHour = salaryPerHour;
        setSalary(calculateSalary(salaryPerHour));
    }
    public Freelancer(String name, String surName, int salaryPerHour, String phoneNumber) {
        super(name, surName, phoneNumber);
        this.salaryPerHour = salaryPerHour;
        setSalary(calculateSalary(salaryPerHour));
    }


    @Override
    public double calculateSalary(int salaryPerHour) {
        return Math.round((20.8 * 8 * salaryPerHour) * 100.0) / 100.0;
    }

    public static Employee getInstance() {
        sb.append(7).append(random.nextInt(900,999))
                .append(random.nextInt(100,999))
                .append(random.nextInt(1000,9999));
        String phoneNum = sb.toString();
        sb.setLength(0);
        return new Freelancer(
                names[random.nextInt(surNames.length)],
                surNames[random.nextInt(surNames.length)],
                random.nextInt(190, 1400),
                phoneNum);
    }

    public static List<Employee> getEmployees(int count) {
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < count; i++)
            employees.add(getInstance());
        return employees;
    }
}
