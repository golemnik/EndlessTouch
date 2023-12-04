package com.golem.tech.stuff;

import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.List;

@Named
public class ResultTable {
    private List<Results> resultsList = new ArrayList<>();

    public void setResultsList(List<Results> resultsList) {
        this.resultsList = resultsList;
    }

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
                        .append("x:").append(result.getX())
                        .append(",y:").append(result.getY())
                        .append(",r:").append(result.getR())
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
                        .append("<td>").append(results.get(i).getX()).append("</td>")
                        .append("<td>").append(results.get(i).getY()).append("</td>")
                        .append("<td>").append(results.get(i).getR()).append("</td>")
                        .append("<td>").append(results.get(i).getHit()).append("</td>")
                        .append("<td>").append("</td>")
                        .append("<td>").append("</td>")
                        .append("</tr>\n");
            }
        }
        return dr.toString();
    }
}
