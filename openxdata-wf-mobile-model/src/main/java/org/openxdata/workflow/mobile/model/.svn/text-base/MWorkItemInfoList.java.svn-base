
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
public class MWorkItemInfoList implements Persistent
{
    private Vector workItemInfo;

    public void write(DataOutputStream dos) throws IOException
    {
        PersistentHelper.writeBig(workItemInfo, dos);
    }

    public void read(DataInputStream dis) throws IOException, InstantiationException, IllegalAccessException
    {
        workItemInfo = PersistentHelper.readBig(dis, new MWorkItemInfo().getClass());
    }

    public Vector getWorkItemInfo()
    {
        return workItemInfo;
    }

    public void setWorkItemInfo(Vector workItemInfo)
    {
        this.workItemInfo = workItemInfo;
    }

    
}
