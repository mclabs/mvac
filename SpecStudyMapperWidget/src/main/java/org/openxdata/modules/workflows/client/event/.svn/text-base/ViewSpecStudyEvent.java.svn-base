package org.openxdata.modules.workflows.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class ViewSpecStudyEvent extends GwtEvent<ViewSpecStudyEvent.Handler>
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
    public com.google.gwt.event.shared.GwtEvent.Type<Handler> getAssociatedType()
    {
	return TYPE;
    }

}
