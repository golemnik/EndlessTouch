package com.golem.tech.schema.holograms.mFacilityHologram;

import com.golem.tech.schema.holograms.mTransferHologram.HoloContainer;

import java.util.List;

public interface HoloConveyor {
    HoloContainer execute (HoloContainer request);
    List<HoloMechanism> conveyor ();
    void addMechanism (HoloMechanism mechanism);

}
