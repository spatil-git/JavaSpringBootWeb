package com.spring.web.demo.springdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class EmployeeController {
    @GetMapping("/employees")
    public List<Employee> employeeList() {
        return Arrays.asList(new Employee(237, "Sanjay", "Patil"));
    }
}
