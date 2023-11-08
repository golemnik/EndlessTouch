package com.golem.tech.schema.holograms.mTechHologram;


import com.golem.tech.schema.holograms.mFacilityHologram.HoloMechanism;
import com.golem.tech.schema.holograms.mTransferHologram.HoloContainer;

public interface HoloTech extends HoloMechanism {
    HoloContainer execute (HoloContainer container);

    HoloContainer transform(HoloContainer container);
}
