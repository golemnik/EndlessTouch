package com.anast.exp.webnastmodule.models;
import java.io.Serializable;

public class Result implements Serializable{
    private double x;
    private double y;
    private double r;
    private boolean isInArea;

    public Result(){

    }

    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public double getR(){
        return r;
    }
    public boolean isInArea(){
        return isInArea;
    }
    public void setX(double x){
        this.x = x;
    }
    public void setY(double y){
        this.y = y;
    }
    public void setR(double r){
        this.r = r;
    }
    public void setInArea(boolean isInArea){
        this.isInArea=isInArea;
    }

}