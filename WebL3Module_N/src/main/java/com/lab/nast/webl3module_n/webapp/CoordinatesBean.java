package com.lab.nast.webl3module_n.webapp;

import com.lab.nast.webl3module_n.db.DatabaseHelper;
import jakarta.annotation.PostConstruct;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.servlet.http.Cookie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@Named
@ViewScoped
public class CoordinatesBean implements Serializable {

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    private String uuid;

//    private DatabaseHelper databaseHelper;

    private List<PreviousResult> previousResults;
    List<PreviousResult> result = DatabaseHelper.get().getAllResults(getCurrentUuid());

    //List<PreviousResult> results = new ArrayList<>();
    @PostConstruct
    public void init(){
        previousResults = new ArrayList<>();
//        databaseHelper = DatabaseHelper.get();
    }
    public void processResults() {
        PreviousResult result = new PreviousResult();
        result.setX(x);
        result.setY(y);
        result.setR(r);

        if (previousResults == null) {
            previousResults = new ArrayList<>();
        }

        previousResults.add(result);

        DatabaseHelper.get().addResult(getCurrentUuid(), result);
        previousResults = getPreviousResults();
        x = 0.0;
        y = 0.0;
        r = 0.0;
    }

    public List<PreviousResult> getPreviousResults(){
//        return previousResults;

        return DatabaseHelper.get().getAllResults(getCurrentUuid());
    }

    public void setPreviousResults(List<PreviousResult>previousResults){

        this.previousResults=previousResults;
    }
    private double x;
    private double y;
    private double r;
    private String image;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setR(double r) {
        this.r = r;
    }
    public void clearResults() {
        previousResults.clear();
    }

//        БОЛЬШОЙ КОММЕНТАРИЙ О НОВОМ КОДЕ ЧТОБЫ НЕ ПОТЕРЯЛСЯ. КУСОК НОВОГО КОДА!

    private boolean x1 = false;
    private boolean x2 = false;
    private boolean x3 = false;
    private boolean x4 = false;
    private boolean x5 = false;
    private boolean x6 = false;
    private boolean x7 = false;
    private boolean x8 = false;
    private boolean x9 = false;

    public void setX1(boolean x1) {
        this.x1 = x1 ;
        if (x1) this.x =1;
    }
    public boolean getX1 () {
        return x1;
    }
    public void setX2(boolean x2) {
        this.x2 = x2;
        if (x2) this.x = 2;
    }
    public boolean getX2 () {
        return x2;
    }
    public void setX3(boolean x3) {
        this.x3 = x3;
        if (x3) this.x = 3;
    }
    public boolean getX3 () {
        return x3;
    }
    public void setX4(boolean x4) {
        this.x4 = x4;
        if(x4) this.x = 4;
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
        if(x6) this.x = -1;
    }
    public boolean getX6 () {
        return x6;
    }
    public void setX7(boolean x7) {
        this.x7 = x7;
        if (x7) this.x = -2;
    }
    public boolean getX7 () {
        return x7;
    }
    public void setX8(boolean x8) {
        this.x8 = x8;
        if(x8) this.x=-3;
    }
    public boolean getX8 () {
        return x8;
    }
    public void setX9(boolean x9) {
        this.x9 = x9;
        if(x9) this.x = -4;
    }
    public boolean getX9 () {
        return x9;
    }

//        БОЛЬШОЙ КОММЕНТАРИЙ О НОВОМ КОДЕ: НОВЫЙ КОД ЗАКОНЧИЛСЯ!

/*
    public void validateY(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (value == null) {
            return;
        }

        String yString = value.toString();

        try {
            double yValue = Double.parseDouble(yString);

            if (yValue <= -5 || yValue >= 3 || yValue == -0.0 || !yString.matches("-?[0-9]+(\\.[0-9]+)?")) {
                throw new ValidatorException(new FacesMessage("Значение Y должно быть в диапазоне от -5 до 3, исключая -0 и буквы."));
            }
        } catch (NumberFormatException e) {
            throw new ValidatorException(new FacesMessage("Значение Y должно быть числом."));
        }
    }

 */
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

}
