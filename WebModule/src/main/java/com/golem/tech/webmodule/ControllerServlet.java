package com.golem.tech.webmodule;

import java.io.*;

import com.golem.tech.containers.ForwardContainer;
import com.golem.tech.containers.RequestContainer;
import com.golem.tech.core.Core;
import com.golem.tech.signatures.DisdataSignature;
import jakarta.inject.Inject;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/Init")
public class ControllerServlet extends HttpServlet {
    @Inject private Core core;

    @Override
    public void init() {
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        Page page = core.helloCore();
//        out.println(page.getPage());
        ServletContext servletContext = getServletContext();
        core.execute(new ForwardContainer(servletContext,
                new RequestContainer(request, response, new DisdataSignature()),
                new DisdataSignature()));
    }

    @Override
    public void destroy() {
    }
}