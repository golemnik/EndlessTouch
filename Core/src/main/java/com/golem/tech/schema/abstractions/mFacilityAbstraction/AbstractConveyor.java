package com.golem.tech.schema.abstractions.mFacilityAbstraction;

import com.golem.tech.schema.basicRealesations.mTransferBasics.CorruptedContainer;
import com.golem.tech.schema.holograms.mFacilityHologram.HoloConveyor;
import com.golem.tech.schema.holograms.mFacilityHologram.HoloMechanism;
import com.golem.tech.schema.holograms.mTransferHologram.HoloContainer;

import java.util.List;

public class AbstractConveyor implements HoloConveyor {
    private final List<HoloMechanism> mechanisms;

    public AbstractConveyor (List<HoloMechanism> mechanisms) {
        this.mechanisms = mechanisms;
    }

    @Override
    public HoloContainer execute(HoloContainer request) {
        if (mechanisms.isEmpty()) return new CorruptedContainer();
        HoloContainer result = request;
        for (HoloMechanism meh : mechanisms) {
            result = meh.execute(result);
        }
        return result;
    }

    @Override
    public List<HoloMechanism> mechanisms() {
        return mechanisms;
    }
}
