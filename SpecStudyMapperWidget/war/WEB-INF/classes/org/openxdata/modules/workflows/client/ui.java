package org.openxdata.modules.workflows.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ui implements EntryPoint
{
    public void onModuleLoad()
    {
	RootPanel.get().add(new WorkFlowWidget());
    }
}
