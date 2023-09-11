package ru.gb.lesson3;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
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

    protected String phoneNumber;

    protected int id;

    public String getPhoneNumber() {
        return phoneNumber;
    }

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
    protected Employee(String name, String surName,  String phoneNumber) {
        this.name = name;
        this.surName = surName;
        if(phoneNumber.length() != 11){
            throw new RuntimeException("Номер телефона в России содержит 11 знаков!");
        }
        this.phoneNumber = phoneNumber;
    }

    protected Employee(String name, String surName, double salary) {
        this(name, surName);
        if (salary < 30_000) {
            throw new RuntimeException("Уровень ЗП должен быть не менее 30тыс.");
        }
        this.salary = salary;
    }

    public Employee(String name, String surName, double salary, String phoneNumber) {
        this(name,surName,salary);
        if(phoneNumber.length() != 11){
            throw new RuntimeException("Номер телефона в России содержит 11 знаков!");
        }
        this.phoneNumber = phoneNumber;
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
                + ", salary: " + this.salary
                + ", phone: " + this.phoneNumber;
    }

    @Override
    public int compareTo(Employee o) {
        return Double.compare(getSalary(), o.getSalary());
    }
}
