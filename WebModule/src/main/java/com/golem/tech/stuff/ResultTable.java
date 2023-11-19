package com.golem.tech.stuff;

import java.util.ArrayList;
import java.util.List;

public class ResultTable {
    private final List<Results> resultsList = new ArrayList<>();
    public void addResults (Results results) {
        resultsList.add(results);
    }
    public List<Results> getResults() {
        return resultsList;
    }

    public static String jsGraph(List<Results> results) {
        StringBuilder dr = new StringBuilder("[");
        if (!results.isEmpty()) {
            for (Results result : results) {
                dr.append("{")
                        .append("x:").append(result.x())
                        .append(",y:").append(result.y())
                        .append(",r:").append(result.r())
                        .append("},");
            }
        }
        dr.append("]");
        return dr.toString();
    }

    public static String htmlTable (List<Results> results) {
        StringBuilder dr = new StringBuilder();
        if (!results.isEmpty()) {
            for (int i = 0; i < results.size(); i++) {
                dr.append("<tr class=\"hover\">")
                        .append("<td>").append(results.get(i).x()).append("</td>")
                        .append("<td>").append(results.get(i).y()).append("</td>")
                        .append("<td>").append(results.get(i).r()).append("</td>")
                        .append("<td>").append(results.get(i).hit()).append("</td>")
                        .append("<td>").append("</td>")
                        .append("<td>").append("</td>")
                        .append("</tr>\n");
            }
        }
        return dr.toString();
    }
}
