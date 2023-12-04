package com.golem.tech.stuff;

import jakarta.inject.Named;

@Named
public class Results {

    private double x;
    private double y;
    private double r;
    private boolean hit;

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setR(double r) {
        this.r = r;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }

    public boolean getHit () {
        return hit;
    }
}