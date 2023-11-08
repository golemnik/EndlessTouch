package com.golem.tech.other;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/area-check")
public class AreaCheckServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        res.setContentType("text/html");

        double x = Double.parseDouble(req.getParameter("x"));
        double y = Double.parseDouble(req.getParameter("y"));
        double r = Double.parseDouble(req.getParameter("r"));

        //для проверки попала ли точка в область или нет
        boolean isInArea = checkPointArea(x,y,r);

        Result result = new Result();
        result.setX(x);
        result.setY(y);
        result.setR(r);
        result.setInArea(isInArea);

        ResultsBean resultsBean = getResultsBean(req);
        resultsBean.addResult(result);

//        //логика для HTML
//        res.setContentType("text/html");
//        PrintWriter out = res.getWriter();
//
//        //Выведем заголовок страницы
//        out.println("<html>");
//        out.println("<head>");
//        out.println("<title>Результаты проверки точки</title>");
//        out.println("</head>");
//        out.println("<body>");
//
//        //Выведем результаты проверки
//        out.println("<h1>Результаты проверки точки</h1>");
//        out.println("<p>Координата x: "+ x + "</p>");
//        out.println("<p>Координата y: "+ y + "</p>");
//        out.println("<p>Координата r: "+ r + "</p>");
//        out.println("<p>Точка " + (isInArea ? "попадает" : "не попадает") + "в область.</p>" );
//
//        //Выводим список предыдущих результатов
//        List<Result> previousResults = resultsBean.getResults();
//        out.println("<h2>Предыдущие результаты проверок:</h2>");
//        out.println("<ul>");
//        for (Result previousResult : previousResults){
//            out.println("<li>Координата x: " + previousResult.getX() + ", Координата y: " + previousResult.getY() + ", Радиус: " + previousResult.getR() + ", Результат: " + (previousResult.isInArea() ? "попадает" : "не попадает") + " в область.</li>");
//        }
//        out.println("</ul>");
//        out.println("</body>");
//        out.println("</html>");

        req.setAttribute("res", resultsBean);
        req.getRequestDispatcher("/index.jsp").forward(req, res);

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
