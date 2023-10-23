package com.golem.tech.schema.abstractions.mTransferAbsraction;


import com.golem.tech.schema.holograms.mTransferHologram.HoloWay;
import com.golem.tech.schema.holograms.mTransferHologram.Wayable;

public abstract class AbstractWay implements HoloWay {
    private final Wayable transmitter;
    private final Wayable recipient;
    public AbstractWay (Wayable transmitter, Wayable recipient) {
        this.transmitter = transmitter;
        this.recipient = recipient;
    }
    @Override
    public Wayable getTransmitter() {
        return transmitter;
    }

    @Override
    public Wayable getRecipient() {
        return recipient;
    }
}
