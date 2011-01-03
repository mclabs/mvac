package org.openxdata.modules.workflows.server.guice;

import net.customware.gwt.dispatch.server.guice.ActionHandlerModule;

import org.openxdata.modules.workflows.server.handler.GetSpecActionHandler;
import org.openxdata.modules.workflows.server.handler.GetStudiesActionHandler;
import org.openxdata.modules.workflows.server.handler.ParseSpecActionHandler;

public class ActionHandlerConfigModule extends ActionHandlerModule
{

    @Override
    protected void configureHandlers()
    {
	bindHandler(ParseSpecActionHandler.class);
	bindHandler(GetSpecActionHandler.class);
	bindHandler(GetStudiesActionHandler.class);

    }

}
