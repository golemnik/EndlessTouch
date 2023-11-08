package com.golem.tech;

import com.golem.tech.containers.ForwardContainer;
import com.golem.tech.schema.abstractions.mTechAbstraction.AbstractTech;
import com.golem.tech.schema.basicRealesations.mTransferBasics.CorruptedContainer;
import com.golem.tech.schema.basicRealesations.mTransferBasics.exceptions.ContainerTransformException;
import com.golem.tech.schema.holograms.mTransferHologram.HoloContainer;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import java.io.IOException;

public class AreaServletTech extends AbstractTech {
    private void execute (ForwardContainer container) throws ServletException, IOException {
        RequestDispatcher dispatcher = container.servletContext.getRequestDispatcher(AreaCheckServlet.path);
        dispatcher.forward(container.requestContainer.request, container.requestContainer.response);
    }

    @Override
    public HoloContainer execute(HoloContainer container) {
        try {
            execute(transform(container));
        }
        catch (Exception e) {
            System.out.println(">>> " + e.getMessage());
        }
        return new CorruptedContainer();
    }

    @Override
    public ForwardContainer transform (HoloContainer container) {
        ForwardContainer f_container;
        if (container instanceof ForwardContainer) {
            f_container = (ForwardContainer) container;
        }
        else {
            throw new ContainerTransformException(
                    ForwardContainer.class.getSimpleName(),
                    container.getClass().getSimpleName());
        }
        return f_container;
    }
}
