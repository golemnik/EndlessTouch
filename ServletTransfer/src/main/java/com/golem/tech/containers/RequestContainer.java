package com.golem.tech.containers;

import com.golem.tech.schema.abstractions.mTransferAbsraction.AbstractContainer;
import com.golem.tech.schema.holograms.mTransferHologram.HoloSignature;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RequestContainer extends AbstractContainer {
    public final HttpServletRequest request;
    public final HttpServletResponse response;
    public RequestContainer(HttpServletRequest request,
                            HttpServletResponse response,
                            HoloSignature signature) {
        super(signature);
        this.request = request;
        this.response = response;
    }

}
