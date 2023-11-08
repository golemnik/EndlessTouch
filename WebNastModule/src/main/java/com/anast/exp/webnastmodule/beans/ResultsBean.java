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
}
