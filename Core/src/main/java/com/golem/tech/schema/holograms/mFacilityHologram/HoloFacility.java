package com.golem.tech.schema.holograms.mFacilityHologram;

import java.util.List;

public interface HoloFacility {
    HoloConveyor createConveyor (List<HoloMechanism> mechanisms);

}
