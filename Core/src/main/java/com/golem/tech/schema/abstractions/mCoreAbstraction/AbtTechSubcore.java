package com.golem.tech.schema.abstractions.mCoreAbstraction;

import com.golem.tech.schema.abstractions.mCoreAbstraction.closed.AbstractSubcore;
import com.golem.tech.schema.holograms.mCoreHologram.HoloTechSubcore;
import com.golem.tech.schema.holograms.mCoreHologram.closed.SubcoreType;
import com.golem.tech.schema.holograms.mTechHologram.HoloTech;

public abstract class AbtTechSubcore extends AbstractSubcore implements HoloTechSubcore {
    private HoloTech tech;
    public AbtTechSubcore(HoloTech tech) {
        this.tech = tech;
    }

    public AbtTechSubcore () {
        this.tech = null;
    }

    @Override
    public HoloTech getTech() {
        return tech;
    }

    @Override
    public SubcoreType type() {
        return SubcoreType.TECH;
    }
}
