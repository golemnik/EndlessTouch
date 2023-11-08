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
}
