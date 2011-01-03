/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.modules.workflows.client.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;
import java.util.List;
import org.openxdata.modules.workflows.model.shared.GWTFriendlyWorkItem;

/**
 *
 * @author kay
 */
public class NewWIREvent extends GwtEvent<NewWIREvent.Handler>
{
    public static Type<Handler> TYPE = new Type<Handler>();

    public interface Handler extends EventHandler
    {
        public void onWirLoaded(GWTFriendlyWorkItem wir);

        public void onWirsLoaded(List<GWTFriendlyWorkItem> wirs);

        public void onWirsDeleted(List<GWTFriendlyWorkItem> wirs);

        public void onWirDeleted(GWTFriendlyWorkItem wir);
    }
    private ACTION action;
    private GWTFriendlyWorkItem wir;
    private boolean isList = false;
    private List<GWTFriendlyWorkItem> list;

    public NewWIREvent(GWTFriendlyWorkItem wir)
    {
        this(wir, ACTION.ADD);
    }

    public NewWIREvent(List<GWTFriendlyWorkItem> list)
    {
        this(list, ACTION.ADD);
    }

    public NewWIREvent(List<GWTFriendlyWorkItem> list, ACTION action)
    {
        this.action = action;
        this.list = list;
        isList = true;
    }

    public NewWIREvent(GWTFriendlyWorkItem wir, ACTION action)
    {
        this.action = action;
        this.wir = wir;
        isList = false;
    }

    @Override
    public void dispatch(Handler handler)
    {
        if (action == ACTION.ADD) {
            if (isList)
                handler.onWirsLoaded(list);
            else
                handler.onWirLoaded(wir);
        } else if (action == ACTION.DELETE) {
            if (isList)
                handler.onWirsDeleted(list);
            else
                handler.onWirDeleted(wir);
        }
    }

    @Override
    public Type<Handler> getAssociatedType()
    {
        return TYPE;
    }
}
