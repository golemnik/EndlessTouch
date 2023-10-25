import com.golem.tech.core.Core;
import com.golem.tech.schema.holograms.mCoreHologram.HoloCore;
import com.golem.tech.schema.holograms.mFacilityHologram.HoloConveyor;
import com.golem.tech.schema.holograms.mFacilityHologram.HoloFacility;
import com.golem.tech.schema.holograms.mFacilityHologram.HoloMechanism;
import com.golem.tech.schema.holograms.mGeneralHolograms.HoloSubCore;
import com.golem.tech.schema.holograms.mTechHologram.HoloTech;
import com.golem.tech.schema.holograms.mTransferHologram.HoloContainer;
import com.golem.tech.schema.holograms.mTransferHologram.HoloPort;
import com.golem.tech.schema.holograms.mTransferHologram.HoloSignature;
import com.golem.tech.schema.holograms.mTransferHologram.HoloWay;

module Core {
    requires jakarta.jakartaee.api;

    //export holograms
    exports com.golem.tech.schema.holograms.mFacilityHologram;
    exports com.golem.tech.schema.holograms.mGeneralHolograms;
    exports com.golem.tech.schema.holograms.mTechHologram;
    exports com.golem.tech.schema.holograms.mTransferHologram;
    //export abstracts
    exports com.golem.tech.schema.abstractions.mTechAbstraction;
    exports com.golem.tech.schema.abstractions.mGeneralAbstraction;
    exports com.golem.tech.schema.abstractions.mTransferAbsraction;
    //export basics
    exports com.golem.tech.schema.basicRealesations.mTransferBasics;
    exports com.golem.tech.schema.basicRealesations.mTransferBasics.exceptions;
    //exports core
    exports com.golem.tech.core;
    exports com.golem.tech.schema.holograms.mTransferHologram.signatureMech;

    uses HoloCore;
    uses HoloConveyor;
    uses HoloFacility;
    uses HoloMechanism;
    uses HoloSubCore;
    uses HoloTech;
    uses HoloContainer;
    uses HoloPort;
    uses HoloSignature;
    uses HoloWay;

    provides HoloCore with Core;
}