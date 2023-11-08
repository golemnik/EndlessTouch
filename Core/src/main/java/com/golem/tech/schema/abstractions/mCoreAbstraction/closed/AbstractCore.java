package com.golem.tech.schema.abstractions.mCoreAbstraction.closed;

import com.golem.tech.schema.holograms.mCoreHologram.HoloTechSubcore;
import com.golem.tech.schema.holograms.mCoreHologram.closed.HoloCore;
import com.golem.tech.schema.holograms.mCoreHologram.closed.HoloSubcore;
import com.golem.tech.schema.holograms.mTransferHologram.HoloPort;
import com.golem.tech.schema.holograms.mTransferHologram.Wayable;
import com.golem.tech.schema.holograms.mTransferHologram.HoloWay;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCore implements HoloCore {
    private HoloPort port;
    private final Map<String, HoloTechSubcore> moduleCoreList = new HashMap<>();

    public AbstractCore () {
        init();
    }
    @Override
    public void init() {
    }

    @Override
    public Map<String, HoloTechSubcore> facilityModules() {
        return moduleCoreList;
    }

    @Override
    public void addFacility(HoloTechSubcore facility) {
        moduleCoreList.put(facility.getName(), facility);
    }

    @Override
    public HoloPort getPort() {
        return port;
    }

    @Override
    public HoloWay makeWay(Wayable transmitter, Wayable recipient, HoloPort port) {
        return port.getNewWay(transmitter, recipient);
    }
}
