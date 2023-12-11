package com.golem.math.webmathmodule;

import com.golem.math.webmathmodule.calculations.Calculations;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jfree.chart.*;
import org.jfree.chart.axis.Axis;
import org.jfree.chart.plot.CategoryMarker;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.ui.Layer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.Dataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;
import java.io.*;
import java.util.List;

@WebServlet(name = "graph", value = "/graph")
public class Graph extends HttpServlet {
    private final Calculations calc = new Calculations();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("image/png");
            OutputStream out = response.getOutputStream();
            int param = Integer.parseInt(request.getParameter("type"));
            switch (param) {
                case 1 -> ChartUtils.writeChartAsPNG(out, empiricGraphic(), 800, 600);
                case 2 -> ChartUtils.writeChartAsPNG(out, barSequenceGraphic(), 800, 600);
                case 3 -> ChartUtils.writeChartAsPNG(out, s_sequencePolygonGraphic(), 800, 600);
                case 4 -> ChartUtils.writeChartAsPNG(out, sequencePolygonGraphic(), 800, 600);
                default -> {}
            }
//            ChartUtils.writeChartAsPNG(out, empiricGraphic(calc), 600, 400);
//            ChartUtils.writeChartAsPNG(out, sequenceGraphic(calc), 600, 400);

            out.flush();
        }
        catch (Exception e) {
            // do nothing
        }
    }

    public JFreeChart empiricGraphic () {
        JFreeChart chart;
        XYSeries xyseries = new XYSeries("frequencies");
        List<Double> values = calc.frequenciesSeriesEmperic();
        int size = values.size();
        Double t=0D;
        xyseries.add(0, 0);
        for (int i = 0; i < size; i++) {
            if (i < size-1 && calc.variationSeries().get(i).equals(calc.variationSeries().get(i+1))) {
                continue;
            }
            xyseries.add(t, values.get(i));
            t += calc.intervalStep();
            xyseries.add(t, values.get(i));
        }
        XYSeriesCollection xydataset = new XYSeriesCollection(xyseries);
        chart = ChartFactory.createXYLineChart(
                "Эмпирическая функция распределения",
                "x",
                "F(x)",
                xydataset,
                PlotOrientation.VERTICAL,
                false,
                true,
                false);

        chart.setBackgroundPaint(ChartColor.white);
        final XYPlot plot = chart.getXYPlot( );

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
        renderer.setSeriesPaint( 0 , Color.BLUE );
        renderer.setSeriesStroke( 0 , new BasicStroke( 1.0f ) );
        plot.setRenderer( renderer );

        return chart;
    }

    public JFreeChart barSequenceGraphic () {
        JFreeChart chart;

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        int size = calc.variationSeries().size();
        for (int i = 0; i < size; i++) {
            if (i < size-1 && calc.variationSeries().get(i).equals(calc.variationSeries().get(i+1))) {
                continue;
            }
            dataset.addValue(calc.frequencies().get(i)/calc.intervalStep(),
                    calc.frequencies().get(i)/calc.intervalStep() + "",
                    calc.variationSeries().get(i).toString() + "");
        }

        chart = ChartFactory.createBarChart(
                "Гистограмма частот",
                "x",
                "p*/h",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                false,
                false);


        return chart;
    }

    public JFreeChart sequencePolygonGraphic () {
        JFreeChart chart;
        XYSeries xyseries = new XYSeries("frequencies");
        int size = calc.variationSeries().size();
        for (int i = 0; i < size; i++) {
            if (i < size-1 && calc.variationSeries().get(i).equals(calc.variationSeries().get(i+1))) {
                continue;
            }
            xyseries.add(calc.variationSeries().get(i), calc.frequencies().get(i));
        }
        XYSeriesCollection xydataset = new XYSeriesCollection(xyseries);
        chart = ChartFactory.createXYLineChart(
                "Полигон частостей",
                "x",
                "p*",
                xydataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false);

        chart.setBackgroundPaint(ChartColor.white);
        final XYPlot plot = chart.getXYPlot( );

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
        renderer.setSeriesPaint( 0 , Color.BLUE );
        renderer.setSeriesStroke( 0 , new BasicStroke( 1.0f ) );
        plot.setRenderer( renderer );

        return chart;
    }

    public JFreeChart s_sequencePolygonGraphic () {
        JFreeChart chart;
        XYSeries xyseries = new XYSeries("frequencies");
        int size = calc.variationSeries().size();
        Double t;
        for (int i = 0; i < size; i++) {
            if (i < size-1 && calc.variationSeries().get(i).equals(calc.variationSeries().get(i+1))) {
                continue;
            }
            t = calc.frequencies().get(i)*size;
            xyseries.add(calc.variationSeries().get(i), t);
        }
        XYSeriesCollection xydataset = new XYSeriesCollection(xyseries);
        chart = ChartFactory.createXYLineChart(
                "Полигон частот",
                "x",
                "n_i",
                xydataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false);

        chart.setBackgroundPaint(ChartColor.white);
        final XYPlot plot = chart.getXYPlot( );

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
        renderer.setSeriesPaint( 0 , Color.BLUE );
        renderer.setSeriesStroke( 0 , new BasicStroke( 1.0f ) );
        plot.setRenderer( renderer );

        return chart;
    }
}
