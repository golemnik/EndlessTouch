package com.lab.nast.webl3module_n.webapp;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@FacesValidator("yValidator")
public class YValidator implements Validator<Double> {
    private Pattern pattern;

    public YValidator () {
        pattern = Pattern.compile("^(-?[1-3]|-[4-5]|0(\\.0+)?)(\\.0*\\d*[1-9]*)?$");
//        pattern = Pattern.compile("^([1-3])|(-[1-5])|(0)|(([1-2]|0|-[1-4])?\\.0*\\d*[1-9])$");
    }

    @Override
    public void validate(FacesContext context, UIComponent component, Double value) throws ValidatorException {
//        FacesMessage msg1 = new FacesMessage("Значение Y должно быть в диапазоне от -5 до 3.",
//                value.toString());
//        msg1.setSeverity(FacesMessage.SEVERITY_ERROR);
//        throw new ValidatorException(msg1);
        Matcher matcher = pattern.matcher(value.toString());
        if (!matcher.matches()) {
            FacesMessage msg = new FacesMessage("Значение Y должно быть в диапазоне от -5 до 3.",
                        "Значение Y должно быть в диапазоне от -5 до 3. Исключая -0");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }

//        if (value == null || value < -5 || value > 3 || value == -0.0) {
//            throw new ValidatorException(new FacesMessage("Значение Y должно быть в диапазоне от -5 до 3, исключая -0"));
//        }
    }
}
