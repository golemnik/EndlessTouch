package com.golem.tech.schema.holograms.mTechHologram;


import com.golem.tech.schema.holograms.mTransferHologram.HoloContainer;
import com.golem.tech.schema.holograms.mTransferHologram.HoloWay;

public interface HoloTech {
    void execute (HoloContainer container);

    HoloContainer transform(HoloContainer container);
}
