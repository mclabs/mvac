
package org.openxdata.workflow.mobile.model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Vector;
import org.openxdata.db.util.Persistent;
import org.openxdata.db.util.PersistentHelper;

/**
 *
 * @author kay
 */
public class MWorkItemList implements Persistent
{
    private Vector mWorkItems;

    public MWorkItemList()
    {
    }

    public MWorkItemList(Vector mWorkItems)
    {
        this.mWorkItems = mWorkItems;
    }

    public Vector getmWorkItems()
    {
        return mWorkItems;
    }

    public void setmWorkItems(Vector mWorkItems)
    {
        this.mWorkItems = mWorkItems;
    }

    public void write(DataOutputStream dos) throws IOException
    {
       PersistentHelper.write(mWorkItems, dos);
    }

    public void read(DataInputStream dis) throws IOException, InstantiationException, IllegalAccessException
    {
        mWorkItems = PersistentHelper.read(dis, new MWorkItem().getClass());
    }
}
