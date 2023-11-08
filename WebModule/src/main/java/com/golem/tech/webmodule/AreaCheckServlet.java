package com.golem.tech.webmodule;

import com.golem.tech.stuff.ResultTable;
import com.golem.tech.stuff.Results;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/AreaCheck")
public class AreaCheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        ResultTable table;
        boolean reset = Boolean.parseBoolean(request.getParameter("reset"));
        if (!reset) {
            double x = Double.parseDouble(request.getParameter("x"));
            double y = Double.parseDouble(request.getParameter("y"));
            double r = Double.parseDouble(request.getParameter("r"));
            boolean hit = checkArea(x, y, r);
            Results results = new Results(x, y, r, hit);
            table = loadTable();
            table.addResults(results);
        }
        else {
            table = new ResultTable();
            getServletContext().setAttribute("table", table);
        }
        request.setAttribute("table", table);
        request.getRequestDispatcher("/").forward(request, response);
    }

    boolean checkArea (double x, double y, double r) {
        return x>=0 ? y>=0
                        ? x*x + y*y <= r*r
                        : (x - r)/2 <= y && x <=r && y > -r
                    : y >= 0 && x >= -r && y <= r;
    }

    private ResultTable loadTable () {
        Object o = getServletContext().getAttribute("table");
        if (o instanceof ResultTable) {
            return (ResultTable) o;
        }
        else {
            ResultTable table = new ResultTable();
            getServletContext().setAttribute("table", table);
            return table;
        }
    }

}
