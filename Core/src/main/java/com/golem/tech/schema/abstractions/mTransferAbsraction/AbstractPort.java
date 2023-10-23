package com.golem.tech.schema.abstractions.mTransferAbsraction;

import com.tech.factory.schema.holograms.mTransferHologram.HoloPort;
import com.tech.factory.schema.holograms.mTransferHologram.HoloWay;
import com.tech.factory.schema.holograms.mTransferHologram.Wayable;

public class AbstractPort implements HoloPort {
    @Override
    public HoloWay getNewWay(Wayable transmitter, Wayable recipient) {
        return null;
    }
}
