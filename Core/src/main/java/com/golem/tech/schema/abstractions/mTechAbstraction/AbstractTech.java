package com.golem.tech.schema.abstractions.mTechAbstraction;

import com.golem.tech.schema.holograms.mTechHologram.HoloTech;
import com.golem.tech.schema.holograms.mTransferHologram.HoloContainer;
import com.golem.tech.schema.holograms.mTransferHologram.HoloWay;

public abstract class AbstractTech implements HoloTech {
    @Override
    public void execute(HoloContainer container) {

    }

    @Override
    public HoloContainer transform(HoloContainer container) {
        return null;
    }
}
