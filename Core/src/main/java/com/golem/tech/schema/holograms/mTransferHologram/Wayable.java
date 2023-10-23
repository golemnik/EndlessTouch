package com.golem.tech.schema.holograms.mTransferHologram;

public interface Wayable {
    HoloWay makeWay (Wayable transmitter, Wayable recipient, HoloPort port);
}
