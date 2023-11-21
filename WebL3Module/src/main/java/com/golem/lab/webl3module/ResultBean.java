package com.golem.lab.webl3module;

import com.golem.lab.webl3module.data.Dot;
import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ApplicationScoped
@Named
public class ResultBean {
    private Dot newDot = new Dot();
    private List<Dot> dots = new ArrayList<>();

    public void setDots(List<Dot> dots) {
        this.dots = dots;
    }

    public List<Dot> getDots() {
        return dots;
    }

    public void setNewDot(Dot newDot) {
        this.newDot = newDot;
    }

    public Dot getNewDot() {
        return newDot;
    }

    public void addDot () {
        dots.add(newDot);
        newDot = new Dot();
    }
}
