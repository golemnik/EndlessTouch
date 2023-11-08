package com.golem.tech.schema.abstractions.mCoreAbstraction.closed;

import com.golem.tech.core.Core;
import com.golem.tech.schema.holograms.mCoreHologram.closed.HoloCore;
import com.golem.tech.schema.holograms.mCoreHologram.closed.HoloSubcore;
import jakarta.inject.Inject;

public abstract class AbstractSubcore implements HoloSubcore {

    @Inject private Core core;
    public AbstractSubcore() {
    }

    @Override
    public void init() {}

    @Override
    public HoloCore getCore() {
        return core;
    }

    @Override
    public final String getName() {
        return getClass().getSimpleName();
    }
}
