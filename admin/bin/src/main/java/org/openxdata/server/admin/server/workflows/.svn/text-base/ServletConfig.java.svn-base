package org.openxdata.server.admin.server.workflows;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Scopes;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import org.openxdata.modules.workflows.server.servlet.WorkItemsServlet;
import org.yawlfoundation.yawl.engine.interfce.interfaceB.InterfaceB_EnvironmentBasedServer;

public class ServletConfig extends GuiceServletContextListener
{
    @Override
    protected Injector getInjector()
    {
        return Guice.createInjector(new ServletConfiguration());
    }

    class ServletConfiguration extends ServletModule
    {
        @Override
        protected void configureServlets()
        {
            bind(InterfaceB_EnvironmentBasedServer.class).in(Scopes.SINGLETON);
            serve("/wf").with(InterfaceB_EnvironmentBasedServer.class);
            serve("/OpenXDataServerAdmin/SpecificationService").with(SpecificationServiceImpl.class);
            serve("/OpenXDataServerAdmin/WorkItemsService").with(WorkItemsServiceImpl.class);
            serve("/OpenXDataServerAdmin/SpecStudyMapService").with(SpecStudyMapServiceImpl.class);
            serve("/wirdownload").with(WorkItemsServlet.class);
        }
    }
}
