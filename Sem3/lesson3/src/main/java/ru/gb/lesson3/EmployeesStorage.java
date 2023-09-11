package ru.gb.lesson3;

import java.util.Iterator;
import java.util.List;

public class EmployeesStorage implements Iterable<Employee> {
    private Employee[] employees;
    private final int size;

    public EmployeesStorage(Employee[] employees) {
        this.employees = employees;
        this.size = employees.length;
    }

    @Override
    public Iterator<Employee> iterator() {
        return new Iterator<Employee>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return (index < size && employees[index] != null);
            }

            @Override
            public Employee next() {
                if(!hasNext()){
                    throw new RuntimeException("Нет элемента!");
                }
                return employees[index++];
            }
        };
    }
}
