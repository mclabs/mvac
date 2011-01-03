package org.openxdata.modules.workflows.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class ViewVariableQuestionEvent extends
	GwtEvent<ViewVariableQuestionEvent.Handler>
{

    public static Type<Handler> TYPE = new Type<Handler>();

    public interface Handler extends EventHandler
    {
	public void onEvent();
    }

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
