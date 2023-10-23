package com.golem.tech.schema.holograms.mCoreHologram;

import com.tech.factory.schema.holograms.mGeneralHolograms.HoloSubCore;
import com.tech.factory.schema.holograms.mTransferHologram.HoloPort;
import com.tech.factory.schema.holograms.mTransferHologram.Wayable;

import java.util.Map;

public interface HoloCore extends Wayable {
    void init ();
    Map<String, HoloSubCore> moduleCoreList();
    HoloPort getPort ();

}