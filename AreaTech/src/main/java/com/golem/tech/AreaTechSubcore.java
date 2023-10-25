package com.golem.tech;

import com.golem.tech.schema.abstractions.mGeneralAbstraction.AbstractSubCore;

public class AreaTechSubcore extends AbstractSubCore {

    public AreaTechSubcore() {
        super(new AreaServletTech());
    }
}
