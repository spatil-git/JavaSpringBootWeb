package com.sanjay.restfuldemo.restservice.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class EmployeeRestController {
    @Autowired
    EmployeeDataService service;

    @GetMapping(path = "/employees")
    public List<Employee> findAll() {
        return service.findAll();
    }

    @GetMapping(path = "/employees/{id}")
    public Employee findyID(@PathVariable int id) throws EmployeeNotFoundException {
        return service.findByID(id);
    }

    @PostMapping(path = "/employees")
    public ResponseEntity saveEmployee(@Valid @RequestBody Employee e) {
        Employee savedEmployee = service.save(e);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedEmployee.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
