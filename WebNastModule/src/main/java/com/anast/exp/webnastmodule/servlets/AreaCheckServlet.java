package com.anast.exp.webnastmodule.servlets;
import com.anast.exp.webnastmodule.beans.ResultsBean;
import com.anast.exp.webnastmodule.models.Result;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@WebServlet("/area-check")
public class AreaCheckServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ResultsBean resultsBean = getResultsBean(req);


        if(req.getParameter("clear")!=null && req.getParameter("clear").equals("true")){
            clearResults(req);
        }else {
            String xParam = req.getParameter("x");
            String yParam = req.getParameter("y");
            String rParam = req.getParameter("r");

            if (xParam != null && yParam != null && rParam != null) {
                double x = Double.parseDouble(xParam);
                double y = Double.parseDouble(yParam);
                double r = Double.parseDouble(rParam);


                 //для проверки попала ли точка в область или нет

                 boolean isInArea = checkPointArea(x, y, r);

                 Result result = new Result();
                 result.setX(x);
                 result.setY(y);
                 result.setR(r);
                 result.setInArea(isInArea);


                 resultsBean.addResult(result);
             }
        }
        req.setAttribute("res", resultsBean);
        req.getRequestDispatcher("/index.jsp").forward(req, res);
    }

    private void clearResults(HttpServletRequest req){
        ResultsBean resultsBean = getResultsBean(req);
        resultsBean.clearResults();
    }

    private boolean checkPointArea(double x, double y, double r){
        if (x >= -r && x <= 0 && y >= -r && y <= 0 && x * x + y * y <= r * r / 4) {
            return true;
        } else if (x <= r && x >= 0 && y <= r && y >= 0 && x + y <= r) {
            return true;
        } else if (x >= 0 && x <= r && y <= 0 && y >= -r && x <= r / 2 && y >= -r) {
            return true;
        }
        return false;
    }

    private ResultsBean getResultsBean(HttpServletRequest req){
        //Получим бин-компонент из контекста приложения и вернем его
        ServletContext servletContext = req.getServletContext();
        ResultsBean resultsBean = (ResultsBean) servletContext.getAttribute("resultsBean");

        if(resultsBean == null){
            resultsBean = new ResultsBean();
            servletContext.setAttribute("resultsBean",resultsBean);
        }
        return  resultsBean;

    }
}
