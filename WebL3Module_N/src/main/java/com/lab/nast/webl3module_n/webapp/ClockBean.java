package com.lab.nast.webl3module_n.webapp;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.text.SimpleDateFormat;
import java.util.Date;

@Named
@ApplicationScoped
public class ClockBean {
    public String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
}
