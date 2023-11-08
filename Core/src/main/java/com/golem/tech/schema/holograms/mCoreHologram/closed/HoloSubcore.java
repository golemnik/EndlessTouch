package com.golem.tech.schema.holograms.mCoreHologram.closed;

import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

public interface HoloSubcore {
    HoloCore getCore();
    String getName ();

    void init ();

    SubcoreType type ();

    static List<HoloSubcore> getSubCores (ModuleLayer layer) {
        return ServiceLoader
                .load(layer, HoloSubcore.class)
                .stream()
                .map(ServiceLoader.Provider::get)
                .collect(Collectors.toList());
    }
}
