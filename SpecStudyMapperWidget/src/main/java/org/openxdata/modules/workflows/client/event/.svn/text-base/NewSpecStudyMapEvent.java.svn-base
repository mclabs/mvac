package org.openxdata.modules.workflows.client.event;

import org.openxdata.modules.workflows.client.maps.SpecStudyMap;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;

public class NewSpecStudyMapEvent extends
	GwtEvent<NewSpecStudyMapEvent.Handler>
{
    public static interface Handler extends EventHandler
    {
	public void mapCreated(SpecStudyMap map);

	public void mapDeleted(SpecStudyMap map);
    }



    public static Type<Handler> TYPE = new Type<Handler>();
    private SpecStudyMap map;
    private ACTION type;

    public NewSpecStudyMapEvent(SpecStudyMap map, ACTION type)
    {
	this.map = map;
	this.type = type;
    }
    
    public NewSpecStudyMapEvent(SpecStudyMap map)
    {
	this.map = map;
	this.type = ACTION.ADD;
    }

    @Override
    protected void dispatch(Handler handler)
    {
	if (type == ACTION.ADD)
	    handler.mapCreated(map);
	else 
	    handler.mapDeleted(map);
    }

    @Override
    public Type<Handler> getAssociatedType()
    {
	return TYPE;
    }

}
