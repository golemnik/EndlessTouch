package com.golem.tech.schema.abstractions.mCoreAbstraction;

import com.golem.tech.schema.abstractions.mCoreAbstraction.closed.AbstractSubcore;
import com.golem.tech.schema.holograms.mCoreHologram.HoloFacilitySubcore;
import com.golem.tech.schema.holograms.mCoreHologram.closed.HoloCore;
import com.golem.tech.schema.holograms.mCoreHologram.closed.SubcoreType;
import com.golem.tech.schema.holograms.mFacilityHologram.HoloConveyor;
import com.golem.tech.schema.holograms.mTechHologram.HoloTech;
import com.golem.tech.schema.holograms.mTransferHologram.HoloContainer;

public abstract class AbtFacilitySubcore extends AbstractSubcore implements HoloFacilitySubcore {
    public AbtFacilitySubcore() {
//        getCore().addFacility(this);
    }

    @Override
    public final SubcoreType type() {
        return SubcoreType.FACILITY;
    }

    @Override
    public HoloConveyor getConveyor() {
        return null;
    }

    @Override
    public HoloContainer execute(HoloContainer container) {
        return null;
    }

}
