package com.javaspring.soap.soapdemo.soap;

import com.javaspring.soap.soapdemo.soap.beans.Employee;
import com.javaspring.soap.soapdemo.soap.beans.EmployeeDetailsService;
import com.javaspringdemo.employees.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class EmployeeDetailsEndpoint {
    @Autowired
    EmployeeDetailsService employeeDetailsService;

    // Spring always communicates using XML. So the response object should also be the XML.
    @PayloadRoot(namespace = "http://javaspringdemo.com/employees", localPart = "GetEmployeeDetailsReq")
    // Response is XML.
    @ResponsePayload
    public GetEmployeeDetailsResponse getDetails(@RequestPayload GetEmployeeDetailsReq req) {
        GetEmployeeDetailsResponse resposne = new GetEmployeeDetailsResponse();
        Employee e = employeeDetailsService.findByID(req.getId().intValue());
        EmployeeDetails details = getDetails(e);
        resposne.setEmployeeDetails(details);
        return resposne;
    }

    EmployeeDetails getDetails(Employee e) {
        EmployeeDetails details = new EmployeeDetails();
        details.setFirstName(e.getFirstName());
        details.setLastName(e.getLastName());
        details.setId(e.getId());
        return details;
    }

    @PayloadRoot(namespace = "http://javaspringdemo.com/employees", localPart = "GetAllEmployeeDetailsReq")
    // Response is XML.
    @ResponsePayload
    public GetAllEmployeeDetailsResponse getDetails(@RequestPayload GetAllEmployeeDetailsReq req) {
        GetAllEmployeeDetailsResponse resposne = new GetAllEmployeeDetailsResponse();
        List<Employee> es = employeeDetailsService.getAll();
        for(Employee e:es) {
            EmployeeDetails details = getDetails(e);
            resposne.getEmployeeDetails().add(details);
        }
        return resposne;
    }
}
