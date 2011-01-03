package org.openxdata.modules.workflows.server.guice;

import com.google.inject.servlet.ServletModule;
import net.customware.gwt.dispatch.server.service.DispatchServiceServlet;

public class ServletConfigModule extends ServletModule
{

    @Override
    protected void configureServlets()
    {
        serve("*/dispatch").with(DispatchServiceServlet.class);
    }
}
