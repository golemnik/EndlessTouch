package com.golem.tech.containers;

import com.golem.tech.schema.abstractions.mTransferAbsraction.AbstractContainer;
import com.golem.tech.schema.holograms.mTransferHologram.HoloSignature;
import jakarta.servlet.ServletContext;

public class ForwardContainer extends AbstractContainer {
    public final ServletContext servletContext;
    public final RequestContainer requestContainer;

    public ForwardContainer(ServletContext servletContext,
                            RequestContainer requestContainer,
                            HoloSignature signature) {
        super(signature);
        this.servletContext = servletContext;
        this.requestContainer = requestContainer;
    }

}
