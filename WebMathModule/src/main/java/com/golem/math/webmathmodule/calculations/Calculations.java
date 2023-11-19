package com.golem.math.webmathmodule.calculations;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Calculations {
    private final List<Double> series;
    public Calculations (List<Double> series) {
        this.series = series;
    }
    public Calculations () {
        InputStream inputStream = getClass()
                .getClassLoader()
                .getResourceAsStream("/data.txt");
        assert inputStream != null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        List<Double> doubList = new ArrayList<>();
        reader.lines().forEach(x -> doubList.add(Double.parseDouble(x)));
        this.series = doubList;
    }

    public List<Double> variationSeries () {
        Collections.sort(series);
        return series;
    }
    public List<Double> getSeries() {
        return series;
    }

    public Double extremeMin () {
        return series.get(0);
    }
    public Double extremeMax () {
        return series.get(series.size()-1);
    }
    public Double scope () {
        return extremeMax() - extremeMin();
    }

    public Double mathExpectation () {
        double expec = 0D;
        for (Double ser : series) {
            expec += ser/series.size();
        }
        return expec;
    }

    public Double standardDeviation () {
        double deviation = 0D;
        for (Double ser : series) {
            deviation += Math.pow((ser - mathExpectation()), 2);
        }
        deviation = Math.sqrt(deviation/(series.size()-1));
        return deviation;
    }

    public List<Double> frequencies () {
        List<Double> freq = new ArrayList<>();
        double curFreq = 1;
        int pos = 0;
        for (int i = 0; i < series.size(); i++) {
            if (i < series.size()-1 && series.get(i).equals(series.get(i+1))) {
                curFreq++;
            }
            else {
                for (int j = 0; j < curFreq; j++) {
                    freq.add(pos, curFreq/series.size());
                }
                pos = i;
                curFreq = 1;
            }
        }

        return freq;
    }

    public Double firstStep () {
        return extremeMin() - intervalStep()/2;
    }
    public Double intervalStep () {
        return ( extremeMax() - extremeMin() ) / (1 + 3.322 * Math.log(series.size()) );
    }

}
