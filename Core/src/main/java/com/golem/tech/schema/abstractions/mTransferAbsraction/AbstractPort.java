package com.golem.tech.schema.abstractions.mTransferAbsraction;

import com.golem.tech.schema.holograms.mTransferHologram.HoloPort;
import com.golem.tech.schema.holograms.mTransferHologram.HoloWay;
import com.golem.tech.schema.holograms.mTransferHologram.Wayable;

public class AbstractPort implements HoloPort {
    @Override
    public HoloWay getNewWay(Wayable transmitter, Wayable recipient) {
        return null;
    }
}
