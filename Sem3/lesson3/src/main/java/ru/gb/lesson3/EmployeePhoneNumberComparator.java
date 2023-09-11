package ru.gb.lesson3;

import java.util.Comparator;

public class EmployeePhoneNumberComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getPhoneNumber().compareTo(o2.getPhoneNumber());
    }
}
