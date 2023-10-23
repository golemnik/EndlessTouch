package com.golem.tech;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import java.io.IOException;

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

    public void execute (ForwardContainer container) throws ServletException, IOException {
        RequestDispatcher dispatcher = container.servletContext().getRequestDispatcher(AreaCheckServlet.path);
        dispatcher.forward(container.requestContainer().req(), container.requestContainer().resp());
    }

}
