package com.golem.tech.schema.holograms.mCoreHologram.closed;

import com.golem.tech.schema.holograms.mCoreHologram.HoloTechSubcore;
import com.golem.tech.schema.holograms.mTransferHologram.HoloPort;
import com.golem.tech.schema.holograms.mTransferHologram.Wayable;

import java.util.Map;

public interface HoloCore extends Wayable {
    void init ();
    Map<String, HoloTechSubcore> facilityModules();
    void addFacility(HoloTechSubcore facility);
    HoloPort getPort ();

}