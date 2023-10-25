package com.golem.tech.schema.basicRealesations.mTransferBasics;

import com.golem.tech.schema.abstractions.mTransferAbsraction.AbstractContainer;

public class CorruptedContainer extends AbstractContainer {
    public CorruptedContainer() {
        super(new CorruptedSignature());
    }
}
