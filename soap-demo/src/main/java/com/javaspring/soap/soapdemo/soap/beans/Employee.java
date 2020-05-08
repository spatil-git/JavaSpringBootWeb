package com.javaspring.soap.soapdemo.soap.beans;

import java.math.BigInteger;

public class Employee {
    BigInteger id;
    String firstName;
    String lastName;

    public Employee(BigInteger id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public BigInteger getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
