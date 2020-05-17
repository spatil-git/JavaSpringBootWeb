package com.sanjay.restfuldemo.restservice.employee;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

// This is the bean which we would autowire later in the RestController.
@Component
public class EmployeeDataService {
    private static List<Employee> employees = new ArrayList<>();

    static {
        employees.add(new Employee(0, "One", "One"));
        employees.add(new Employee(1, "Two", "Two"));
        employees.add(new Employee(2, "Three", "Three"));
    }
    public List<Employee> findAll() {
        return employees;
    }

    public Employee findByID(int id) throws EmployeeNotFoundException {
        for (Employee e: employees) {
            if(e.id == id) {
                return e;
            }
        }
        throw new EmployeeNotFoundException("id = " + id);
    }

    public Employee save(Employee e) {
        if(e.id <= 0) {
            e.setId(employees.size());
        }
        employees.add(e);
        return e;
    }
}
