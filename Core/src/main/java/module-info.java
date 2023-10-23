import com.golem.tech.schema.holograms.mCoreHologram.HoloCore;

module Core {
    requires jakarta.jakartaee.api;

    exports com.golem.tech.schema.holograms.mFacilityHologram;
    exports com.golem.tech.schema.holograms.mGeneralHolograms;
    exports com.golem.tech.schema.holograms.mTechHologram;
    exports com.golem.tech.schema.holograms.mTransferHologram;

    uses HoloCore;

}