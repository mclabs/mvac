package org.openxdata.modules.workflows.client.event;

import org.openxdata.modules.workflows.client.maps.TaskFormDefMap;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class NewTaskFormEvent extends
	GwtEvent<NewTaskFormEvent.Handler>
{

    public interface Handler extends EventHandler
    {
	public void onCreated(TaskFormDefMap map);

	public void onDeleted(TaskFormDefMap map);
    }

    public static Type<Handler> TYPE = new Type<Handler>();
    private ACTION typAction;
    private TaskFormDefMap map;

    public NewTaskFormEvent(TaskFormDefMap map, ACTION typAction)
    {
	this.map = map;
	this.typAction = typAction;
    }

    @Override
    protected void dispatch(Handler handler)
    {
	if (ACTION.DELETE == typAction)
	    handler.onDeleted(map);
	else if (ACTION.ADD == typAction)
	    handler.onCreated(map);
    }

    @Override
    public com.google.gwt.event.shared.GwtEvent.Type<Handler> getAssociatedType()
    {
	return TYPE;
    }

}
