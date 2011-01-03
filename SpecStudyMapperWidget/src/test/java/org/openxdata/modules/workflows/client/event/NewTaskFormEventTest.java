/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openxdata.modules.workflows.client.event;

import com.google.gwt.event.shared.GwtEvent.Type;
import org.easymock.EasyMock;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openxdata.modules.workflows.client.event.NewTaskFormEvent.Handler;

/**
 *
 * @author kay
 */
public class NewTaskFormEventTest
{

    public NewTaskFormEventTest()
    {
    }

    @Test
    public void testDispatch()
    {
        System.out.println("dispatch");
        Handler handler = EasyMock.createMock(Handler.class);
        handler.onCreated(null);

        Handler deleteTestHandler = EasyMock.createMock(Handler.class);
        deleteTestHandler.onDeleted(null);

        EasyMock.replay(handler,deleteTestHandler);
        NewTaskFormEvent instance = new NewTaskFormEvent(null, ACTION.ADD);
        instance.dispatch(handler);

        instance = new NewTaskFormEvent(null, ACTION.DELETE);
        instance.dispatch(deleteTestHandler);

    }

    @Test
    public void testGetAssociatedType()
    {
        System.out.println("getAssociatedType");
        NewTaskFormEvent instance = new NewTaskFormEvent(null, ACTION.ADD);
        Type expResult = NewTaskFormEvent.TYPE;
        Type result = instance.getAssociatedType();
        assertEquals(expResult, result);
    }
}
