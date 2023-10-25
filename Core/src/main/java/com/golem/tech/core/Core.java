package com.golem.tech.core;

import com.golem.tech.core.coreFunctions.TechLayer;
import com.golem.tech.schema.abstractions.mCoreAbstraction.AbstractCore;
import com.golem.tech.schema.holograms.mGeneralHolograms.HoloSubCore;
import com.golem.tech.schema.holograms.mTransferHologram.HoloContainer;
import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.servlet.ServletException;


@ManagedBean
@ApplicationScoped
public class Core extends AbstractCore {

    public Core () {
    }

//    public Page helloCore () {
//        return new Page().builder()
//                .openTag("html")
//                .openTag("h1")
//                .text("Core!")
//                .closeTag("h1")
//                .closeTag("html")
//                .build();
//    }

    public void execute (HoloContainer container) {
        System.out.println(moduleSubCores());
        moduleSubCores().get("AreaTechSubcore").getTech().execute(container);
    }

}
