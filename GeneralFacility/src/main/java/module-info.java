import com.golem.tech.FacilitySubcore;
import com.golem.tech.schema.abstractions.mCoreAbstraction.AbtFacilitySubcore;
import com.golem.tech.schema.holograms.mFacilityHologram.HoloConveyor;
import com.golem.tech.schema.holograms.mFacilityHologram.HoloFacility;
import com.golem.tech.schema.holograms.mFacilityHologram.HoloMechanism;

module GeneralFacility {
    requires Core;
    requires AreaTech;
    requires GraphTech;
    requires ServletTransfer;

    uses HoloFacility;
    uses HoloMechanism;
    uses HoloConveyor;

    provides AbtFacilitySubcore with FacilitySubcore;
}