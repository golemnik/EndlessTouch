package com.lab.nast.webl3module_n.com.example;
import jakarta.annotation.ManagedBean;
import jakarta.annotation.PostConstruct;
import jakarta.faces.model.SelectItem;
import jakarta.faces.view.ViewScoped;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class CheckBox implements Serializable {
    private List<String> selectedValues;
    private List<SelectItem> coordinateOptions;

    public List<String> getSelectedValues() {
        return selectedValues;
    }

    public void setSelectedValues(List<String> selectedValues) {
        this.selectedValues = selectedValues;
    }

    public List<SelectItem> getCoordinateOptions() {
        return coordinateOptions;
    }

    public void setCoordinateOptions(List<SelectItem> coordinateOptions) {
        this.coordinateOptions = coordinateOptions;
    }

    @PostConstruct
    public void init() {
        selectedValues = new ArrayList<>();
        coordinateOptions = new ArrayList<>();
        for (int i = -4; i <= 4; i++) {
            coordinateOptions.add(new SelectItem(String.valueOf(i)));
        }
    }

    public void processSelectedValues() {
        for (String value : selectedValues) {
            System.out.println("Выбрано значение: " + value);
        }
    }
}
