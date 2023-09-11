package ru.gb.lesson3;

import java.util.Collection;
import java.util.Random;

public abstract class Employee implements Comparable<Employee>{

    protected static String[] names = new String[]{"Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий", "Рубен", "Герман"};
    protected static String[] surNames = new String[]{"Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов", "Горбунов", "Лыткин", "Соколов"};
    protected static Random random = new Random();


    protected static int counter = 1000;
    /**
     * Имя
     */
    protected String name;

    /**
     * Фамилия
     */
    protected String surName;

    /**
     * Ставка заработной платы
     */
    protected double salary;

    protected int id;

    protected String getName() {
        return name;
    }

    protected String getSurName() {
        return surName;
    }

    protected double getSalary() {
        return salary;
    }

    protected void setSalary(double salary) {
        if (salary < 30_000) {
            throw new RuntimeException("Уровень ЗП должен быть не менее 30тыс.");
        }
        this.salary = salary;
    }

    protected int getId() {
        return id;
    }

    {
        this.id = ++counter;
    }

    protected Employee(String name, String surName) {
        this.name = name;
        this.surName = surName;
    }

    protected Employee(String name, String surName, double salary) {
        this(name, surName);
        if (salary < 30_000) {
            throw new RuntimeException("Уровень ЗП должен быть не менее 30тыс.");
        }
        this.salary = salary;
    }

    protected Employee() {
        this.name = "Name";
        this.surName = "Surname";
        this.salary = 30_000;
    }

    /**
     * Рассчет среднемесячной зарплаты
     *
     * @return
     */
    public abstract double calculateSalary(int salaryPerHour);

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " ID_" + this.id
                + " Name: " + this.name
                + ", Surname: " + this.surName
                + ", salary: " + this.salary;
    }
    @Override
    public int compareTo(Employee o) {
        return Double.compare(getSalary(), o.getSalary());
    }
}
