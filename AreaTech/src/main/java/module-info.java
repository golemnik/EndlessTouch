import com.golem.tech.AreaServletTech;
import com.golem.tech.AreaTechSubcore;
import com.golem.tech.schema.holograms.mGeneralHolograms.HoloSubCore;
import com.golem.tech.schema.holograms.mTechHologram.HoloTech;

module AreaTech {
    requires Core;
    requires ServletTransfer;
    requires jakarta.jakartaee.api;

    uses HoloSubCore;
    uses HoloTech;

    provides HoloSubCore with AreaTechSubcore;
    provides HoloTech with AreaServletTech;
}