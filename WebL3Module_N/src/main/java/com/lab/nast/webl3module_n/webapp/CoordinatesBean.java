package com.lab.nast.webl3module_n.webapp;

import com.lab.nast.webl3module_n.db.DatabaseHelper;
import jakarta.annotation.PostConstruct;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.servlet.http.Cookie;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Named
@ViewScoped
public class CoordinatesBean implements Serializable {
    private double x;
    private double y;
    private double r;
    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    public double getR() {
        return r;
    }
    public void setR(double r) {
        this.r = r;
    }

    public void processResults() {
        PreviousResult result = new PreviousResult();
        result.setX(x);
        result.setY(y);
        result.setR(r);
        result.setResult(checkHit(x, y, r));

        DatabaseHelper.get().addResult(getCurrentUuid(), result);
    }

    public List<PreviousResult> PreviousResults(){
        return DatabaseHelper.get().getAllResults(getCurrentUuid());
    }

    public void clearResults() {
        DatabaseHelper.get().removeAllResults(getCurrentUuid());
    }

    private boolean checkHit (double x, double y, double r) {
        boolean hit = false;
        return hit;
    }

    public String getJsArray() {
        List<PreviousResult> previousResults = DatabaseHelper.get().getAllResults(getCurrentUuid());
        if (previousResults == null) {
            return "[]";
        }
        StringBuilder dr = new StringBuilder("[");
        for (PreviousResult result : previousResults  ) {
            dr.append("{")
                    .append("x:").append(result.getX())
                    .append(",y:").append(result.getY())
                    .append(",r:").append(result.getR())
                    .append("},");
        }
        if (!previousResults.isEmpty()) {
            dr.deleteCharAt(dr.length() - 1);
        }
        dr.append("]");
        return dr.toString();
    }

    private String getCurrentUuid() {
        var context = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> cookies = context.getRequestCookieMap();
        Cookie cookie = (Cookie) cookies.get("uuid");
        if(cookie == null) {
            cookie = new Cookie("uuid", UUID.randomUUID().toString());
            Map<String, Object> properties = new HashMap<>();
            properties.put("maxAge", 31536000);
            properties.put("path", "/");
            context.addResponseCookie("uuid", cookie.getValue(), properties);
        }
        return cookie.getValue();
    }


    private boolean x1, x2, x3, x4, x5, x6, x7, x8, x9 = false;

    public void setX1(boolean x1) {
        this.x1 = x1 ;
        if (x1) this.x =-4;
    }
    public boolean getX1 () {
        return x1;
    }
    public void setX2(boolean x2) {
        this.x2 = x2;
        if (x2) this.x = -3;
    }
    public boolean getX2 () {
        return x2;
    }
    public void setX3(boolean x3) {
        this.x3 = x3;
        if (x3) this.x = -2;
    }
    public boolean getX3 () {
        return x3;
    }
    public void setX4(boolean x4) {
        this.x4 = x4;
        if(x4) this.x = -1;
    }
    public boolean getX4 () {
        return x4;
    }
    public void setX5(boolean x5) {
        this.x5 = x5;
        if(x5) this.x = 0;
    }
    public boolean getX5 () {
        return x5;
    }
    public void setX6(boolean x6) {
        this.x6 = x6;
        if(x6) this.x = 1;
    }
    public boolean getX6 () {
        return x6;
    }
    public void setX7(boolean x7) {
        this.x7 = x7;
        if (x7) this.x = 2;
    }
    public boolean getX7 () {
        return x7;
    }
    public void setX8(boolean x8) {
        this.x8 = x8;
        if(x8) this.x=3;
    }
    public boolean getX8 () {
        return x8;
    }
    public void setX9(boolean x9) {
        this.x9 = x9;
        if(x9) this.x = 4;
    }
    public boolean getX9 () {
        return x9;
    }

}
