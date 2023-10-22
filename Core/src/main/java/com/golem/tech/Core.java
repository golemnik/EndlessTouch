package com.golem.tech;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.ApplicationScoped;

@ManagedBean
@ApplicationScoped
public class Core {
    public Core () {
        System.out.println("Core here!");
    }

    public Page helloCore () {
        return new Page().builder()
                .openTag("html")
                .openTag("h1")
                .text("Core!")
                .closeTag("h1")
                .closeTag("html")
                .build();
    }
}
