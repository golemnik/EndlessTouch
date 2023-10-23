package com.golem.tech.schema.holograms.mFacilityHologram;

import com.tech.factory.schema.holograms.mTransferHologram.HoloContainer;

import java.util.List;

public interface HoloConveyor {
    HoloContainer execute (HoloContainer request);
    List<HoloMechanism> conveyor ();
    void addMechanism (HoloMechanism mechanism);

}
