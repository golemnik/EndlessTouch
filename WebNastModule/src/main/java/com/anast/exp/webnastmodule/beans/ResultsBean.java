package com.anast.exp.webnastmodule.beans;

import com.anast.exp.webnastmodule.models.Result;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ResultsBean implements Serializable {
    private final List<Result> results = new ArrayList<>();
    public  List<Result> getResults(){
        return results;
    }
    public void addResult(Result result){
        results.add(result);
    }

    public void clearResults(){
        results.clear();
    }

    public static String jsArray (ResultsBean resultBean) {
        List<Result> results = resultBean.getResults();
        StringBuilder dr = new StringBuilder("[");
        if (!results.isEmpty()) {
            for (Result result : results) {
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
}
