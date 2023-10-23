package com.golem.tech.schema.holograms.mGeneralHolograms;


import com.golem.tech.schema.holograms.mTechHologram.HoloTech;

import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

public interface HoloSubCore {
    void init ();
    HoloTech getTech ();
    String getName ();

    static List<HoloSubCore> getSubCores (ModuleLayer layer) {
        return ServiceLoader
                .load(layer, HoloSubCore.class)
                .stream()
                .map(ServiceLoader.Provider::get)
                .collect(Collectors.toList());
    }
}
