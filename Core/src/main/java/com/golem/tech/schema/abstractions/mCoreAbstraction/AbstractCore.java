package com.golem.tech.schema.abstractions.mCoreAbstraction;

import com.tech.factory.schema.holograms.mCoreHologram.HoloCore;
import com.tech.factory.schema.holograms.mGeneralHolograms.HoloSubCore;
import com.tech.factory.schema.holograms.mTransferHologram.HoloPort;
import com.tech.factory.schema.holograms.mTransferHologram.HoloWay;
import com.tech.factory.schema.holograms.mTransferHologram.Wayable;

import java.util.HashMap;
import java.util.Map;

public class AbstractCore implements HoloCore {
    private ModuleLayer layer;
    private HoloPort port;
    private final Map<String, HoloSubCore> moduleCoreList = new HashMap<>();
    public AbstractCore (ModuleLayer layer) {
        this.layer = layer;
        init();
    }
    @Override
    public void init() {
        port = HoloPort.getPort(layer);
        HoloSubCore.getSubCores(layer).forEach(x -> moduleCoreList.put(x.getName(), x));
    }

    @Override
    public Map<String, HoloSubCore> moduleCoreList() {
        return moduleCoreList;
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
