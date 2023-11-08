package com.golem.tech.schema.holograms.mCoreHologram;

import com.golem.tech.schema.holograms.mCoreHologram.closed.HoloSubcore;
import com.golem.tech.schema.holograms.mFacilityHologram.HoloConveyor;
import com.golem.tech.schema.holograms.mTransferHologram.HoloContainer;

public interface HoloFacilitySubcore extends HoloSubcore {
    HoloConveyor getConveyor ();
    HoloContainer execute (HoloContainer container);

}
