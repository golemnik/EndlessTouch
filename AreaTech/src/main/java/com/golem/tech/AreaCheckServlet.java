package com.golem.tech;

import com.golem.tech.signatures.Page;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/AreaCheck")
public class AreaCheckServlet extends HttpServlet {
    public static final String path = "/AreaCheck";
    @Override
    public void init() throws ServletException {
        super.init();
    }

    private Page initPage () {
        return new Page().builder()
                .openTag("html")
                .openTag("h1")
                .text("AreaCheckServlet!")
                .closeTag("h1")
                .closeTag("html")
                .build();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        Page page = initPage();
        out.println(page.getPage());
    }
}
