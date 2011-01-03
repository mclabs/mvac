/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.server.admin.client.events;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

/**
 *
 * @author kay
 */
public class ViewMatchWorkflowsEvent extends GwtEvent<ViewMatchWorkflowsEvent.Handler>
{

    public interface Handler extends EventHandler
    {

        public void onViewed();
    }
    public static Type<Handler> TYPE = new Type<Handler>();

    @Override
    public Type<Handler> getAssociatedType()
    {
        return TYPE;
    }

    @Override
    protected void dispatch(Handler handler)
    {
        handler.onViewed();
    }
}
