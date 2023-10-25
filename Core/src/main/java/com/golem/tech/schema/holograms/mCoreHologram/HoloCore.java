package com.golem.tech.schema.holograms.mCoreHologram;

import com.golem.tech.schema.holograms.mGeneralHolograms.HoloSubCore;
import com.golem.tech.schema.holograms.mTransferHologram.HoloContainer;
import com.golem.tech.schema.holograms.mTransferHologram.HoloPort;
import com.golem.tech.schema.holograms.mTransferHologram.Wayable;

import java.util.Map;

public interface HoloCore extends Wayable {
    void init ();
    <T extends HoloContainer> Map<T, HoloSubCore> moduleSubCores();
    HoloPort getPort ();

}