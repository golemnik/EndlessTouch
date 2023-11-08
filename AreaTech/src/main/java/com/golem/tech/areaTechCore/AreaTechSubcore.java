package com.golem.tech.areaTechCore;

import com.golem.tech.AreaServletTech;
import com.golem.tech.schema.abstractions.mCoreAbstraction.AbtTechSubcore;
import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.ApplicationScoped;

@ManagedBean
@ApplicationScoped
public class AreaTechSubcore extends AbtTechSubcore {
    public AreaTechSubcore() {
        super(new AreaServletTech());
        getCore().addFacility(this);
    }

}



//        out.print(core.facilityModules());
//        ServletContext servletContext = getServletContext();
//        core.execute(new ForwardContainer(servletContext,
//                new RequestContainer(request, response, new NodataSignature()),
//                new NodataSignature()));