package org.openxdata.modules.workflows.client.event;

import org.openxdata.modules.workflows.model.shared.OSpecification;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class NewSpecicationEvent extends GwtEvent<NewSpecicationEvent.Handler>
{

    public interface Handler extends EventHandler
    {
	public void onSpecLoaded(OSpecification spec);
    }

    public static Type<Handler> TYPE = new Type<Handler>();
    private OSpecification spec;

    public NewSpecicationEvent(OSpecification spec)
    {
	this.spec = spec;
    }

    @Override
    protected void dispatch(Handler handler)
    {
	handler.onSpecLoaded(spec);
    }

    @Override
    public com.google.gwt.event.shared.GwtEvent.Type<Handler> getAssociatedType()
    {
	return TYPE;
    }
}
