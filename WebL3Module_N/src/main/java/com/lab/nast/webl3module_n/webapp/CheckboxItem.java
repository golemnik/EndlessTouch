package com.lab.nast.webl3module_n.webapp;

public class CheckboxItem {
    private Double label;

    private boolean selected;

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    private Double x;

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private String  value;
    public CheckboxItem (Double label){
        this.label = label;
        this.selected = false;

    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    public Double getLabel() {
        return label;
    }

    public void setLabel(Double label) {
        this.label = label;
    }


}
