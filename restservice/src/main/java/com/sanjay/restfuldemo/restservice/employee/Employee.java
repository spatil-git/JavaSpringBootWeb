package com.sanjay.restfuldemo.restservice.employee;
import javax.validation.constraints.Size;

public class Employee {
    int id;
    @Size(min = 2, message = "First Name should be 2 or more characters long.")
    private String firstName;
    @Size(min = 2, message = "First Name should be 2 or more characters long.")
    private String lastName;

    public Employee(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
