package com.golem.tech.schema.abstractions.mTransferAbsraction;

import com.tech.factory.schema.holograms.mTransferHologram.HoloContainer;
import com.tech.factory.schema.holograms.mTransferHologram.HoloSignature;

public abstract class AbstractContainer implements HoloContainer {
    public final HoloSignature signature;
    public AbstractContainer (HoloSignature signature) {
        this.signature = signature;
    }
    @Override
    public HoloSignature getData() {
        return signature;
    }
}
