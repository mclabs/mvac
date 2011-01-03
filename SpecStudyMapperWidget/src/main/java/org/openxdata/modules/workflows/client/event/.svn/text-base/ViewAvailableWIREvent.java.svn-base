/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.modules.workflows.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

/**
 *
 * @author kay
 */
public class ViewAvailableWIREvent extends GwtEvent<ViewAvailableWIREvent.Handler>
{
    public interface Handler extends EventHandler
    {
        public void onEvent();
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
        handler.onEvent();
    }
}
