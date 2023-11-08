import com.golem.tech.AreaServletTech;
import com.golem.tech.areaTechCore.AreaTechSubcore;
import com.golem.tech.schema.holograms.mCoreHologram.HoloTechSubcore;
import com.golem.tech.schema.holograms.mCoreHologram.closed.HoloSubcore;
import com.golem.tech.schema.holograms.mTechHologram.HoloTech;

module AreaTech {
    requires Core;
    requires ServletTransfer;
    requires jakarta.jakartaee.api;

    exports com.golem.tech.areaTechCore;

    uses HoloSubcore;
    uses HoloTech;

    provides HoloTechSubcore with AreaTechSubcore;
    provides HoloTech with AreaServletTech;
}