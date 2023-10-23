package com.golem.tech.schema.holograms.mTransferHologram;

import java.util.ServiceLoader;

public interface HoloPort {
    HoloWay getNewWay (Wayable transmitter, Wayable recipient);
    static HoloPort getPort (ModuleLayer layer) {
        return ServiceLoader
                .load(layer, HoloPort.class)
                .stream()
                .map(ServiceLoader.Provider::get)
                .toList()
                .get(0);
    }
}
