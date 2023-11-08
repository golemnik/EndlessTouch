package com.golem.tech.schema.abstractions.mTechAbstraction;

import com.golem.tech.schema.basicRealesations.mTransferBasics.CorruptedContainer;
import com.golem.tech.schema.holograms.mTechHologram.HoloTech;
import com.golem.tech.schema.holograms.mTransferHologram.HoloContainer;

public abstract class AbstractTech implements HoloTech {
    @Override
    public HoloContainer execute(HoloContainer container) {
        return new CorruptedContainer();
    }

    @Override
    public HoloContainer transform(HoloContainer container) {
        return null;
    }
}
