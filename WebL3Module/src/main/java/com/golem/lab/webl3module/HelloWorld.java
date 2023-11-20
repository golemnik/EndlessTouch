package com.golem.lab.webl3module;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named()
@ManagedBean
public class HelloWorld {
    public HelloWorld() {
        System.out.println("HelloWorld started!");
    }

//    public String getMessage() {
//        return "Hello World!";
//    }

    private String message = "Mighty apps from little java beans grow";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
