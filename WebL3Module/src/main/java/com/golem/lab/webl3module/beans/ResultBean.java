package com.golem.lab.webl3module.beans;

import com.golem.lab.webl3module.data.Dot;
import com.golem.lab.webl3module.hiber.DotManager;
import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ApplicationScoped
@Named
public class ResultBean {
    private DotManager manager = new DotManager();
    private Dot newDot = new Dot();
    private List<Dot> dots = new ArrayList<>();

    public void setDots(List<Dot> dots) {
        this.dots = dots;
    }

    public List<Dot> getDots() {
//        return dots;
        return manager.getDots();
    }

    public void setNewDot(Dot newDot) {
        this.newDot = newDot;
    }

    public Dot getNewDot() {
        return newDot;
    }

    public void addDot () {
        manager.addDot(newDot);
//        dots.add(newDot);
        newDot = new Dot();
    }

    public void clear () {
        dots = new ArrayList<>();
    }

    public String getJsArray() {
        List<Dot> dots = getDots();
        if (dots == null) {
            return "[]";
        }
        StringBuilder dr = new StringBuilder("[");
        for (Dot dot : dots) {
            dr.append("{")
                    .append("x:").append(dot.getX())
                    .append(",y:").append(dot.getY())
                    .append(",r:").append(dot.getR())
                    .append("},");
        }
        dr.append("]");
        return dr.toString();
    }
}
