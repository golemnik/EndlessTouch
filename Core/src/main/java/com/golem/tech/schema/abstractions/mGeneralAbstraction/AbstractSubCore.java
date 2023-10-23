package com.golem.tech.schema.abstractions.mGeneralAbstraction;

import com.tech.factory.schema.holograms.mGeneralHolograms.HoloSubCore;
import com.tech.factory.schema.holograms.mTechHologram.HoloTech;

public class AbstractSubCore implements HoloSubCore {
    private final HoloTech tech;
    public AbstractSubCore (HoloTech tech) {
        this.tech = tech;
        init();
    }
    @Override
    public void init() {
    }

    @Override
    public HoloTech getTech() {
        return tech;
    }

    @Override
    public final String getName() {
        return getClass().getSimpleName();
    }
}
