import com.golem.tech.schema.holograms.mCoreHologram.HoloCore;

module Core {
    requires jakarta.jakartaee.api;

    //export holograms
    exports com.golem.tech.schema.holograms.mFacilityHologram;
    exports com.golem.tech.schema.holograms.mGeneralHolograms;
    exports com.golem.tech.schema.holograms.mTechHologram;
    exports com.golem.tech.schema.holograms.mTransferHologram;
    //export abstracts

    uses HoloCore;

}