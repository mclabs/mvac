package org.openxdata.modules.workflows.client.gin;

import com.google.gwt.event.shared.HandlerManager;
import com.google.inject.Provider;

public class EventBusProvider implements Provider<HandlerManager>
{

    @Override
    public HandlerManager get()
    {
	return new HandlerManager(null);
    }

}
