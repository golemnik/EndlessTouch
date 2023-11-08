package com.golem.tech.core;

import com.golem.tech.schema.abstractions.mCoreAbstraction.closed.AbstractCore;
import com.golem.tech.schema.holograms.mTransferHologram.HoloContainer;
import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.ApplicationScoped;


@ManagedBean
@ApplicationScoped
public class Core extends AbstractCore {

    public Core () {
    }

    public void execute (HoloContainer container) {
        System.out.println(facilityModules());
        facilityModules().get("AreaTechSubcore").getTech().execute(container);
//        facilityModules().get("AreaTechSubcore").getTech().execute(container);
    }

}
