package org.openxdata.modules.workflows.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class ViewLoadItemsEvent extends
	GwtEvent<ViewLoadItemsEvent.Handler>
{

    public interface Handler extends EventHandler
    {
	public void onEvent();
    }

    public static Type<Handler> TYPE = new Type<Handler>();

    @Override
    protected void dispatch(Handler handler)
    {
	handler.onEvent();
    }

    @Override
    public Type<Handler> getAssociatedType()
    {
	return TYPE;
    }
}
