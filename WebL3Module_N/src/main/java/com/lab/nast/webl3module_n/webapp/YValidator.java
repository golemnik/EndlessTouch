package com.lab.nast.webl3module_n.webapp;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

@FacesValidator("yValidator")
public class YValidator implements Validator<Double> {

    @Override
    public void validate(FacesContext context, UIComponent component, Double value) throws ValidatorException {
        if (value == null || value < -5 || value > 3 || value == -0.0) {
            throw new ValidatorException(new FacesMessage("Значение Y должно быть в диапазоне от -5 до 3, исключая -0"));
        }
    }
}
