package com.sanjay.restfuldemo.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldEndpoint {
    @GetMapping(path = "/hello-world")
    public String sayHello() {
        return "Hello World!!";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean sayHelloBean() {
        return new HelloWorldBean("Hello World");
    }

    @GetMapping(path = "/hello-world/path-variable/{name}")
    public String sayHelloParam(@PathVariable String name) {
        return "Hello World!!" + name;
    }
}
