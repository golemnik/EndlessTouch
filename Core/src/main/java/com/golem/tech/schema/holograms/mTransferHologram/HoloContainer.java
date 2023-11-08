package com.golem.tech.schema.holograms.mTransferHologram;

import com.golem.tech.schema.holograms.mTransferHologram.closed.SignatureStatus;

public interface HoloContainer {
    HoloSignature getData ();
    SignatureStatus status ();
}
