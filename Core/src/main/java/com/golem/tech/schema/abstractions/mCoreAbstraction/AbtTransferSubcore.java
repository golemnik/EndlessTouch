package com.golem.tech.schema.abstractions.mCoreAbstraction;

import com.golem.tech.schema.abstractions.mCoreAbstraction.closed.AbstractSubcore;
import com.golem.tech.schema.holograms.mCoreHologram.closed.HoloCore;
import com.golem.tech.schema.holograms.mCoreHologram.closed.SubcoreType;

public abstract class AbtTransferSubcore extends AbstractSubcore {
    public AbtTransferSubcore() {

    }

    @Override
    public SubcoreType type() {
        return SubcoreType.TRANSFER;
    }
}
