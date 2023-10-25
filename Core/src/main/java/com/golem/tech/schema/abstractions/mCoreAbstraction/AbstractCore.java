package com.golem.tech.schema.abstractions.mCoreAbstraction;

import com.golem.tech.core.coreFunctions.TechLayer;
import com.golem.tech.schema.holograms.mCoreHologram.HoloCore;
import com.golem.tech.schema.holograms.mGeneralHolograms.HoloSubCore;
import com.golem.tech.schema.holograms.mTransferHologram.HoloPort;
import com.golem.tech.schema.holograms.mTransferHologram.HoloWay;
import com.golem.tech.schema.holograms.mTransferHologram.Wayable;

import java.util.HashMap;
import java.util.Map;

public class AbstractCore implements HoloCore {
    private ModuleLayer layer;
    private HoloPort port;
    private final Map<String, HoloSubCore> moduleCoreList = new HashMap<>();
    public AbstractCore () {
        init();
    }
    @Override
    public void init() {
        TechLayer.loadLayer(".");
        this.layer = TechLayer.getLayer();
//        port = HoloPort.getPort(layer);
//        HoloSubCore.getSubCores(layer).forEach(x -> moduleCoreList.put(x.getName(), x));
    }

    @Override
    public Map<String, HoloSubCore> moduleSubCores() {
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
