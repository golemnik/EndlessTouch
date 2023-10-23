package com.golem.tech.webmodule;

import java.io.*;

import com.golem.tech.Core;
import com.golem.tech.ForwardContainer;
import com.golem.tech.Page;
import com.golem.tech.RequestContainer;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "InitServlet", value = "/Init")
public class ControllerServlet extends HttpServlet {
    @Inject private Core core;

    private String message;

    @Override
    public void init() {
        message = "Hello World!";
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        Page page = core.helloCore();
//        out.println(page.getPage());

        ServletContext servletContext = getServletContext();
        core.execute(new ForwardContainer(servletContext, new RequestContainer(request, response)));

    }

    @Override
    public void destroy() {
    }
}