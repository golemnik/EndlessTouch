package com.lab.nast.webl3module_n.webapp;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named
@RequestScoped
public class BoxBean implements Serializable {
    private List<CheckboxItem> checkboxes;
    private Map<Double, Boolean> selectedCheckboxes;

    public List<CheckboxItem> getCheckboxes() {
        return checkboxes;
    }

    public void setCheckboxes(List<CheckboxItem> checkboxes) {
        this.checkboxes = checkboxes;
    }

    public BoxBean() {
        checkboxes = new ArrayList<>();
        checkboxes.add(new CheckboxItem(-4.0));
        checkboxes.add(new CheckboxItem(-3.0));
        checkboxes.add(new CheckboxItem(-2.0));
        checkboxes.add(new CheckboxItem(-1.0));
        checkboxes.add(new CheckboxItem(0.0));
        checkboxes.add(new CheckboxItem(1.0));
        checkboxes.add(new CheckboxItem(2.0));
        checkboxes.add(new CheckboxItem(3.0));
        checkboxes.add(new CheckboxItem(4.0));
    }

    @PostConstruct
    public void init() {
        selectedCheckboxes = new HashMap<>();
        for (CheckboxItem checkbox : checkboxes) {
            selectedCheckboxes.put(checkbox.getLabel(), false);
        }
    }

    public Map<Double, Boolean> getSelectedCheckboxes() {
        return selectedCheckboxes;
    }

    public void setSelectedCheckboxes(Map<Double, Boolean> selectedCheckboxes) {
        this.selectedCheckboxes = selectedCheckboxes;
    }
}
