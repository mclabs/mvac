package org.openxdata.modules.workflows.server.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

public class ContextListerner extends GuiceServletContextListener
{

    @Override
    protected Injector getInjector()
    {
      return Guice.createInjector(new ActionHandlerConfigModule(),
		new ServletConfigModule());
    }
}
