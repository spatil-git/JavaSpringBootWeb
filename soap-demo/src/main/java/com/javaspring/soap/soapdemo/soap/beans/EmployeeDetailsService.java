package com.javaspring.soap.soapdemo.soap.beans;

import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeDetailsService {
    private static List<Employee> employees = new ArrayList<>();
    static {
        Employee e1 = new Employee(BigInteger.valueOf(1), "One", "One");
        employees.add(e1);
        Employee e2 = new Employee(BigInteger.valueOf(2), "Two", "Two");
        employees.add(e2);
        Employee e3 = new Employee(BigInteger.valueOf(3), "Three", "Three");
        employees.add(e3);
        Employee e4 = new Employee(BigInteger.valueOf(4), "Four", "Four");
        employees.add(e4);
        Employee e5 = new Employee(BigInteger.valueOf(5), "Five", "Five");
        employees.add(e5);
    }

    public Employee findByID(int id) {
        for (Employee e : employees) {
            if (e.id == BigInteger.valueOf(id)) {
                return e;
            }
        }
        return null;
    }

    public List<Employee> getAll() {
        return employees;
    }

    public void deleteByID(int id) {
        if(employees.size() >= id) {
            employees.remove(id);
        }
    }
}
